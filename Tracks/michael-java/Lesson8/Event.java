/* Данные "События":
 - название,
 - описание */

public abstract class Event implements EventI {

    private final EventType TYPE;                               // название события
    private String description;                           // описание события
    private int durationMinute;                           // продолжительность события, минут
    private boolean isPerform;                            // статус выполнения

    // конструктор
    public Event(EventType type, String description) {
        this.TYPE = type;
        this.description = description;
        this.durationMinute = 0;
        this.isPerform = false;
    }

    // геттеры
    public abstract String getMessage();

    public EventType getEventType() {
        return TYPE;
    }

    public String getEventDescription() {
        return this.description;
    }

    public abstract void createArrList(String string);

    @Override
    public int getEventMinuteDuration() {
        return durationMinute;
    }

    @Override
    public boolean getEventPreform() {
        return isPerform;
    }

    // сеттеры
    @Override
    public void setEventMinuteDuration(int durationMinute) {
        this.durationMinute = durationMinute;
    }

    @Override
    public void setEventPerform(boolean perform) {           // задать статус события: сделано/не сделано
        isPerform = perform;
    }
}