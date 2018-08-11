import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Shedule {                                      // расписание

    private ArrayList<Day> daysList = new ArrayList<>();    // список дней в расписании

    public ArrayList<Day> getDaysList() {
        return daysList;
    }

    public Day getDay(Date dayDate) {                       // получить или создать объект день из расписания по входящей дате - ГГ.ММ.ДД
        return checkHaveDay(dayDate);
    }

    private Day checkHaveDay(Date dayDate){                 // проверка по дате: есть ли день с такой же датой как входящая
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy.");
        if (daysList.size() != 0){
            for (Day anDaysList : daysList){
                if (sdf.format(dayDate).equals(sdf.format(anDaysList.getDateOfDay())))
                return anDaysList;                          // возвращаем существующий день в расписании
            }
        }
        Day day = new Day(dayDate);
        daysList.add(day);                                  // добавили новый объект ДЕНЬ в расписание
        return day;                                         // создаем и возвращаем новый объект день
    }
}