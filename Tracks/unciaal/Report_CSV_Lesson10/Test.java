
public class Test {
    public static String answer;


    public void parsingCSV() {
    }
    public void observerСheck(){
        ObservableCSV testOb = new ObserverCSVDataSource();
        Mock mockData = new Mock("Ну почти");
        testOb.setTextData(mockData.getCurrentText());
        if (answer.equals("OK")) {
            System.out.println("тест пройден");
        } else System.out.println("тест не пройден");
    }
    //Правильный CSV файл
    //Не правильный CSV файл
    //Проверка итоговых сумм отчета по правильному CSV файлу
    //Отсутствие нужной даты в в правильном CSV файле
}
