/* Данные "Встреча" :
- список присутствующих,
- время,
- место проведения. */

import java.time.*;
import java.util.ArrayList;

public class Meet extends Event {                                       // событие - встреча

    private final LocalDateTime _meetTime;                                     // время встречи
    private final String _place;                                               // место встречи
    private ArrayList<String> _membersList;                              // список участников встречи

    // конструктор
    public Meet( LocalDateTime meetTime, String description, String place) {
        super(EventType.MEET, description);
        _meetTime = meetTime;
        _place = place;
        _membersList = new ArrayList<> ();
    }

    public void addToArrList(String members) {         // заполняем список участников встречи
        _membersList.add(members);
    }

    // геттеры
    public LocalDateTime getMeetTime() {
        return _meetTime;
    }

    public String getPlace() {
        return _place;
    }
}
