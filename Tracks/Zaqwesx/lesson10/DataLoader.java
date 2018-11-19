import java.util.ArrayList;
import java.util.List;

public class DataLoader implements Observed {
    protected List<String> transactions_ = new ArrayList<>();
    private List<Observer> observers_ = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (!this.observers_.contains(observer)) {
            this.observers_.add((observer));
            System.out.println("Observer added.");
        } else
            System.out.println("This observer already exists.");
    }

    @Override
    public void removeObserver(Observer observer) {
        if (this.observers_.contains(observer)) {
            this.observers_.remove((observer));
            System.out.println("Observer removed.");
        } else
            System.out.println("This observer does not exists.");

    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers_) {
            observer.handleEvent(this.transactions_);
        }
    }

    @Override
    public void addTransaction(String string) {
        if (!this.transactions_.contains(string)) {
            this.transactions_.add(string);
            System.out.println("Transaction added.");
            notifyObservers();
        } else
            System.out.println("This transaction already exists.");

    }

    @Override
    public void removeTransaction(String string) {
        if (this.transactions_.contains(string)) {
            this.transactions_.remove(string);
            System.out.println("Transaction removed.");
            notifyObservers();
        } else
            System.out.println("This transaction does not exists.");
    }
}
