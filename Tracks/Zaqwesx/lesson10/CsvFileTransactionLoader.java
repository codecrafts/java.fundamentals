import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFileTransactionLoader implements Observed {
    private List<String> transactions_;
    private List<Observer> observers_;

    public CsvFileTransactionLoader(String path) {
        this.transactions_ = new ArrayList<>();
        this.observers_ = new ArrayList<>();

        try {
            String dataString = new String(Files.readAllBytes(Paths.get(path)), Charset.defaultCharset());
            String[] stringArray = dataString.split("\r\n");
            for (int i = 1; i < stringArray.length; i ++) {
                this.transactions_.add(stringArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTransactions_() {
        return transactions_;
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
            observer.handleEvent(this.transactions_);
        }
    }

    @Override
    public void addTransaction(String string) {
        this.transactions_.add(string);
        notifyObservers();
    }

    @Override
    public void removeTransaction(String string) {
        this.transactions_.remove(string);
        notifyObservers();
    }
}
