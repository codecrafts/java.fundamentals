
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class HtmlFileTransformer implements Connector {
    private final String _path_;
    private Row _htmlRow_;

    public Row get_HtmlRow_() {
        return _htmlRow_;
    }

    public HtmlFileTransformer(String path, String startTag, String endTag) throws IOException, NoHTMLException {
        this._path_ = path;
        String row = getFileAsString();
        chekHtml(row);
        this._htmlRow_ = new Row(row,startTag,endTag,0);
    }

    public String getFileAsString() throws IOException {
        byte[] encoded;
        encoded = Files.readAllBytes(Paths.get(_path_));
        return new String(encoded);
    }

    public void createFile(ArrayList<String> findText) throws IOException {
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
    }

    public void chekHtml (String row) throws NoHTMLException {
            Row html = new Row(row, "<html>", "</html>",0);
            ArrayList<String> listRow = html.writeArray();
            if (listRow.size() == 0) throw new NoHTMLException("Файл не HTML");
    }
}


