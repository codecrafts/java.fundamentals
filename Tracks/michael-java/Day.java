import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Day{                                                // день в расписании
    
    private Date dateOfDay;                                      // дата дня
    private ArrayList<EventI> eventsList = new ArrayList<>();    // список событий для task и meet
    private static final int MAX_DAY_TASKS = 3;                  // max количество задач на день
    private int taskCounter = 0;                                 // счетчик задач в дне

    // конструктор
    public Day(Date date) {
        this.dateOfDay = date;
    }

    public void addNewEvent(EventI event){
        eventsList.add(event);
        taskCounter++;
    }

    public boolean checkMeetTimeOverlap(Date date){                                                     // проверка на дублирование времени встречи
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        for (EventI anEventsList : eventsList){
            if (anEventsList instanceof Meet){                                                          // не назначено ни одной встречи или элемент - встреча
                Meet myMeetObject = (Meet)anEventsList;                                                 // кастим элемент списка к Meet
                if (sdf.format(date).equals(sdf.format(myMeetObject.getMeetTime())))                    // проверка на дублирование времени встречи
                    return true;
            }
        }
        return false;
    }

    public boolean checkTaskNotMore3(){                                                                 // проверка на количество задач не более трех в день
        return taskCounter < MAX_DAY_TASKS;
    }

    // геттеры
    public ArrayList<EventI> getEventsList() {
        return eventsList;
    }

    public Date getDateOfDay() {
        return this.dateOfDay;
    }

    public EventI getMeet(Date date) {                       // получить событие ВСТРЕЧА по времени
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        for (EventI anEventsList : eventsList) {
            if (anEventsList instanceof Meet) {
                Meet myMeetObject = (Meet)anEventsList;
                if (sdf.format(date).equals(sdf.format(myMeetObject.getMeetTime())))
                    return anEventsList;
            }
        }
        return null;
    }

    public int getSolveTask(){                               // получить количество решенных событий за день
        int solveEvents = 0;
        for (EventI anEventsList : eventsList) {
            if (anEventsList.getIsPerform())
                solveEvents++;
        }
        return solveEvents;
    }

    public int getDuration(){                                // получить затраченное время на события за день
        int duration = 0;
        for (EventI anEventsList : eventsList)
            duration += anEventsList.getDuration();
        return duration;
    }

    public void delEvent(EventI event) {                     // удалить событие по объекту
        if (event instanceof Meet)
            taskCounter--;
        eventsList.remove(event);
    }

    public void delEvent(int i) {                            // удалить событие по индексу
        if (eventsList.get(i) instanceof Task)
            taskCounter--;
        eventsList.remove(i);
    }
}