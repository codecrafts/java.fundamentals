
import java.io.IOException;
import java.util.ArrayList;

public interface Connector {
    public Row get_HtmlRow_();
    public void chekHtml (String row) throws NoHTMLException;
    public void createFile(ArrayList<String> findText) throws NoHTMLException, IOException;
}
