public class Task extends Event {
    private final String category;
    private final String actions;

    public Task(String name, String category, String actions) {
        super(name);
        this.category = category;
        this.actions = actions;
    }
}