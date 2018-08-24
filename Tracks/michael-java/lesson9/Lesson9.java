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
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;

public class Lesson9 {
    public static void main(String[] args) throws IOException {
        HtmlRow htmlRow;

        try {
            Files.readAllLines ( Paths.get ( "D:\\example.txt" ) );
        } catch (IOException e) {
            System.out.println ( "File not found " + e.getMessage () );
        } finally {
            htmlRow = new HtmlRow ( "D:\\example.txt", Charset.defaultCharset () );
        }

        try {
            htmlRow.headerParsing ();
        } catch (CustomException e) {
            System.out.println (e.getMessage());
        }

        try {
            htmlRow.saveToFile ( "d:\\result.txt" );
        } catch (IOException e) {
            System.out.println ( "IOException is thrown " + e.toString () );
        }

        HtmlRow htmlRowTest = new HtmlRow("<html>");
        System.out.println (htmlRowTest.isHTML() ?  "тест пройден" : "тест не пройден");

        htmlRowTest = new HtmlRow("<!DOCTYPE html>");
        System.out.println (htmlRowTest.isHTML() ?  "тест пройден" : "тест не пройден");

        htmlRowTest = new HtmlRow("qwerty");
        System.out.println (!htmlRowTest.isHTML() ?  "тест пройден" : "тест не пройден");

        try {
            Header headerTest = new Header("<h1>Заголовок</h1>");
            System.out.println (headerTest.getHeaderString() != null && headerTest.getHeaderType() != null  ?  "тест пройден" : "тест не пройден");
        } catch (CustomException e) {
            e.printStackTrace();
        }

        try {
            Header headerTest = new Header("<h1>Нет закрывающего тэга");
            System.out.println (headerTest.getHeaderString() == null && headerTest.getHeaderType() == null  ?  "тест пройден" : "тест не пройден");
        } catch (CustomException e) {
            e.printStackTrace();
        }

        try {
            Header headerTest = new Header("Нет открывающего тэга</h1>");
            System.out.println (headerTest.getHeaderString() == null && headerTest.getHeaderType() == null  ?  "тест пройден" : "тест не пройден");
        } catch (CustomException e) {
            e.printStackTrace();
        }

        try {
            Header headerTest = new Header("Нет тэгов");
            System.out.println (headerTest.getHeaderType() == null  ?  "тест пройден" : "тест не пройден");
        } catch (CustomException e) {
            e.printStackTrace();
        }

        try {
            Header headerTest = new Header("");
            System.out.println ("тест не пройден");
        } catch (CustomException e) {
            System.out.println ("тест пройден");
        }


    }
}


