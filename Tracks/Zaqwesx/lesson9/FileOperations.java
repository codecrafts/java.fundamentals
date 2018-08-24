import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileOperations {


//    // Метод считывает файл как одну строчку в заданной кодировке
//    static String getFileAsString(String path, Charset encoding) throws IOException {
//        byte[] encoded = Files.readAllBytes(Paths.get(path)); // Считать все байты из файла
//        return new String(encoded, encoding);                 // Создать строчку
//    }

    // Метод считывает файл как набор строчек
    static List<String> parseHtmlFile(String path, Charset encoding) throws IOException, FileNotHtmlException {
        List<String> text = Files.readAllLines(Paths.get(path), encoding);
        int htmlChecker = 0;
        for (String openTag : text) {
            if (openTag.trim().matches("<html.*>")) {
                System.out.println("<html> found.");
                for (String closeTag : text) {
                    if (closeTag.trim().equals("</html>")) {
                        System.out.println("</html> found.");
                        htmlChecker = 1;
                    }
                }
            }
        }

        if (htmlChecker == 1)
            return text;
        else {
            throw new FileNotHtmlException();
        }
    }


    // Метод записывает строчку в заданный файл
    static void writeStringsToFile(String path, List<String> strings) throws  IOException {
        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
        for (String str : strings) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
