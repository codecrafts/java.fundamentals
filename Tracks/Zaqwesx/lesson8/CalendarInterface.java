public interface CalendarInterface {
    boolean createDay(int date, Integer sheduleType);  // инициализация дня

    boolean createEvent(int date, String time, Event event);   // создание события

    boolean deleteEvent(int date, String time);    // удаление события

    boolean moveEvent(int dateFrom, int dateTo, String timeFrom, String timeTo);   // перенос события

    boolean markAsDoneEvent(int date, String time); // пометить событие как выполненное

    int countCompletedEvents(int date); // посчитать кол-во выполнененных событий за день

    void resetCalendar();   // сброс календаря
}
