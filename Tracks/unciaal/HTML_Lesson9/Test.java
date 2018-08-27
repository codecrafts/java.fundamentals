import java.util.ArrayList;

public class Test {
    public void testRun() throws ExceptionHandling {
        if (fileCheck() && structureCheck()) System.out.println("тест пройден");
        else {
            System.out.println("тест не пройден");
        }
    }


    public boolean fileCheck() throws ExceptionHandling {
        try {
            Connector htmlFile = new File("D:\\noFile.txt");
            Row htmlRow = new Row(htmlFile.getFileAsString(),"<a","</a>");
            ArrayList listr = htmlRow.fillingArray();
            ArrayList list = htmlRow.searchHyperlinks(listr);
            ((File) htmlFile).creatFile(list);
        } catch (ExceptionHandling e) {
            System.out.println("Тест на отсутсвие файла пройден");
            ExceptionHandling.processErrorCodes(e);
            return true;
        }
        return false;
    }
    public boolean structureCheck(){
            Row html = new Row("a","<html>","</html>");
            ArrayList listRow = html.fillingArray();
            if (listRow.size() == 0) {
                return true;
            }
            return false;
    }
}
