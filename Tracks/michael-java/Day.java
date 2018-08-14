import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Day {                                              // день в расписании
    
    private Date dateOfDay;                                     // дата дня
    private ArrayList<EventI> eventsList;                       // список событий для событий
    static final int MAX_DAY_TASKS = 3;                         // max количество задач на день
    private int taskCounter;                                    // счетчик задач в дне

    // конструктор
    public Day(Date date) {
        this.dateOfDay = date;
        this.taskCounter = 0;
        eventsList = new ArrayList<>();
    }

    public void addNewEvent(EventI event) {
        eventsList.add(event);
        if (event instanceof Task)
            taskCounter++;
    }

    public boolean checkMeetTimeOverlap(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        for (EventI anEventsList : eventsList) {
            if (anEventsList instanceof Meet) {                                                          // не назначено ни одной встречи или элемент - встреча
                Meet myMeetObject = (Meet)anEventsList;                                                 // кастим элемент списка к Meet
                if (sdf.format(date).equals(sdf.format(myMeetObject.getMeetTime())))                    // проверка на дублирование времени встречи
                    return true;
            }
        }
        return false;
    }

    public int getTaskCounter() {
        return taskCounter;
    }

    public Date getDateOfDay() {
        return this.dateOfDay;
    }

    public int getDaySolveEvents() {                               // получить количество решенных событий за день
        int solveEvents = 0;
        for (EventI anEventsList : eventsList) {
            if (anEventsList.getEventPreform ())
                solveEvents++;
        }
        return solveEvents;
    }

    public int getDayEventsDuration() {                                // получить затраченное время на события за день
        int duration = 0;
        for (EventI anEventsList : eventsList)
            duration += anEventsList.getEventDuration ();
        return duration;
    }

    public void delEvent(EventI event) {                     // удалить событие по объекту
        if (event instanceof Task)
            taskCounter--;
        eventsList.remove(event);
    }
}