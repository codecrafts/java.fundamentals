public class Mock {
    private String correctCSV = "Дата;Деньги (в рублях);Комментарий;Категория\n" +
            "21.08.2018;100000;Аванс;Зарплата\n" +
            "21.08.2018;-300;Бизнес-ланч;Еда\n" +
            "21.08.2018;-100;Перекус;Еда\n" +
            "21.08.2018;-1000;Продукты в Ашане;Еда\n" +
            "20.08.2018;-300;Аддон к Ведьмаку 3;Развлечения\n" +
            "19.08.2018;-3000;Шмотки;Покупки";
    private String notCorrectCSV = "ДатаДеньги (в рублях)КомментарийКатегория\n" +
            "21.08.2018100000АвансЗарплата\n" +
            "21.08.2018-300Бизнес-ланчЕда\n" +
            "21.08.2018-100ПерекусЕда\n" +
            "21.08.2018-1000Продукты в АшанеЕда\n" +
            "20.08.2018-300Аддон к Ведьмаку 3Развлечения\n" +
            "19.08.2018-3000ШмоткиПокупки";
    private String currentText;
    public Mock() {}
    public Mock(String textForTests) {this.currentText = textForTests;}

    public String getCorrectCSV() {
        return correctCSV;
    }

    public String getNotCorrectCSV() {
        return notCorrectCSV;
    }

    public String getCurrentText() {
        return currentText;
    }
}
