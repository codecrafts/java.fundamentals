import java.io.IOException;
import java.util.ArrayList;

/*Нужно вычленить все гиперссылки из HTML-документа. Гиперссылки хранятся внутри тега <a href="гиперссылка"></a>
    Для представленного примера выходный файл должен быть со следующим содержанием:
    http://google.com*/
   public class Principal {
        public static void main(String[] args) throws IOException {
            Connector htmlFile = new File("D:\\example.txt");
            htmlFile.searchText("<a href=\"","\">");
        }
}
