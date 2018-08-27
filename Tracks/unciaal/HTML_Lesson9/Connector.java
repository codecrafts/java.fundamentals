
import java.io.IOException;
import java.util.ArrayList;

public interface Connector {
    public String getFileAsString() throws ExceptionHandling;
    public ArrayList searchTextBetweenTags(String startTag,String endTag) throws ExceptionHandling;
    public ArrayList searchHyperlinks(ArrayList<String> rowHyperlinks) throws ExceptionHandling;
}
