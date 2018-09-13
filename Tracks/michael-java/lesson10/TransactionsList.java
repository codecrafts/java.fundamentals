package lesson10;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionsList implements TransactionsObserver {
    private ArrayList<TransactionsList.Transaction> transactionsList_;      // список транзакций
    private ArrayList<DayItogTransactions> dayItogTransactionsList_;        // итоги транзакций за день

    public TransactionsList(CsvDataSourceObservable csvDataSource) {
        transactionsList_ = new ArrayList<>();
        dayItogTransactionsList_ = new ArrayList<>();
        csvDataSource.registerTransactionsObserver(this);
    }

    @Override
    public ArrayList<DayItogTransactions> getDayTransactionsList() {
        return dayItogTransactionsList_;
    }

    @Override
    public void onUpdate(LocalDate date, double sum, String type, String description) {
        transactionsList_.add(new Transaction(date, sum, type, description));
    }

    public void calculateDaysCosts() {
        LocalDate date;
        double costsSum_;

        if (!transactionsList_.isEmpty()) {
            date = transactionsList_.get(0).date_;
            costsSum_ = transactionsList_.get(0).sum_ < 0 ? transactionsList_.get(0).sum_ : 0;

            for (int i = 1; i < transactionsList_.size(); i++) {
                if (transactionsList_.get(i).date_.equals(date) && transactionsList_.get(i).sum_ < 0)
                    costsSum_ += Math.abs(transactionsList_.get(i).sum_);
                else {
                    dayItogTransactionsList_.add(new DayItogTransactions(date, costsSum_));
                    costsSum_ = transactionsList_.get(i).sum_ < 0 ? transactionsList_.get(i).sum_ : 0;
                    date = transactionsList_.get(i).date_;
                }
                if (i == transactionsList_.size() - 1)
                    dayItogTransactionsList_.add(new DayItogTransactions(date, costsSum_));
            }
        } else
            System.out.println("Список транзакций пуст");
    }


    public class DayItogTransactions {              // итогои транзакций за день
        private final LocalDate date_;
        private final double dayCostsSum;

        DayItogTransactions(LocalDate date, double sum) {
            date_ = date;
            dayCostsSum = sum;
        }

        public LocalDate getDate() {
            return date_;
        }

        public double getDaySum() {
            return dayCostsSum;
        }
    }

    public class Transaction {                  // транзакции
        private final LocalDate date_;
        private final double sum_;
        private String type_;
        private String description_;

        public Transaction(LocalDate date, double sum, String type, String description) {
            date_ = date;
            sum_ = sum;
            type_ = type;
            description_ = description;
        }
    }
}
