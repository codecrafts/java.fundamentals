import java.util.List;

public interface Observer {
    void Calculate(List<TransactionList.Transaction> transactions);
}
