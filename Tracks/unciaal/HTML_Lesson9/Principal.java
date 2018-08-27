
import java.util.ArrayList;

    /*Нужно вычленить все гиперссылки из HTML-документа. Гиперссылки хранятся внутри тега <a href="гиперссылка"></a>
    Для представленного примера выходный файл должен быть со следующим содержанием:
    http://google.com*/
   public class Principal {
        public static void main(String[] args) throws ExceptionHandling {
            try {
                //Test test = new Test();
                //test.testRun();
                Connector htmlFile = new File("D:\\example.txt");
                ((File) htmlFile).chekHtml();
                Row htmlRow = new Row(htmlFile.getFileAsString(),"<a","</a>");
                ArrayList listr = htmlRow.fillingArray();
                ArrayList list = htmlRow.searchHyperlinks(listr);
                ((File) htmlFile).creatFile(list);
            } catch (ExceptionHandling e) {
                ExceptionHandling.processErrorCodes(e);
            }
        }




}
