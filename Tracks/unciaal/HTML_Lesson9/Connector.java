
import java.io.IOException;
import java.util.ArrayList;

public interface Connector {
    Row getHtmlRow();
    void chekHtml (String row) throws NoHTMLException;
    void createFile(ArrayList<String> findText) throws NoHTMLException, IOException;
}
