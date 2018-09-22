/*
Урок №10. Вложенные классы. Анонимные Классы. Шаблон проектирования 'Observer'. Техника мокирования данных.
Задача. Домашняя бухгалтерия.

На вход: Файл в формате CSV-файла, который содержит доходы и расходы за календарный месяц. Формат для всех одинаковый. Пример эталонного файла прикреплен ниже.
На выход: CSV-файл с результатами агрегации данных.

Требования к реализации:
Реализация должна быть в ООП стиле. Покрыта тестами.
Должна быть организована обработка исключений (отсутствие файла, неправильный формат файла).
Должны быть использованы вложенные и/или анонимные классы, а также шаблон проектирования 'Observer' между классом CsvDataSource (класс который парсит CSV-файл) и класс бизнес-логики (агрегации данных).
Тесты должны быть написаны для класса бизнес-логики с использованием техники мокирования данных. (без использования файла данных).

Необходимо посчитать общие расходы за день.  */
package lesson10;

import java.io.IOException;
import java.nio.charset.Charset;

public class Lesson10 {
    public static void main(String[] args) throws Exception {

        CsvDataSource csvDataSource;

        try {
            csvDataSource = new CsvDataSource("D:\\example.csv", Charset.defaultCharset());
            TransactionsList transactionsList = new TransactionsList(csvDataSource);
            csvDataSource.parsTransactions();
            transactionsList.calculateDaysCosts();
            transactionsList.saveToFile("D:\\result.csv");
            Test test = new Test();
            test.doUnitTest();
            test.doMockTest();
        } catch (IOException | noValidFileExeption e) {
            System.out.println("IOException is thrown " + e.getMessage() + e.toString());
            e.printStackTrace();
        }
    }
}