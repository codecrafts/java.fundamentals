import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    public static List<String> getFileStrings(String path, Charset encoding) throws IOException {
        return Files.readAllLines(Paths.get(path), encoding);
    }
}
