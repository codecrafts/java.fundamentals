
public class Task extends Event {
    String name;
    String category;
    String actions;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return "Событие: Задача. Категория: " + this.category + " Действия: " + this.actions;
    }

    public Task(String name, String category, String actions) {
        this.isDone = false;
        this.name = name;
        this.category = category;
        this.actions = actions;
    }
}