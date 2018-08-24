import java.util.TreeMap;

public class Day {
    public static final int INCORRECT_INPUT = 0;
    public static final int FULL_DAY_SHEDULE_TYPE = 1;
    public static final int HALF_DAY_SHEDULE_TYPE = 2;
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
        if (checkIfEventFitsDay(time)) {
            events_.put(time, event);
            return true;
        } else
            return false;
    }

    public boolean remEvent(String time) {
        if (events_.remove(time) != null)
            return true;
        else
            return false;
    }

    public static int checkTime(String time) {
        String[] timeparts = time.split(":");
        int hours = Integer.parseInt(timeparts[0]);
        if (hours >= 0 && hours < 24) {
            if (timeparts[1].equals("00"))
                return FULL_DAY_SHEDULE_TYPE;
            else if (timeparts[1].equals("30"))
                return HALF_DAY_SHEDULE_TYPE;
            else
                return INCORRECT_INPUT;
        }else
            return INCORRECT_INPUT;
    }

    private boolean checkIfEventFitsDay(String time) {
        return (checkTime(time) != 0 && !(this.getSheduleType() == FULL_DAY_SHEDULE_TYPE &&
                checkTime(time) == HALF_DAY_SHEDULE_TYPE));
    }
}
