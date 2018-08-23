import java.io.*;
import java.util.ArrayList;
public class SearchEngine {
    private BufferedReader textBuffer;
    private int tagСounts = 0;
    private int sibolText;

      public ArrayList findingString(BufferedReader bufferHtml,String startTag, String endTag) throws IOException {
        this.textBuffer = bufferHtml;
        ArrayList<String> text = new ArrayList();
        String row = new String();
        Character ch;
        for (int simbolNumber = 1; ((sibolText = textBuffer.read()) != -1); simbolNumber++) {
            if (searchTagPosition(startTag)) {
                while (!searchTagPosition(endTag)) {
                    ch = (char) sibolText;
                    row += ch.toString();
                    sibolText = textBuffer.read();
                }
                text.add(row);
                row = new String();
            }
        }
        return text;
    }

    public boolean searchTagPosition(String tag) throws IOException{
        do {
            if (tag.charAt(tagСounts) == (char)sibolText) {
                if (tagСounts == tag.length() - 1) {
                    tagСounts = 0;
                    sibolText = textBuffer.read();
                    return true;
                }
                tagСounts++;
                sibolText = textBuffer.read();
            } else {
                tagСounts = 0;
                return false;
            }
        }
        while (tagСounts < tag.length());
        return false;
    }
}
