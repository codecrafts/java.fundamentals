public interface CalendarInterface {
    void CreateDay(Integer date, Integer sheduleType);  // инициализация дня

    void CreateEvent(Integer date, String time, Event event);   // создание события

    void DeleteEvent(Integer date, String time);    // удаление события

    void MoveEvent(Integer dateFrom, Integer dateTo, String timeFrom, String timeTo);   // перенос события

    void MarkAsDoneEvent(Integer date, String time); // пометить событие как выполненное

    int CountCompletedEvents(Integer date); // посчитать кол-во выполнененных событий за день

    void ResetCalendar();   // сброс календаря
}
