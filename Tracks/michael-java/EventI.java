import java.util.ArrayList;

public interface EventI {
    String meet = "Встреча";
    String task = "Задача";

    void printAllInfo();                             // общий метод для печати полной инфы о событии

    void printList();                                // общий метод для печати списков

    boolean getIsPerform();

    void setPerform(boolean perform);

    int getDuration();

    void setDuration(int duration);

    String getDescription();

    void  createArrList(String string);
}