public class MockingTranList implements Observer {
    private final TransactionList.Transaction tranOne = new TransactionList.Transaction("21.08.2018;100000;Аванс;Зарплата");
    private final TransactionList.Transaction tranTwo = new TransactionList.Transaction("21.08.2018;-100000;Аванс;Зарплата");
    private final TransactionList.Transaction tranThree = new TransactionList.Transaction("21.08.2018;10000;Аванс;Зарплата");
    private final TransactionList.Transaction tranFour = new TransactionList.Transaction("21.08.2018;-1000;Продукты в Ашане;Еда");
    private final TransactionList.Transaction tranFive = new TransactionList.Transaction("20.08.2018;-300;Аддон к Ведьмаку 3;Развлечения");
    private final TransactionList.Transaction tranSix = new TransactionList.Transaction("19.08.2018;-3000;Шмотки;Покупки");
    TransactionList transactions_ = new TransactionList();

    public MockingTranList() {
        transactions_.addTransaction(tranOne);
        transactions_.addTransaction(tranTwo);
        transactions_.addTransaction(tranThree);
        transactions_.addTransaction(tranFour);
        transactions_.addTransaction(tranFive);
        transactions_.addTransaction(tranSix);
        System.out.println("Обработаны входные данные:");
        calculate();
    }

    public void doMockTest() {
        transactions_.addObserver(this);
        System.out.println("Добавлена новая транзакция. Текущий баланс:");
        transactions_.addTransaction("19.08.2018;-5000;Шмотки;Покупки");
        System.out.println("Добавлена новая транзакция. Текущий баланс:");
        transactions_.addTransaction("19.08.2018;15000;Еда;Покупки");
        System.out.println("Удалена транзакция. Текущий баланс:");
        transactions_.removeTransaction("19.08.2018;-5000;Шмотки;Покупки");
    }

    @Override
    public void handleEvent(TransactionList transactions) {
        this.transactions_ = transactions;
        calculate();
    }

    private void calculate() {
        int balance = 0;
        for (TransactionList.Transaction trans : this.transactions_.getTransactions_())
            balance = balance + trans.getCash();
        System.out.println("Balance: " + balance);
    }
}
