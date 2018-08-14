import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Schedule {                                     // расписание событий

    private ArrayList<Day> daysList;                        // список дней в расписании

    public Schedule() {
        this.daysList = new ArrayList<>();
    }

    public Day getDay(Date dayDate) {                       // вернуть объект день из расписания по входящей дате - ГГ.ММ.ДД
        return giveMeDay (dayDate);
    }

    public EventI createEvent(Date date, Event.EventType eventType) {
        EventI event = null;
        Event.EventType type = eventType;
        System.out.println ("Создаем новое событие - " + eventType);
        Day day = getDay(date);        // получили день в расписании

        switch (type) {
            case TASK:
                if (day.getTaskCounter () == Day.MAX_DAY_TASKS) {          // проверка на количество задач на день
                    System.out.println ("Ошибка. На выбранный день превышено количество задач");
                    return null;
                }
                event = new Task ( Lesson8.inputText ( "Введите описание события" ), Lesson8.inputText ( "Введите категорию задачи" ) );
                break;
            case MEET:
                if (day.checkMeetTimeOverlap(date)) {                      // проверка на дублирование времени встречи
                    System.out.println ("Ошибка выбора времени встречи. Cовпадение по времени встреч");
                    //return null;
                }
                event = new Meet ( Lesson8.inputText ( "Введите описание события" ), date, Lesson8.inputText ( "Введите место встречи" ) );
                break;
        }
        Lesson8.createList(event);                                          // заполняем список участников встречи или список действий задачи
        day.addNewEvent(event);
        return event;
    }

    private Day giveMeDay(Date dayDate) {                   // проверка по дате: есть ли день с такой же датой как входящая
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy.");
        if (daysList.size() != 0) {
            for (Day anDaysList : daysList) {
                if (sdf.format(dayDate).equals(sdf.format(anDaysList.getDateOfDay())))
                return anDaysList;                          // возвращаем существующий день в расписании
            }
        }
        Day day = new Day(dayDate);
        daysList.add(day);                                  // добавили новый объект ДЕНЬ в расписание
        return day;                                         // создаем и возвращаем новый объект день
    }
}