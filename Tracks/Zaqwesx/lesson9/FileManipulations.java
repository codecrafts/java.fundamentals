import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileManipulations {
    static List<String> getFileStrings(String path, Charset encoding) {
        List<String> text = new ArrayList<>();

        try {
            text = FileOperations.parseHtmlFile(path, encoding);
            System.out.println("File converted to strings.");
        } catch (IOException exc) {
            System.out.println("IOException is thrown " + exc.toString());
        } catch (FileNotHtmlException exc) {
            System.out.println("File is not Html. Exception called.");
        }
        return text;
    }

    static String removeTagsFromString(String string) {
        int textStartIndex = 0;
        int textEndIndex = 0;
        boolean textSign = false;
        String resultString = "";

        for ( int i = 0; i < string.length(); i ++) {
            if (string.charAt(i) == '>')
                textSign = true;
            else if (string.charAt(i) == '<')
                textSign = false;
            else if (textSign)
                resultString = resultString + string.charAt(i);
        }
        return resultString;
    }

    static List<String> removeTagsFromList(List<String> strings) {
        List<String> resultList = new ArrayList<String>();
        String string;

        for (String str : strings) {
            string = removeTagsFromString(str);
            if(string.length() != 0)
                resultList.add(string);
        }

        return resultList;
    }


    static void writeStringsToFile(String path, List<String> strings) {
        try {
            FileOperations.writeStringsToFile(path, strings);
            System.out.println("File written.");
        } catch (IOException exc) {
            System.out.println("IOException is thrown " + exc.toString());
        }
    }
}
