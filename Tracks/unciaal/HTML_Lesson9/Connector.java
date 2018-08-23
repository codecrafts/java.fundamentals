import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface Connector {
    void sendFile(String path) throws IOException;
    void searchText(String startTag,String EndTag) throws IOException;
}
