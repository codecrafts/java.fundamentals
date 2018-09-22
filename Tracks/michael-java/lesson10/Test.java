package lesson10;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Test {

    public void doUnitTest() {
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

        mockCsvDataSource.mockNotifyTransaction();
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

    class MockCsvDataSource implements CsvDataSourceObservable {    // mock для CsvDataSource
        private TransactionsObserver transactionsListObserver_;

        @Override
        public void registerTransactionsObserver(TransactionsObserver transactionsListObserver) {
            transactionsListObserver_ = transactionsListObserver;
        }

        @Override
        public void notifyTransaction(LocalDate date, double sum, String type, String description) {}

        void mockNotifyTransaction() {
            notifyTransaction(LocalDate.of(2018, Month.AUGUST, 21), 100000, "", "");
            notifyTransaction(LocalDate.of(2018, Month.AUGUST, 21), -300, "Бизнес-ланч", "Еда");
            notifyTransaction(LocalDate.of(2018, Month.AUGUST, 21), -100, "Перекус", "Еда");
            notifyTransaction(LocalDate.of(2018, Month.AUGUST, 20), -300, "Аддон к Ведьмаку 3", "Развлечения");
            notifyTransaction(LocalDate.of(2018, Month.AUGUST, 19), -3000, "Шмотки", "Покупки");
        }
    }
}
