import java.util.List;

public class BudgetCalculator implements Observer {

    @Override
    public void Calculate(List<TransactionList.Transaction> transactions) {
        int balance = 0;
        for (TransactionList.Transaction trans : transactions)
            balance = balance + trans.cash;
        System.out.println("Balance: " + balance);
    }
}
