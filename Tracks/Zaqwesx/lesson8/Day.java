import java.util.TreeMap;

public class Day {
    private final int date_;
    private final int sheduleType_;             // параметр описывает тип дня: 1 - часовые интервалы, 2 - получасовые
    private final TreeMap<String, Event> events_;

    public Day(int date, int sheduleType) {
        this.events_ = new TreeMap<String, Event>();
        this.date_ = date;
        this.sheduleType_ = sheduleType;
    }

    public TreeMap<String, Event> getEvents() {
        return events_;
    }

    public int getSheduleType() {
        return sheduleType_;
    }

    public boolean addEvent(String time, Event event) {
        if (checkTime(time) != 0 && !(this.getSheduleType() == 1 && checkTime(time) == 2)) {
            events_.put(time, event);
            return true;
        } else
            return false;
    }

    public boolean remEvent(String time) {
        events_.remove(time);
        if (events_.containsKey(time))
            return false;
        else
            return true;
    }

    public static int checkTime(String time) {
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
