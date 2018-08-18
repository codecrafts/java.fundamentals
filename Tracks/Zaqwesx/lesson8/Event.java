public abstract class Event {
    private String name;
    private boolean isDone;

    public Event(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void MarkAsDone() {
        this.isDone = true;
    }

    public boolean checkStatus() {
        return isDone;
    }
}
