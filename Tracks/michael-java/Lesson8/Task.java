/* Данные "Задача" :
- категория,
- список действий. */

import java.util.ArrayList;

public class Task extends Event {                                   // событие - задача
    static final int MAX_DAY_TASKS = 3;

    private final String _category;                                        // категория задачи
    private ArrayList<String> _listToDo;                             // список действий задачи

    // конструктор
    public Task(String description, String category) {
        super(EventType.TASK, description);
        _category = category;
        _listToDo = new ArrayList<>();
    }

    public void addToArrList(String toDo) {             // дополняем список действий для задачи
        _listToDo.add(toDo);
    }

    // геттеры
    public String getCategory() {
        return _category;
    }
}