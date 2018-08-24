package lesson9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class HtmlRow {
    private final static int FIRST_LINE = 0;
    private List<String> noParsingRow_;
    private List<Header> headerRow_;

    public HtmlRow(String path, Charset encoding) throws IOException {
        noParsingRow_ = Files.readAllLines(Paths.get(path), encoding) ;
        headerRow_ = new ArrayList<>();
    }

    public HtmlRow(String str) {
        noParsingRow_ = new ArrayList<>();
        noParsingRow_.add(str);
    }

    public boolean isHTML(){
        String str = noParsingRow_.get(FIRST_LINE).trim();
        return (str.contains("<!DOCTYPE html>") || str.contains("<html>"));
    }

    public void headerParsing() throws CustomException {
        if (!isHTML()) throw new CustomException("Файл не HTML");

        for (String str : noParsingRow_) {
            try {
                headerRow_.add(new Header(str));
            } catch (CustomException ex) {
                System.out.println (ex.getMessage());
            }
        }
    }

    public void saveToFile(String path) throws IOException  {
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
}
