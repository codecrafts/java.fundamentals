public abstract class Event {
    private final String name_;
    private boolean isDone_;

    public Event(String name) {
        this.name_ = name;
        this.isDone_ = false;
    }

    public void MarkAsDone() {
        this.isDone_ = true;
    }

    public boolean checkStatus() {
        return isDone_;
    }
}
