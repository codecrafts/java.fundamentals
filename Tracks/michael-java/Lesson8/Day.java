import java.time.*;
import java.util.ArrayList;

public class Day {                                                      // день в расписании
    private static LocalDateTime _dateOfCalendar;                       // дата дня, время не нужно
    private ArrayList<EventI> _eventsList;                              // список событий для событий
    private int _taskCounter;                                           // счетчик задач в дне

    public Day(LocalDateTime date) {
        _dateOfCalendar = date;
        _taskCounter = 0;
        _eventsList = new ArrayList<>();
    }

    public EventI newTask(String description, String category) {
        if (_taskCounter == Task.MAX_DAY_TASKS)
            return null;
        _taskCounter++;
        EventI event = new Task(description, category);
        _eventsList.add(event);
        return event;
    }

    public EventI newMeet(LocalDateTime date, String description, String place) {
        LocalTime newMeetTime = date.toLocalTime();
        LocalTime exisitTime;
        for (EventI anEventsList : _eventsList) {
            if (anEventsList.getEventType() == EventType.MEET) {
                exisitTime = ((Meet)anEventsList).getMeetTime().toLocalTime();          // получаем время существующей встречи
                if(newMeetTime.compareTo(exisitTime) == 0)                              // сравниваем время
                    return null;
            }
        }
        EventI event = new Meet (date, description, place);
        _eventsList.add(event);
        return event;
    }

    public LocalDateTime getDateOfDay() {
        return _dateOfCalendar;
    }

    public int amtSolveEvents() {                                                       // получить количество решенных событий за день
        int solveEvents = 0;
        for (EventI anEventsList : _eventsList) {
            if (anEventsList.getEventPreform ())
                solveEvents++;
        }
        return solveEvents;
    }

    public int getDayEventsMinuteDuration() {                                           // получить затраченное время на события за день
        int duration = 0;
        for (EventI anEventsList : _eventsList)
            duration += anEventsList.getEventMinuteDuration();
        return duration;
    }

    public boolean delEvent(EventI event) {                                             // удалить событие по объекту
        if(_eventsList.contains(event)) {
            if (event.getEventType() == EventType.TASK)
                _taskCounter--;
            _eventsList.remove(event);
            return true;
        }
        return false;
    }
}