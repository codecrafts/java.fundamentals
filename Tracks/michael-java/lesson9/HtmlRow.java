package lesson9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HtmlRow{
    private final static int LENGTH_OPEN_TAG = 4;
    private final static int START_POSITION = 0;
    private final static int NEXT_STEP = 1;

    private String htmlFileAsString_;           // HTML файл в одной строке
    private List<Header> headerRow_;            // список объектов - заголовки

    HtmlRow(String str) {                       // конструктор для тестов
        htmlFileAsString_ = str;
        headerRow_ = new ArrayList<>();
    }

    HtmlRow(String path, Charset encoding) throws IOException {
        htmlFileAsString_ = getFileAsString(path, encoding);
        headerRow_ = new ArrayList<>();
    }

    public void parsingHeader() throws NoHTMLException {
        int positionOpenTag;
        int positionCloseTag;
        String header;

        if (!isHTMLFile()) throw new NoHTMLException("Файл не HTML");

            int currentPosition = START_POSITION;
            do {
                positionOpenTag = htmlFileAsString_.indexOf ("<h", currentPosition);
                if (positionOpenTag < START_POSITION) break;

                for (Tags tagType: Tags.values()) {
                    if (tagType.getOpenTag().equals(htmlFileAsString_.substring(positionOpenTag, positionOpenTag + LENGTH_OPEN_TAG))) {
                        positionCloseTag = htmlFileAsString_.indexOf(tagType.getCloseTag(), positionOpenTag + LENGTH_OPEN_TAG);
                        if (positionCloseTag < START_POSITION) throw new NoHTMLException("Ошибка тега заголовка: нет закрывающего тега");

                        header = htmlFileAsString_.substring(positionOpenTag + LENGTH_OPEN_TAG, positionCloseTag);
                        headerRow_.add (new Header (header, tagType));
                        currentPosition = positionCloseTag;
                    } else currentPosition = positionOpenTag + NEXT_STEP;
                }
            } while (true);
    }

    boolean isHTMLFile() {
        return(htmlFileAsString_.startsWith("\uFEFF<!DOCTYPE html>") || htmlFileAsString_.startsWith("\uFEFF<html>"));
    }

    private String getFileAsString(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public void saveToFile(String path) throws IOException {
        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

        for (Header header : headerRow_) {
                bufferedWriter.write(header.getHeaderString());
                bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    public Header getHeader(int index) {
        return headerRow_.get(index);
    }
}