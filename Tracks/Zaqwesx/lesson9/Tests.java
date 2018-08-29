import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static boolean readAbsentFile() {
        // Пытаемся считать файл, которого нет.
        try {
            List<String> text = FileOperations.getFileStrings("c:\\AbsentFile.txt", Charset.defaultCharset());
            return false;
        } catch (IOException e) {
            System.out.println("File not found.");
            return true;
        }
    }

    public static boolean readNotHtmlFile() {
        // Пытаемся считатать не Html файл.
        try {
            List<String> sourceText = FileOperations.getFileStrings("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\NotHtml.txt", Charset.defaultCharset());
            List<String> checkHtmlText = FileOperations.checkHtml(sourceText);
            return false;
        } catch (IOException e) {
            System.out.println("File not found.");
            return false;
        } catch (FileNotHtmlException ex) {
            System.out.println("File is not Html.");
            return true;
        }
    }

    // Пытаемся писать в read-only файл.
    public static boolean tryWritingToReadOnly() {
        List<String> text = new ArrayList<String>();
        text.add("Some text.");

        try {
            FileOperations.writeStringsToFile("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\ReadOnly.txt", text);
            return false;
        } catch (IOException e) {
            System.out.println("Can not write into file.");
            return true;
        }
    }

    public static boolean checkTagsRemoving() {
        boolean checker = false;

        try {
            List<String> text = FileOperations.getFileStrings("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\SourceText.html", Charset.defaultCharset());
            text = FileOperations.checkHtml(text);
            text = FileOperations.removeTagsFromList(text);
            FileOperations.writeStringsToFile("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\ResultText", text);
            String resultText = FileOperations.getFileAsString("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\ResultText", Charset.defaultCharset());

            for (int i = 0; i < resultText.length(); i ++) {
                if (!(resultText.charAt(i) == '>' || resultText.charAt(i) == '<'))
                    checker = true;
            }
        } catch (IOException e) {
            System.out.println("File IOException");
        } catch (FileNotHtmlException e) {
            System.out.println("File is not Html.");
        }

        return checker;
    }
}
