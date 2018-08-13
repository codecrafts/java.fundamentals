import java.util.TreeMap;

public class Day {
    private final int date_;
    private final int sheduleType_;             // параметр описывает тип дня: 1 - часовые интервалы, 2 - получасовые
    TreeMap<String, Event> events_;

    public Day(int date, int sheduleType) {
        this.events_ = new TreeMap<>();
        this.date_ = date;
        this.sheduleType_ = sheduleType;
    }

    public int getSheduleType() {
        return sheduleType_;
    }

    public void addEvent(String time, Event event) {
        if (timeCheck(time) != 0 && !(this.getSheduleType() == 1 && timeCheck(time) == 2))
            events_.put(time, event);
    }

    public void remEvent(String time) {
        if (events_.containsKey(time))
            events_.remove(time);
    }

    public int timeCheck(String time) {
        String[] timeparts = time.split(":");
        int hours = Integer.parseInt(timeparts[0]);
        if (hours >= 0 && hours < 24) {
            if (timeparts[1].equals("00"))
                return 1;
            else if (timeparts[1].equals("30"))
                return 2;
            else
                return 0;
        }else
            return 0;
    }
}
