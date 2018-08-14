/* Данные "События":
 - название,
 - описание */

public abstract class Event implements EventI {

    private EventType type;                               // название события
    private String description;                        // описание события
    private int duration;                              // продолжительность события
    private boolean isPerform;                         // статус выполнения
    enum EventType{
        TASK,
        MEET
    }

    // конструктор
    public Event(Event.EventType type, String description) {
        this.type = type;
        this.description = description;
        this.duration = 0;
        this.isPerform = false;
    }

    // геттеры
    public abstract String getMessage();

    public String getEventDescription() {
        return this.description;
    }

    public abstract void createArrList(String string);

    @Override
    public int getEventDuration() {
        return duration;
    }

    @Override
    public boolean getEventPreform() {
        return isPerform;
    }

    // сеттеры
    @Override
    public void setEventDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void setEventPerform(boolean perform) {           // задать статус события: сделано/не сделано
        isPerform = perform;
    }
}