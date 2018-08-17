public interface EventI {

    boolean getEventPreform();

    EventType getEventType();

    void setEventPerform(boolean perform);

    int getEventMinuteDuration();

    void setEventMinuteDuration(int duration);

    void addToArrList(String list);

}