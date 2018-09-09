
import java.io.IOException;
import java.util.ArrayList;

    /*Нужно вычленить все гиперссылки из HTML-документа. Гиперссылки хранятся внутри тега <a href="гиперссылка"></a>
    Для представленного примера выходный файл должен быть со следующим содержанием:
    http://google.com*/
   public class Principal {
        public static void main(String[] args) throws NoHTMLException, IOException {
            Test.makeTests();
                Connector htmlFile = new HtmlFileTransformer("D:\\example.txt","<a","</a>");
                Row fileString = htmlFile.getHtmlRow();
                ArrayList<String> findTagRow = fileString.writeArray();
                ArrayList<String> ref = fileString.getHyperlinks(findTagRow);
                htmlFile.createFile(ref);
        }
}
