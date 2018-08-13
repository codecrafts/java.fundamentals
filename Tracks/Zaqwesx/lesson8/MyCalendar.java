import java.util.TreeMap;

public class MyCalendar implements CalendarInterface {
    TreeMap<Integer, Day> days_;

    public MyCalendar() {
        this.days_ = new TreeMap<>();
    }

    @Override
    public void CreateDay(Integer date, Integer sheduleType) {
        if (!days_.containsKey(date)) {
            Day day = new Day(date, sheduleType);
            days_.put(date, day);
        }
    }

    @Override
    public void CreateEvent(Integer date, String time, Event event) {
        if (days_.containsKey(date)) {
            if (!days_.get(date).events_.containsKey(time))
                days_.get(date).addEvent(time, event);
        }
    }

    @Override
    public void DeleteEvent(Integer date, String time) {
        if (days_.containsKey(date))
            days_.get(date).remEvent(time);

    }

    @Override
    public void MoveEvent(Integer dateFrom, Integer dateTo, String timeFrom, String timeTo) {
        if (days_.containsKey(dateFrom))
            if (days_.get(dateFrom).events_.containsKey(timeFrom))
                if (days_.get(dateTo).timeCheck(timeTo) == days_.get(dateTo).getSheduleType()) {
                    CreateEvent(dateTo, timeTo, days_.get(dateFrom).events_.get(timeFrom));
                    DeleteEvent(dateFrom, timeFrom);
                }
    }

    @Override
    public void MarkAsDoneEvent(Integer date, String time) {
        if (days_.containsKey(date))
            if (days_.get(date).events_.containsKey(time))
                days_.get(date).events_.get(time).MarkAsDone();
    }

    @Override
    public int CountCompletedEvents(Integer date) {
        int completedEventsCounter = 0;
        if (days_.containsKey(date))
            for (String key : days_.get(date).events_.keySet()) {
                if (days_.get(date).events_.get(key).CheckStatus())
                    completedEventsCounter ++;
            }
        return completedEventsCounter;
    }

    @Override
    public void ResetCalendar() {
        days_.clear();
    }
}
