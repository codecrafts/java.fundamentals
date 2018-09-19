package lesson10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvDataSource implements CsvDataSourceObservable {
    private final static int DATE_SIZE = 10;                    // длина поля ДАТА
    private List<String> strokeUnparsedList_;                   // строчки из CSV файла
    private TransactionsObserver transactionsListObserver_;     // наблюдатель

    public CsvDataSource() {}

    public CsvDataSource(String path, Charset encoding) throws IOException {
        strokeUnparsedList_ = Files.readAllLines(Paths.get(path), encoding);
    }

    public void setStrokeUnparsedList_(List<String> strokeUnparsedList_) {
        this.strokeUnparsedList_ = strokeUnparsedList_;
    }

    @Override
    public void registerTransactionsObserver(TransactionsObserver transactionsListObserver) {
        transactionsListObserver_ = transactionsListObserver;
    }

    public void parsTransactions() throws noValidFileExeption {     // парсер строчек csv файла,
        LocalDate date;
        double sum;
        String type;
        String description;
        int firstSemicolon;
        int secondSemicolon;
        int thirdSemicolon;
        String parsedLine;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if(strokeUnparsedList_.isEmpty()) throw new noValidFileExeption("Неверный формат входного файла");

        for (int i = 1; i < strokeUnparsedList_.size(); i++) {
            parsedLine = strokeUnparsedList_.get(i);
            firstSemicolon = parsedLine.indexOf(";");
            secondSemicolon = parsedLine.indexOf(";", firstSemicolon + 1);
            thirdSemicolon = parsedLine.indexOf(";", secondSemicolon + 1);

            if (firstSemicolon < 0 &&  secondSemicolon < 0 && thirdSemicolon < 0)  throw new noValidFileExeption("Неверный формат входного файла");

            String parsedDate = parsedLine.substring(0, firstSemicolon);                        // первое поле - дата
            String parsedSum = parsedLine.substring(firstSemicolon + 1, secondSemicolon);       // второе поле - сумма

            if(!isValid(parsedDate, parsedSum)) throw new noValidFileExeption("Неверный формат входного файла");

            date = LocalDate.parse(parsedDate, format);
            sum = Double.parseDouble(parsedSum);
            type = parsedLine.substring(secondSemicolon + 1, thirdSemicolon);
            description = parsedLine.substring(thirdSemicolon + 1);

            notifyTransaction(date, sum, type, description);                                    // сигналим наблюдателю
        }
    }

    private boolean isValid(String date, String sum) {
        return (isDateValid(date) && isDigit(sum));
    }

    boolean isDateValid(String value) {
        if (value == null && value.length() != DATE_SIZE && value.length() != 0) {
            return false;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        formatter.setLenient(false);
        try {
            formatter.parse(value);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    boolean isDigit(String value) throws NumberFormatException {
        if (value.equals("")) {
            return false;
        }
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void notifyTransaction(LocalDate date, double sum, String type, String description) {
        transactionsListObserver_.onUpdate(date, sum, type, description);
    }
}
