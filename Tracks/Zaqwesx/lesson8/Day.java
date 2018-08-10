import java.util.TreeMap;

public class Day {
    private final int date;
    private final int sheduleType;
    TreeMap<String, Event> events = new TreeMap();

    public Day(int date, int sheduleType) {
        this.date = date;
        this.sheduleType = sheduleType;
    }

    public int getSheduleType() {
        return sheduleType;
    }

    public int getTasksTotal() {
        return events.size();
    }

    public int getTasksDone() {
        int isDone = 0;
        for (String key : events.keySet()) {
            if (events.get(key).isDone)
                isDone++;
        }

        return isDone;
    }

}
