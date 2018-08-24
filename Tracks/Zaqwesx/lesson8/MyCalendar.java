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
        var day = days_.get(date);

        if (day != null && (!day.getEvents().containsKey(time))) {
            day.addEvent(time, event);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteEvent(int date, String time) {
        var day = days_.get(date);

        if (day != null && day.remEvent(time))
            return true;
         else
            return false;
    }

    @Override
    public boolean moveEvent(int dateFrom, int dateTo, String timeFrom, String timeTo) {
        var dayFrom = days_.get(dateFrom);
        var dayTo = days_.get(dateTo);

        if (dayFrom != null) {
            var eventToMove = dayFrom.getEvents().get(timeFrom);

            if (eventToMove != null) {
                if (Day.checkTime(timeTo) == dayTo.getSheduleType()) {
                    addEvent(dateTo, timeTo, eventToMove);
                    deleteEvent(dateFrom, timeFrom);
                    return true;
                } else
                    return false;
            } else
                return false;
        } else
             return false;
    }

    @Override
    public boolean markAsDoneEvent(int date, String time) {
        var day = days_.get(date);

        if (day != null) {
            var event = day.getEvents().get(time);
            if (event != null) {
                event.markAsDone();
                return true;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public int countCompletedEvents(int date) {
        int completedEventsCounter = 0;
        var day = days_.get(date);

        if (day != null) {
            var events = day.getEvents();
            for (String key : events.keySet()) {
                if (events.get(key).checkStatus())
                    completedEventsCounter++;
            }
        }

        return completedEventsCounter;
    }
}
