import java.util.ArrayList;

public interface EventI {

    String meet = "Встреча";
    String task = "Задача";

    boolean getEventPreform();

    void setEventPerform(boolean perform);

    int getEventDuration();

    void setEventDuration(int duration);

}