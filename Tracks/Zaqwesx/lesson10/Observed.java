public interface Observed {
    boolean addObserver(Observer observer);
    boolean removeObserver(Observer observer);
    void notifyObservers();
    boolean addTransaction(String string);
    boolean removeTransaction(String string);
}
