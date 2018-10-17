import java.util.ArrayList;
import java.util.List;

public class MockTransactionLoader implements Observed{
    private List<String> transactions_;
    private List<Observer> observers_;

    public MockTransactionLoader(String dataString) {
        this.transactions_ = new ArrayList<>();
        this.observers_ = new ArrayList<>();

        for (String str : dataString.split(",")) {
            this.transactions_.add(str);
        }
    }

    public List<String> getMockData() {
        return this.transactions_;
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
        System.out.println("Added transaction: " + string);
        notifyObservers();
    }

    @Override
    public void removeTransaction(String string) {
        this.transactions_.remove(string);
        System.out.println("Removed transaction: " + string);
        notifyObservers();
    }
}
