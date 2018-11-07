import java.util.ArrayList;
import java.util.List;

public class DataLoader implements Observed {
    protected List<String> transactions_ = new ArrayList<>();
    private List<Observer> observers_ = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        boolean obsCheck = true;
        for (Observer obs : this.observers_) {
            if (obs == observer) {
                obsCheck = false;
//                break;
            }
        }

        if (obsCheck == true)
            this.observers_.add(observer);
        else
            System.out.println("This observer already exists.");
    }

    @Override
    public void removeObserver(Observer observer) {
        boolean obsCheck = false;
        for (Observer obs : observers_) {
            if (obs == observer) {
                obsCheck = true;
                break;
            }
        }

        if (obsCheck == true)
            this.observers_.remove(observer);
        else
            System.out.println("No such observer.");
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers_) {
            observer.handleEvent(this.transactions_);
        }
    }

    @Override
    public void addTransaction(String string) {
        boolean tranCheck = true;
        for (String tran : transactions_) {
            if (tran == string) {
                tranCheck = false;
                break;
            }
        }

        if (tranCheck == true) {
            this.transactions_.add(string);
            System.out.println("New changes: " + string);
            notifyObservers();
        }
        else
            System.out.println("This transaction already exists.");
    }

    @Override
    public void removeTransaction(String string) {
        boolean transCheck = false;
        for (String trans : transactions_) {
            if (trans == string) {
                transCheck = true;
                break;
            }
        }

        if (transCheck == true) {
            this.transactions_.remove(string);
            System.out.println("New changes: " + string);
            notifyObservers();
        } else
            System.out.println("No such transaction.");
    }
}
