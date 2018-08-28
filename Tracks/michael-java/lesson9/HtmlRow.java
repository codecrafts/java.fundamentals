package lesson9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HtmlRow implements HtmlRowI{
    private final static int LENGTH_OPEN_TAG = 4;
    private final static int LENGTH_CLOSE_TAG = 5;

    private String htmlFileAsString;            // HTML файл в одной строке
    private List<Header> headerRow_;            // список объектов - заголовки

    HtmlRow(String str) {                       // конструктор для тестов
        htmlFileAsString = str;
        headerRow_ = new ArrayList<>();
    }

    HtmlRow(String path, Charset encoding) throws IOException {
        htmlFileAsString = getFileAsString(path, encoding);
        headerRow_ = new ArrayList<>();
    }

    @Override
    public void parsingHeader() throws CustomException {
        int indexOpenTag;
        int indexCloseTag;
        String header;

        if (!isHTML()) throw new CustomException("Файл не HTML");

        for (Tags tagType: Tags.values()) {
            int position = 0;
            do {
                indexOpenTag = htmlFileAsString.indexOf(tagType.getOpenTag(), position);
                indexCloseTag = htmlFileAsString.indexOf(tagType.getCloseTag(), indexOpenTag);
                if (indexOpenTag < 0 || indexCloseTag < 0)
                    break;
                System.out.println ("length" + htmlFileAsString.length () + " position=" + position + " i1:" + indexOpenTag + " i2:" + indexCloseTag + " подстрока: " + htmlFileAsString.substring(indexOpenTag + LENGTH_OPEN_TAG, indexCloseTag));
                header = htmlFileAsString.substring(indexOpenTag + LENGTH_OPEN_TAG, indexCloseTag);
                headerRow_.add(new Header(header, tagType));
                position = indexCloseTag + LENGTH_CLOSE_TAG;
            } while (true);
        }
    }

    boolean isHTML() throws CustomException {
        if (htmlFileAsString.equals("")) throw new CustomException("HTML файл не проинициализирован");
        return (htmlFileAsString.startsWith("\uFEFF<!DOCTYPE html>") || htmlFileAsString.startsWith("\uFEFF<html>"));
    }

    private String getFileAsString(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Override
    public void saveToFile(String path) throws CustomException, IOException {
        if(headerRow_ == null) throw new CustomException("Файл не содержит заголовков");

        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

        for (Header header : headerRow_) {
            if (header.getHeaderType() != null) {
                bufferedWriter.write(header.getHeaderString());
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
    }

    public List<Header> getHeaderRow_() {
        return headerRow_;
    }

    public Header getHeader(int index) {
        return headerRow_.get(index);
    }
}