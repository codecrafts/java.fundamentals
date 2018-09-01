import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class Tests {
        public static boolean test() {
            String absentFilePath = "c:\\AbsentFile.txt";
            String notHtmlFilePath = "C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\NotHtml.txt";
            String readOnlyFilePath = "C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\ReadOnly.txt";
            String validHtmlFilePath = "C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\SourceText.html";
            String validResultFilePath = "C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\ResultText";
            int testCounter = 0;

            if (!removeTagsTest(absentFilePath, validResultFilePath, Charset.defaultCharset()))
                testCounter++;
            if (!removeTagsTest(notHtmlFilePath, validResultFilePath, Charset.defaultCharset()))
                testCounter++;
            if (!removeTagsTest(validHtmlFilePath, readOnlyFilePath, Charset.defaultCharset()))
                testCounter++;
            if (removeTagsTest(validHtmlFilePath, validResultFilePath, Charset.defaultCharset()))
                testCounter++;

            if (testCounter == 4)
                return true;
            else
                return false;
        }

        public static boolean removeTagsTest(String sourcePath, String resultPath, Charset encoding) {
            boolean checker = false;
            try {
                List<String> text = FileOperations.getFileStrings(sourcePath, Charset.defaultCharset());
                text = FileOperations.checkHtml(text);
                text = FileOperations.removeTagsFromList(text);
                FileOperations.writeStringsToFile(resultPath, text);
                String resultText = FileOperations.getFileAsString(resultPath, Charset.defaultCharset());

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
