import java.util.ArrayList;
import java.util.List;

public class DataLoader implements Observed {
    protected List<String> transactions_ = new ArrayList<>();
    private List<Observer> observers_ = new ArrayList<>();

    @Override
    public boolean addObserver(Observer observer) {
        if (!this.observers_.contains(observer)) {
            this.observers_.add((observer));
            System.out.println("Observer added.");
            return true;
        } else {
            System.out.println("This observer already exists.");
            return false;
        }
    }

    @Override
    public boolean removeObserver(Observer observer) {
        if (this.observers_.contains(observer)) {
            this.observers_.remove((observer));
            System.out.println("Observer removed.");
            return true;
        } else {
            System.out.println("This observer does not exists.");
            return false;
        }

    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers_) {
            observer.handleEvent(this.transactions_);
        }
    }

    @Override
    public boolean addTransaction(String string) {
        if (!this.transactions_.contains(string)) {
            this.transactions_.add(string);
            System.out.println("Transaction added.");
            notifyObservers();
            return true;
        } else {
            System.out.println("This transaction already exists.");
            return false;
        }

    }

    @Override
    public boolean removeTransaction(String string) {
        if (this.transactions_.contains(string)) {
            this.transactions_.remove(string);
            System.out.println("Transaction removed.");
            notifyObservers();
            return true;
        } else {
            System.out.println("This transaction does not exists.");
            return false;
        }
    }
}
