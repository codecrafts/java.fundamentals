public class Task extends Event {
    private final String category_;
    private final String actions_;

    public Task(String name, String category, String actions) {
        super(name);
        this.category_ = category;
        this.actions_ = actions;
    }
}