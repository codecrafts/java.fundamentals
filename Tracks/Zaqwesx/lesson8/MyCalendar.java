import java.util.TreeMap;

public class MyCalendar implements CalendarInterface {
    private final TreeMap<Integer, Day> days_;

    public MyCalendar() {
        this.days_ = new TreeMap<Integer, Day>();
    }

    @Override
    public boolean createDay(int date, Integer sheduleType) {
        if (!days_.containsKey(date)) {
            Day day = new Day(date, sheduleType);
            days_.put(date, day);
            return true;
        }else
            return false;
    }

    @Override
    public boolean addEvent(int date, String time, Event event) {
        if (days_.get(date) != null && (!days_.get(date).getEvents().containsKey(time))) {
            days_.get(date).addEvent(time, event);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteEvent(int date, String time) {
        if (days_.get(date) != null && days_.get(date).remEvent(time))
            return true;
         else
            return false;
    }

    @Override
    public boolean moveEvent(int dateFrom, int dateTo, String timeFrom, String timeTo) {
        if (days_.get(dateFrom) != null && days_.get(dateFrom).getEvents().get(timeFrom) != null) {
            if (Day.checkTime(timeTo) == days_.get(dateTo).getSheduleType()) {
                addEvent(dateTo, timeTo, days_.get(dateFrom).getEvents().get(timeFrom));
                deleteEvent(dateFrom, timeFrom);
                return true;
            } else
                return false;
        } else
             return false;
    }

    @Override
    public boolean markAsDoneEvent(int date, String time) {
        if (days_.get(date) != null && days_.get(date).getEvents().get(time) != null) {
            days_.get(date).getEvents().get(time).MarkAsDone();
            return true;
        } else
            return false;
    }

    @Override
    public int countCompletedEvents(int date) {
        int completedEventsCounter = 0;
        if (days_.get(date) != null)
            for (String key : days_.get(date).getEvents().keySet()) {
                if (days_.get(date).getEvents().get(key).checkStatus())
                    completedEventsCounter ++;
            }
        return completedEventsCounter;
    }

    @Override
    public void resetCalendar() {
        days_.clear();
    }
}
