//Задача. Домашняя бухгалтерия.
//
//На вход: Файл в формате CSV-файла, который содержит доходы и расходы за календарный месяц. Формат для всех одинаковый. Пример эталонного файла прикреплен ниже.
//На выход: CSV-файл с результатами агрегации данных.
//
//Требования к реализации:
//Реализация должна быть в ООП стиле. Покрыта тестами.
//Должна быть организована обработка исключений (отсутствие файла, неправильный формат файла).
//Должны быть использованы вложенные и/или анонимные классы, а также шаблон проектирования 'Observer' между классом CsvDataSource (класс который парсит CSV-файл) и класс бизнес-логики (агрегации данных).
//Тесты должны быть написаны для класса бизнес-логики с использованием техники мокирования данных. (без использования файла данных) .
//Необходимо посчитать баланс денег (доходы - расходы) за неделю.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Lesson10 {
    public static void main(String[] args) {
        TestsLesson10.doMockTests();

        System.out.println("Введите дату начала рассчета(число.месяц.год):");
        Scanner input = new Scanner(System.in);
        String date = input.next();
        if (TransactionList.Transaction.isValidDate(date)) {
            System.out.println("==========================================");
            System.out.println("Reading data from file");
            System.out.println("==========================================");
            CsvFileTransactionLoader csvFileTransactionLoader = new CsvFileTransactionLoader("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson10\\DataSource");
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            TransactionList transactionList = null;
            try {
               transactionList = new TransactionList(csvFileTransactionLoader.getTransactions_(), formatter.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            csvFileTransactionLoader.addObserver(transactionList);
            csvFileTransactionLoader.addObserver(transactionList);
            csvFileTransactionLoader.addTransaction("01.01.2018;-1000;Продукты в Ашане;Еда");
            csvFileTransactionLoader.addTransaction("01.01.2018;-1000;Продукты в Ашане;Еда");
            csvFileTransactionLoader.removeTransaction("21.08.2018;100;Аванс;Зарплата");
        } else
            System.out.println("Неверная дата.");
    }
}
