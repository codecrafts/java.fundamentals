package lesson10;

import org.mockito.Mock;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Test {

    public void doUnitTest() throws Exception {
        CsvDataSource csvDataSource = new CsvDataSource();

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
    }

    public void doMockTest () throws Exception {

        // тест проверки подсчета итогов
        MockCsvDataSource mockCsvDataSource = new MockCsvDataSource();
        TransactionsList transactionsList = new TransactionsList(mockCsvDataSource);

        mockCsvDataSource.notifyTransaction(LocalDate.of(2018, Month.AUGUST, 21), 100000, "", "");
        mockCsvDataSource.notifyTransaction(LocalDate.of(2018, Month.AUGUST, 21), -300, "Бизнес-ланч", "Еда");
        mockCsvDataSource.notifyTransaction(LocalDate.of(2018, Month.AUGUST, 21), -100, "Перекус", "Еда");
        mockCsvDataSource.notifyTransaction(LocalDate.of(2018, Month.AUGUST, 20), -300, "Аддон к Ведьмаку 3", "Развлечения");
        mockCsvDataSource.notifyTransaction(LocalDate.of(2018, Month.AUGUST, 19), -3000, "Шмотки", "Покупки");

        transactionsList.calculateDaysCosts();
        LocalDate date = transactionsList.getDayTransactionsList().get(0).getDate();
        double sum = transactionsList.getDayTransactionsList().get(0).getDaySum();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.println(date.format(formatter).equals("21.08.2018") ? "тест пройден" : "тест не пройден");
        System.out.println(sum == 400 ? "тест пройден" : "тест не пройден");
        date = transactionsList.getDayTransactionsList().get(1).getDate();
        sum = transactionsList.getDayTransactionsList().get(1).getDaySum();
        System.out.println(date.format(formatter).equals("20.08.2018") ? "тест пройден" : "тест не пройден");
        System.out.println(sum == 300 ? "тест пройден" : "тест не пройден");
    }

    class MockCsvDataSource implements CsvDataSourceObservable {
        private TransactionsObserver transactionsListObserver_;     // наблюдатель

        @Override
        public void registerTransactionsObserver(TransactionsObserver transactionsListObserver) {
            transactionsListObserver_ = transactionsListObserver;
        }

        @Override
        public void notifyTransaction(LocalDate date, double sum, String type, String description) {
            transactionsListObserver_.onUpdate(date, sum, type, description);
        }
    }
}
