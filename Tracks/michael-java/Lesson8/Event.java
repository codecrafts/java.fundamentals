/* Данные "События":
 - название,
 - описание */

public abstract class Event implements EventI {

    private final EventType _TYPE;                         // название события
    private final String _description;                     // описание события
    private int _durationMinute;                           // продолжительность события, минут
    private boolean _isPerform;                            // статус выполнения

    // конструктор
    public Event(EventType type, String description) {
        _TYPE = type;
        _description = description;
        _durationMinute = 0;
        _isPerform = false;
    }

    // геттеры
    public EventType getEventType() {
        return _TYPE;
    }

    public String getEventDescription() {
        return _description;
    }

    @Override
    public int getEventMinuteDuration() {
        return _durationMinute;
    }

    @Override
    public boolean getEventPreform() {
        return _isPerform;
    }

    // сеттеры
    @Override
    public void addToArrList(String members){
    }

    @Override
    public void setEventMinuteDuration(int durationMinute) {
        _durationMinute = durationMinute;
    }

    @Override
    public void setEventPerform(boolean perform) {           // задать статус события: сделано/не сделано
        _isPerform = perform;
    }
}