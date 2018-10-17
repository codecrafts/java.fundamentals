import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestsLesson10 {
    public static void doMockTests() {
        System.out.println("==========================================");
        System.out.println("Running tests with mock data.");
        System.out.println("==========================================");
        String dataString = "21.08.2018;100000;Аванс;Зарплата,27.08.2018;-300;Бизнес-ланч;Еда,28.08.2018;-100;Перекус;Еда";
        MockTransactionLoader mockTransactionLoader = new MockTransactionLoader(dataString);
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        TransactionList transactionList = null;
        try {
            transactionList = new TransactionList(mockTransactionLoader.getMockData(), formatter.parse("21.08.2018"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        mockTransactionLoader.addObserver(transactionList);
        mockTransactionLoader.addTransaction("21.08.2018;-1000;Продукты в Ашане;Еда");
        mockTransactionLoader.removeTransaction("21.08.2018;100000;Аванс;Зарплата");
        mockTransactionLoader.addTransaction("21.08.2018;-1000Продукты в Ашане;Еда");
        mockTransactionLoader.addTransaction("21.15.2018");
        mockTransactionLoader.addTransaction("-1000Продукты в Ашане;Еда");
        mockTransactionLoader.addTransaction("21.15.2018;;;Еда");
        System.out.println("Number of exceptions thrown: " + transactionList.getTotalExceptions());
        if (transactionList.getTotalExceptions() == 4)
            System.out.println("Тест пройден.");
    }
}
