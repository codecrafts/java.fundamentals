import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileTransactionLoader extends DataLoader {

    public CsvFileTransactionLoader(String path) {
        try {
            String dataString = new String(Files.readAllBytes(Paths.get(path)), Charset.defaultCharset());
            String[] stringArray = dataString.split("\r\n");
            for (int i = 1; i < stringArray.length; i ++) {
                super.transactions_.add(stringArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTransactions_() {
        return super.transactions_;
    }
}
