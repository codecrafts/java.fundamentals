public class MockingTranList {
    private final TransactionList transactions = new TransactionList();
    private final BudgetCalculator budgetCalc = new BudgetCalculator();
    private final TransactionList.Transaction tranOne = new TransactionList.Transaction("21.08.2018;100000;Аванс;Зарплата");
    private final TransactionList.Transaction tranTwo = new TransactionList.Transaction("gg;-100000;Аванс;Зарплата");
    private final TransactionList.Transaction tranThree = new TransactionList.Transaction("21.08.2018;dfg;Аванс;Зарплата");
    private final TransactionList.Transaction tranFour = new TransactionList.Transaction("21.08.2018;-1000;Продукты в Ашане;Еда");
    private final TransactionList.Transaction tranFive = new TransactionList.Transaction("20.08.2018;-300;Аддон к Ведьмаку 3;Развлечения");
    private final TransactionList.Transaction tranSix = new TransactionList.Transaction("19.08.2018;-3000;Шмотки;Покупки");


    public void doTest() {
        transactions.addObserver(budgetCalc);
        transactions.addTransaction(tranOne);
        transactions.addTransaction(tranTwo);
        transactions.addTransaction(tranThree);
        transactions.addTransaction(tranFour);
        transactions.addTransaction(tranFive);
        transactions.addTransaction(tranSix);
        transactions.removeTransaction(tranSix);
    }

}
