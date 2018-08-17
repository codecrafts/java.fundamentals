import java.util.ArrayList;
import java.time.*;

public class Schedule {                                      // расписание событий

    private ArrayList<Day> _daysList;                        // список дней в расписании

    public Schedule() {
        _daysList = new ArrayList<>();
    }

    public EventI addNewEvent(EventType type, LocalDateTime date, String description, String eventParametr) {
        EventI event = null;
        Day day = takeDay(date);
        switch (type) {
            case TASK:
                event = day.newTask(description, eventParametr);
                break;
            case MEET:
                event = day.newMeet(date, description, eventParametr);
                break;
        }
        return event;
    }

    public Day takeDay(LocalDateTime date) {                 // получить или создать день по дате
        LocalDate myDate = date.toLocalDate();
        LocalDate existDate;
        if (_daysList.size() != 0) {
            for (Day anDaysList : _daysList) {
                existDate = anDaysList.getDateOfDay().toLocalDate();
                if(myDate.compareTo(existDate) == 0)
                    return anDaysList;
            }
        }
        Day day = new Day(date);
        _daysList.add(day);                                  // добавили новый объект ДЕНЬ в расписание
        return day;                                         // создаем и возвращаем новый объект день
    }

    public Day getDay(LocalDateTime date) {
        for (Day anDaysList : _daysList) {
            if (anDaysList.getDateOfDay ().compareTo (date) == 0)
            return anDaysList;
        }
        return null;
    }
}