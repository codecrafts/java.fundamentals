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
        listToDo = new ArrayList<>();
    }

    public void createArrList(String toDo) {             // заполняем список действий для задачи
        listToDo.add(toDo);
    }

    // геттеры
    public String getCategory() {
        return category;
    }

    public String getMessage() {
        return "Введите действие для задачи. Введите 0-ноль для выхода.";
    }
}