/* Данные "Встреча" :
- список присутствующих,
- время,
- место проведения. */

import java.util.ArrayList;
import java.util.Date;

public class Meet extends Event {                                       // событие - встреча

    private Date meetTime;                                              // время встречи
    private String place;                                               // место встречи
    private ArrayList<String> membersList;                              // список участников встречи

    // конструктор
    public Meet(String description, Date meetTime, String place) {
        super(EventType.MEET, description);
        this.meetTime = meetTime;
        this.place = place;
        membersList = new ArrayList<> ();
    }

    public void createArrList(String members) {         // заполняем список участников встречи
        membersList.add(members);
    }

    // геттеры
    public Date getMeetTime() {
        return meetTime;
    }

    public String getPlace() {
        return place;
    }

    public String getMessage() {
        return "Введите участника встречи. Введите 0-ноль для выхода.";
    }
}
