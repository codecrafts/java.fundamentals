/*
На вход: HTML-документ - текстовый файл с разметкой в HTML-формате. Пример файлов приаттачен в данном уроке.
На выход: Текстовый файл с результатом.

Разметка в HTML-документе производится с помощью тегов. Теги - это английские символы внутри треугольных скобочек, например <img src="1.jpeg"></img>
Считать, что в HTML нет встроенного javascript и css кода, только HTML теги и обычный текст.

Требования к реализации:
Реализация должна быть в ООП стиле. Покрыта тестами.
Должна быть организована обработка исключений (отсутствие файла, ошибка при создании файла и прочее). Также должна быть создано свое исключение на то, если файл не HTML-файл. (ошибка парсинга)

Нужно вычленить все заглавия из HTML-документа. Заглавия хранятся внутри тегов <hx>Заглавие</hx>, где x - это число.
Для представленного примера выходный файл должен быть со следующим содержанием:
Заголовок
Новый заголовок */

package lesson9;

import java.nio.charset.Charset;
import java.io.IOException;

public class Lesson9 {
    public static void main(String[] args) throws IOException, CustomException {
        HtmlRowI htmlRow;

        try {
            htmlRow = new HtmlRow("D:\\example.txt", Charset.defaultCharset());
            htmlRow.parsingHeader();
            htmlRow.saveToFile("D:\\result.txt");
            Test.doTest();
        } catch (CustomException e) {
            System.out.println (e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException is thrown " + e.getMessage() + e.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


