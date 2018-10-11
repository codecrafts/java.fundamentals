import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVDataSource {
    private final String _path_;
    private String _textCSV_;

    public CSVDataSource(String path) throws IOException {
       this._path_ = path;
       getFileAsString();
    }

    public void getFileAsString() throws IOException {
        byte[] encoded;
        encoded = Files.readAllBytes(Paths.get(_path_));
        this._textCSV_ = new String(encoded);
    }

    public String parsingCSV() {
        String texCSV= null;
        return texCSV;
    }
}
