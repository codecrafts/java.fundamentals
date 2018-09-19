package lesson10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionsList implements TransactionsObserver {
    private ArrayList<Transaction> transactionsList_;                         // список транзакций
    private ArrayList<DayItogTransactions> dayItogTransactionsList_;          // итоги транзакций за день

    public TransactionsList(CsvDataSourceObservable csvDataSource) {
        transactionsList_ = new ArrayList<>();
        dayItogTransactionsList_ = new ArrayList<>();
        csvDataSource.registerTransactionsObserver(this);       // регистрируем наблюдателя
    }

    @Override
    public ArrayList<DayItogTransactions> getDayTransactionsList() {
        return dayItogTransactionsList_;
    }

    @Override
    public void onUpdate(LocalDate date, double sum, String type, String description) {
        transactionsList_.add(new Transaction(date, sum, type, description));
    }

    public void calculateDaysCosts() throws Exception {     // считаем итоги расходов за день
        LocalDate date;
        double costsSum;

        dayItogTransactionsList_.clear();
        if (transactionsList_.isEmpty()) throw new Exception("Список транзакций пуст!");

        date = transactionsList_.get(0).date_;
        costsSum = transactionsList_.get(0).sum_ < 0 ? Math.abs(transactionsList_.get(0).sum_): 0;

        for (int i = 1; i < transactionsList_.size(); i++) {
            if (transactionsList_.get(i).date_.equals(date) && transactionsList_.get(i).sum_ < 0)
                costsSum += Math.abs(transactionsList_.get(i).sum_);
            else {
                dayItogTransactionsList_.add(new DayItogTransactions(date, costsSum));
                costsSum = transactionsList_.get(i).sum_ < 0 ? Math.abs(transactionsList_.get(i).sum_) : 0;
                date = transactionsList_.get(i).date_;
            }
            if (i == transactionsList_.size() - 1)
                dayItogTransactionsList_.add(new DayItogTransactions(date, costsSum));
        }
    }

    public class DayItogTransactions {              // итоги транзакций за день
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

    public class Transaction {                      // транзакция
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

    public void saveToFile(String path) throws IOException {
        String SEMICOLON = ";";
        StringBuilder string;

        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
        bufferedWriter.write("Дата;Сумма расходов за день");
        bufferedWriter.newLine();

        for (DayItogTransactions itogTransactions : dayItogTransactionsList_) {
            string = new StringBuilder(String.valueOf(itogTransactions.getDate()));
            string.append(SEMICOLON);
            string.append(String.valueOf(itogTransactions.getDaySum()));
            bufferedWriter.write(String.valueOf(string));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
