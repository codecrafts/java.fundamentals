
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File implements Connector {
    private String path;
    private Row htmlRow;

    public File(String path) {
        this.path = path;
    }

    @Override
    public String getFileAsString() throws ExceptionHandling {
        byte[] encoded;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded);
        } catch (IOException e) {
            // здесь мы бросаем исключение с указанием кода ошибки
            throw new ExceptionHandling(e.getMessage(),"FILE_NOT_FOUND_EXCEPTION");
        }
    }

    @Override
    public ArrayList searchTextBetweenTags(String startTag, String endTag) throws  ExceptionHandling {
        ArrayList listRow = new ArrayList();
        if(chekHtml()) {
            String fileString = getFileAsString();
            htmlRow = new Row(fileString, startTag, endTag);
            listRow = htmlRow.fillingArray();
            return listRow;
        }
        return listRow;
    }

    @Override
    public ArrayList searchHyperlinks(ArrayList<String> rowHyperlinks) throws ExceptionHandling {
        rowHyperlinks = searchTextBetweenTags("<a","</a>");
        ArrayList listHref = htmlRow.searchHyperlinks(rowHyperlinks);
        return listHref;
    }

    public void creatFile(ArrayList<String> findText) throws ExceptionHandling {
        try {
            String textLine;
            Path parentPath = Paths.get(path);
            Path newPath = parentPath.resolveSibling("result.txt");
            FileWriter fileWriter = new FileWriter(newPath.toString());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < findText.size(); i++) {
                textLine = findText.get(i);
                bufferedWriter.write(textLine);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException e) {
                // здесь мы бросаем исключение с указанием кода ошибки
                throw new ExceptionHandling(e.getMessage(),"CAN_NOT_CREATE_FILE");
            }
    }
    public boolean chekHtml () throws ExceptionHandling {
        try {
            String fileString = getFileAsString();
            Row html = new Row(fileString, "<html>", "</html>");
            ArrayList listRow = html.fillingArray();
            if (listRow.size() == 0) {
                System.out.println(listRow.get(0));
            }
        }catch (Exception e) {
                throw new ExceptionHandling(e.getMessage(), "BAD_FILE_TYPE");
            }
            return true;
    }
}


