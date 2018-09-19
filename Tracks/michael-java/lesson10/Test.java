package lesson10;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Test {

    public void doTest() throws Exception {

        CsvDataSource csvDataSource = new CsvDataSource();
        TransactionsList transactionsList = new TransactionsList(csvDataSource);
        // тесты метода проверки поля даты
        System.out.println(csvDataSource.isDateValid("01.05.2015") ? "тест пройден" : "тест не пройден");
        System.out.println(!csvDataSource.isDateValid("45.45.4545") ? "тест пройден" : "тест не пройден");
        System.out.println(csvDataSource.isDateValid("01.05.15") ? "тест пройден" : "тест не пройден");
        System.out.println(!csvDataSource.isDateValid("") ? "тест пройден" : "тест не пройден");
        System.out.println(!csvDataSource.isDateValid("11-05-15") ? "тест пройден" : "тест не пройден");
        // тесты метода проверки поля суммы
        System.out.println(csvDataSource.isDigit("5") ? "тест пройден" : "тест не пройден");
        System.out.println(csvDataSource.isDigit("5.09") ? "тест пройден" : "тест не пройден");
        System.out.println(!csvDataSource.isDigit("a") ? "тест пройден" : "тест не пройден");
        System.out.println(!csvDataSource.isDigit("5a5") ? "тест пройден" : "тест не пройден");
        System.out.println(!csvDataSource.isDigit("") ? "тест пройден" : "тест не пройден");
        // тест проверки подсчета итогов
        CsvDataSource csvDataSource_ = new CsvDataSource();
        csvDataSource_.setStrokeUnparsedList_(Arrays.asList("21.08.2018;100000;", "21.08.2018;-300;Бизнес-ланч;Еда;Зарплата", "21.08.2018;-100;Перекус;Еда", "20.08.2018;-300;Аддон к Ведьмаку 3;Развлечения", "19.08.2018;-3000;Шмотки;Покупки"));
        TransactionsList transactionsList_ = new TransactionsList(csvDataSource_);
        csvDataSource_.parsTransactions();
        transactionsList_.calculateDaysCosts();
        LocalDate date = transactionsList_.getDayTransactionsList().get(0).getDate();
        double sum = transactionsList_.getDayTransactionsList().get(0).getDaySum();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println(date.format(formatter).equals("21.08.2018") ? "тест пройден" : "тест не пройден");
        System.out.println(sum == 400 ? "тест пройден" : "тест не пройден");
        date = transactionsList_.getDayTransactionsList().get(1).getDate();
        sum = transactionsList_.getDayTransactionsList().get(1).getDaySum();
        System.out.println(date.format(formatter).equals("20.08.2018") ? "тест пройден" : "тест не пройден");
        System.out.println(sum == 300 ? "тест пройден" : "тест не пройден");
    }
}
