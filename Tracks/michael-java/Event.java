/* Данные "События":
 - название,
 - описание */

import java.util.ArrayList;

public class Event implements EventI{

    private String name;                              // название события
    private String description;                       // описание события
    private int duration = 0;                         // продолжительность события
    private boolean isPerform = false;                // статус выполнения

    // конструктор
    public Event(String name, String description){
        this.name = name;
        this.description = description;
    }

    // геттеры
    public String getMessage(){
        return "";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void createArrList(String string){           // метод переопределен в дочерних
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public boolean getIsPerform() {
        return isPerform;
    }

    // сеттеры
    @Override
    public void setDuration(int duration) {             // задать количество потраченных часов на событие в МИНУТАХ
        this.duration = duration;
    }

    @Override
    public void setPerform(boolean perform) {           // задать статус события: сделано/не сделано
        isPerform = perform;
    }

    @Override
    public void printAllInfo() {
        System.out.println("Событие: " + name);
        System.out.println("Описание: " + getDescription());
        System.out.println ("Продолжительность: " + getDuration());
        System.out.print ("Статус выполнения: ");
        System.out.println (getIsPerform() ? "Событие выполнено" : "Событие не выполнено");
    }

    @Override
    public void printList(){
        System.out.println("Список");
    }

}