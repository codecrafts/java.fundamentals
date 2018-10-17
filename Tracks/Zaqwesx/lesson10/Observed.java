public interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void addTransaction(String string);
    void removeTransaction(String string);
}
