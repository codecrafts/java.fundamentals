public class BudgetCalculator implements Observer {
    private TransactionList transactions_;
    private int balance = 0;

    public BudgetCalculator() {
        this.transactions_ = transactions_;
    }

    @Override
    public void handleEvent(TransactionList transactions) {
        this.transactions_ = transactions;
        calculate();
    }

    private void calculate() {
        for (TransactionList.Transaction trans : this.transactions_.getTransactions_())
            balance = balance + trans.getCash();
        System.out.println("Balance: " + balance);
    }
}
