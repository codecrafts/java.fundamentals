/* Данные "Задача" :
- категория,
- список действий. */

import java.util.ArrayList;

public class Task extends Event {                                   // событие - задача

    private String category;                                        // категория задачи
    private ArrayList<String> listToDo = new ArrayList<>();         // список действий задачи

    // конструктор
    public Task(String description, String category){
        super(task, description);
        this.category = category;
    }

    // геттеры
    public String getCategory() {
        return category;
    }

    public void createArrList(String toDo){             // заполняем список действий для задачи
        listToDo.add(toDo);
    }

    public String getMessage(){
        return "Введите действие для задачи. Введите 0-ноль для выхода.";
    }

    public ArrayList<String> getList() {
        return listToDo;
    }

    public void printAllInfo() {                        // печать инфы задачи
        super.printAllInfo();
        System.out.println ("Категория: " + category);
        System.out.print ("Список действий: ");
        printList();
        System.out.println ("--------------------\n");
    }

    public void printList(){                            // печать списка действий задачи
        StringBuilder toDoSheet = new StringBuilder("| ");
        for (String anListToDo : listToDo) {
            toDoSheet.append(anListToDo).append(" | ");
        }
        System.out.println ("Список действий: " + toDoSheet);
    }
}