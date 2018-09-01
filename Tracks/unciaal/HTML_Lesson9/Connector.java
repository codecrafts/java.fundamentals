
import java.io.IOException;
import java.util.ArrayList;

public interface Connector {
    public Row get_htmlRow_();
    public void chekHtml (String row) throws ExceptionHandling;
    public void createFile(ArrayList<String> findText) throws ExceptionHandling;
}
