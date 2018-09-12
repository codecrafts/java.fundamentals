public class Lesson10 {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("Running mock tests.");
        System.out.println("==========================================");
        MockingTranList mockTest = new MockingTranList();
        mockTest.doTest();

        System.out.println("==========================================");
        System.out.println("Reading data from file");
        System.out.println("==========================================");
        TransactionList transactionList = new TransactionList();
        BudgetCalculator budgetCalc = new BudgetCalculator();
        transactionList.addObserver(budgetCalc);
        transactionList.getTranListFromFile("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson10\\DataSource");
    }
}
