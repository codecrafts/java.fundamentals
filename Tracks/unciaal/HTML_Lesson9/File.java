import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File implements Connector {
    private BufferedReader textHtml;
    private String path;

    public File(String path) throws IOException {
        this.path = path;
        this.textHtml = Files.newBufferedReader(Paths.get(path));
    }

    public void sendFile(String path) throws IOException {
        File textHtml = new File(path);
    }
    public void searchText (String startTag, String endTag) throws IOException {
        ArrayList findText;
        SearchEngine newSearch = new  SearchEngine();
        findText = newSearch.findingString(textHtml,startTag,endTag);
        creatFile(findText);
    }
    public void creatFile(ArrayList<String> findText) throws IOException {
        String textLine;
        String textOneSimbol;
        Path parentPath = Paths.get(path);
        Path newPath = parentPath.resolveSibling("result.txt");
        FileWriter fileWriter = new FileWriter(newPath.toString());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < findText.size(); i++ ) {
            textLine = findText.get(i);
            bufferedWriter.write(textLine);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}

