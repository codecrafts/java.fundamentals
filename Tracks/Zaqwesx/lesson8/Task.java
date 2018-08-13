public class Task extends Event {
    private String category;
    private String actions;

    public Task(String name, String category, String actions) {
        super(name);
        this.category = category;
        this.actions = actions;
    }
}