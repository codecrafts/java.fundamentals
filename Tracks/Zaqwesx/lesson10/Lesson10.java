//Задача. Домашняя бухгалтерия.
//
//На вход: Файл в формате CSV-файла, который содержит доходы и расходы за календарный месяц. Формат для всех одинаковый. Пример эталонного файла прикреплен ниже.
//На выход: CSV-файл с результатами агрегации данных.
//
//Требования к реализации:
//Реализация должна быть в ООП стиле. Покрыта тестами.
//Должна быть организована обработка исключений (отсутствие файла, неправильный формат файла).
//Должны быть использованы вложенные и/или анонимные классы, а также шаблон проектирования 'Observer' между классом CsvDataSource (класс который парсит CSV-файл) и класс бизнес-логики (агрегации данных).
//Тесты должны быть написаны для класса бизнес-логики с использованием техники мокирования данных. (без использования файла данных) .
//Необходимо посчитать баланс денег (доходы - расходы) за неделю.

public class Lesson10 {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("Running mock tests.");
        System.out.println("==========================================");
        MockingTranList mockTest = new MockingTranList();
        mockTest.doMockTest();

        System.out.println("==========================================");
        System.out.println("Reading data from file");
        System.out.println("==========================================");
        TransactionList transactionList = new TransactionList();
        BudgetCalculator budgetCalc = new BudgetCalculator();
        transactionList.addObserver(budgetCalc);
        transactionList.getTranListFromFile("C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson10\\DataSource");
    }
}
