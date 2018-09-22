package lesson10;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TransactionsObserver {

    ArrayList<TransactionsList.DayResultTransactions> getDayTransactionsList();
    void onUpdate(LocalDate date, double sum, String type, String description);
}
