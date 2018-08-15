/* Данные "Задача" :
- категория,
- список действий. */

import java.util.ArrayList;

public class Task extends Event {                                   // событие - задача

    private String category;                                        // категория задачи
    private ArrayList<String> listToDo;                             // список действий задачи

    // конструктор
    public Task(String description, String category) {
        super(EventType.TASK, description);
        this.category = category;
        this.listToDo = new ArrayList<>();
    }

    public void addArrList(String toDo) {             // дополняем список действий для задачи
        listToDo.add(toDo);
    }

    // геттеры
    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return "Введите действие для задачи. Введите 0-ноль для выхода.";
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setListToDo(ArrayList<String> listToDo) {
        this.listToDo = listToDo;
    }
}