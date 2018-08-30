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
    private final static int START_POSITION = 0;

    private String htmlFileAsString;            // HTML файл в одной строке
    private List<Header> headerRow;            // список объектов - заголовки

    HtmlRow(String str) {                       // конструктор для тестов
        htmlFileAsString = str;
        headerRow = new ArrayList<>();
    }

    HtmlRow(String path, Charset encoding) throws IOException {
        htmlFileAsString = getFileAsString(path, encoding);
        headerRow = new ArrayList<>();
    }

    @Override
    public void parsingHeader() throws CustomException {
        int indexOpenTag;
        int indexCloseTag;
        String header;

        if (!isHTMLFile()) throw new CustomException("Файл не HTML");

        for (Tags tagType: Tags.values()) {
            int position = START_POSITION;
            do {
                indexOpenTag = htmlFileAsString.indexOf(tagType.getOpenTag(), position);
                indexCloseTag = htmlFileAsString.indexOf(tagType.getCloseTag(), indexOpenTag);
                if (indexOpenTag < START_POSITION || indexCloseTag < START_POSITION)
                    break;
                header = htmlFileAsString.substring(indexOpenTag + LENGTH_OPEN_TAG, indexCloseTag);
                headerRow.add(new Header(header, tagType));
                position = indexCloseTag + LENGTH_CLOSE_TAG;
            } while (true);
        }
    }

    boolean isHTMLFile() {
        return(htmlFileAsString.startsWith("\uFEFF<!DOCTYPE html>") || htmlFileAsString.startsWith("\uFEFF<html>"));
    }

    private String getFileAsString(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Override
    public void saveToFile(String path) throws IOException {
        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

        for (Header header : headerRow) {
                bufferedWriter.write(header.getHeaderString());
                bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    public Header getHeader(int index) {
        return headerRow.get(index);
    }
}