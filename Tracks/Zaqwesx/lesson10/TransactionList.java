import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TransactionList implements Observed{
    private List<Transaction> transactions_ = new ArrayList<Transaction>();
    private List<Observer> observers_ = new ArrayList<Observer>();

    static class Transaction {
        int cash;
        int semicolonCounter = 0;

        public Transaction(String transactionString) {
            try {
                this.cash = getCashFromTran(transactionString);
            } catch (NotCvsException e) {
                e.printStackTrace();
            }
        }

        public Integer getCashFromTran(String transaction) throws NotCvsException{
            for (int i = 0; i < transaction.length(); i ++) {
                if (transaction.charAt(i) == ';')
                    semicolonCounter ++;

            }

            if (semicolonCounter != 3)
                throw new NotCvsException("Not enough semicolon.");

            String[] transactionParts = transaction.split(";");

            for (int i = 0; i < transactionParts.length; i ++)
                if (transactionParts[i].trim() == null)
                    throw new NotCvsException("Fields are lacking data.");

            if (!isValidDate(transactionParts[0]))
                throw new NotCvsException("Wrong date.");

            try {
                this.cash = Integer.parseInt(transactionParts[1]);
            } catch (NumberFormatException ex) {
                throw new NotCvsException("Wrong cash format.");
            }
            return this.cash;
        }

        public static boolean isValidDate(String date) {
            if (date == null)
                return false;

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            formatter.setLenient(false);

            try {
                formatter.parse(date);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
    }

    public void getTranListFromFile(String path) {
        try {
            List<String> stringList = FileReader.getFileStrings(path, Charset.defaultCharset());
            for (int i = 1; i < stringList.size(); i ++) {
                Transaction trans = new Transaction(stringList.get(i));
                this.addTransaction(trans);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTransaction(Transaction transaction) {
        this.transactions_.add(transaction);
        notifyObservers();
    }

    public void removeTransaction(Transaction transaction) {
        this.transactions_.remove(transaction);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers_.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers_.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers_) {
            observer.Calculate(transactions_);
        }
    }
}
