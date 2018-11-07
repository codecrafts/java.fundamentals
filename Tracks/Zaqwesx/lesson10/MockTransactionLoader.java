import java.util.List;

public class MockTransactionLoader extends DataLoader {

    public MockTransactionLoader(String dataString) {
        for (String str : dataString.split(",")) {
            super.transactions_.add(str);
        }
    }

    public List<String> getMockData() {
        return super.transactions_;
    }
}
