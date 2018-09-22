package lesson10;

import java.time.LocalDate;

public interface CsvDataSourceObservable {

    void registerTransactionsObserver(TransactionsObserver transactoinsList);
    void notifyTransaction(LocalDate date, double sum, String type, String description);
}