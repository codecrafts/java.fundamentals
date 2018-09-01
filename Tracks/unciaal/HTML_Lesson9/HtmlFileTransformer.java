
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HtmlFileTransformer implements Connector {
    private final String _path_;
    private Row _htmlRow_;

    public Row get_htmlRow_() {
        return _htmlRow_;
    }

    public HtmlFileTransformer(String path, String startTag, String endTag) throws ExceptionHandling {
        this._path_ = path;
        String row = getFileAsString();
        chekHtml(row);
        this._htmlRow_ = new Row(row,startTag,endTag,0);
    }

    public String getFileAsString() throws ExceptionHandling {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(_path_));
            return new String(encoded);
        } catch (IOException e) {
            // здесь мы бросаем исключение с указанием кода ошибки
            throw new ExceptionHandling(e.getMessage());
        }
    }

    public void createFile(ArrayList<String> findText) throws ExceptionHandling {
        try {
            String textLine;
            Path parentPath = Paths.get(_path_);
            Path newPath = parentPath.resolveSibling("result.txt");
            FileWriter fileWriter = new FileWriter(newPath.toString());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < findText.size(); i++) {
                textLine = findText.get(i);
                bufferedWriter.write(textLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
                // здесь мы бросаем исключение с указанием кода ошибки
                throw new ExceptionHandling(e.getMessage());
            }
    }
    public void chekHtml (String row) throws ExceptionHandling {
        try {
            Row html = new Row(row, "<html>", "</html>",0);
            ArrayList<String> listRow = html.writeArray();
            if (listRow.size() == 0) {
                System.out.println(listRow.get(0));
            }
        }catch (Exception e) {
                throw new ExceptionHandling(e.getMessage());
            }
    }
}


