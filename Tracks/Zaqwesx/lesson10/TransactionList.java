import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionList implements Observer{
    private List<Transaction> transactions_;
    private int totalExceptions;
    private Date date;

    public int getTotalExceptions() {
        return totalExceptions;
    }

    public TransactionList(List<String> stringList, Date date) {
        this.transactions_ = new ArrayList<Transaction>();
        this.totalExceptions = 0;
        this.date = date;

        for (String str : stringList) {
            Transaction trans = new Transaction(str);
            if (trans.exceptionThrown)
                this.totalExceptions ++;
            this.transactions_.add(trans);

        }

        calculate(date);
    }

    @Override
    public void handleEvent(List<String> stringList) {
        this.transactions_.clear();
        this.totalExceptions = 0;
        for (String str : stringList) {
            Transaction trans = new Transaction(str);
            if (trans.exceptionThrown)
                this.totalExceptions ++;
            this.transactions_.add(trans);
        }

        calculate(date);
    }

    public void calculate(Date date) {
        int balance = 0;
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date startDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 8);
        Date endDate = calendar.getTime();

        for (TransactionList.Transaction trans : this.transactions_) {
            if (trans.getDate() != null && trans.getDate().after(startDate) && trans.getDate().before(endDate)) {
                balance = balance + trans.getCash();
            }
        }

        System.out.println("Balance: " + balance);
    }

    static class Transaction {
        private Date date;
        private int cash;
        private int semicolonCounter = 0;
        private boolean exceptionThrown = false;

        public int getCash() {
            return this.cash;
        }

        public Date getDate() {
            return date;
        }

        public Transaction(String transactionString) {
            try {
                parseTransaction(transactionString);
            } catch (NotCvsException e) {
                exceptionThrown = true;
                e.printStackTrace();
            }
        }

        public void parseTransaction(String transaction) throws NotCvsException {
            for (int i = 0; i < transaction.length(); i++) {
                if (transaction.charAt(i) == ';')
                    semicolonCounter++;
            }

            if (semicolonCounter != 3)
                throw new NotCvsException("Not enough semicolon.");

            String[] transactionParts = transaction.split(";");

            for (int i = 0; i < transactionParts.length; i++)
                if (transactionParts[i].trim() == null)
                    throw new NotCvsException("Fields are lacking data.");

            if (isValidDate(transactionParts[0])) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    this.date = formatter.parse(transactionParts[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                throw new NotCvsException("Wrong date.");
            }

            try {
                this.cash = Integer.parseInt(transactionParts[1]);
            } catch (NumberFormatException ex) {
                throw new NotCvsException("Wrong cash format.");
            }
        }

        public static boolean isValidDate(String date) {
            if (date == null)
                return false;

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            formatter.setLenient(false);

            try {
                formatter.parse(date);
            } catch (ParseException e) {
                return false;
            }
            return true;
        }
    }
}
