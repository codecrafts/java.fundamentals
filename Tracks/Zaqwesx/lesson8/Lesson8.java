import java.util.TreeMap;

public class Lesson8 {
    public static void main(String[] args) {

        if (testCode())
            System.out.println("Тесть пройден.");
        else
            System.out.println("Тест не пройден.");


    }

    public static boolean testCode() {
        TreeMap<Integer, Day> days = new TreeMap();
        int counter = 0;
//         1. добавь элемент в несуществующий день
        setEvent(days, 1, "12:00", new Task("name", "category", "actions"));
        if (days.size() == 0)
            counter ++;
//          2. создать день, добавить элемент
        setDay(days,1, 1);
        setEvent(days, 1, "12:00", new Task("name", "category", "actions"));
        if ((days.size() == 1) && days.get(1).getTasksTotal() == 1)
            counter ++;

//          3. добавить событие туда, где уже есть событие
        setEvent(days, 1, "12:00", new Task("name", "category", "actions"));
        if (days.get(1).getTasksTotal() == 1)
            counter ++;

//        4. добавить день туда, где уже есть день
        setDay(days, 1, 1);
        if (days.get(1).getTasksTotal() == 1)
            counter ++;

        // 5. добавим еще день, добавим событие, удалим событие
        setDay(days,2, 2);
        setEvent(days,2,"12:00", new Meeting("name", "people, people", "actions"));
        remEvent(days, 2,"12:00");
        if (days.get(2).getTasksTotal() == 0)
            counter ++;


        // 6. переместим событие из дня 1 в день 2
        moveEvent(days,1,2,"12:00","15:30");
        if ((days.get(1).getTasksTotal() == 0 && days.get(2).getTasksTotal() == 1))
            counter ++;

        // 7. переместим событие в день, которого нет
        moveEvent(days,2,3,"15:00","15:00");
        if (days.get(2).getTasksTotal() == 1)
            counter ++;

        // 8. пометим задачу как сделанную
        setDone(days, 2, "15:30");
        if (days.get(2).getTasksDone() == 1)
            counter ++;

        // 9. создадим день по с часовыми интервалами и присвоим получасовое событие
        setDay(days,3,1);
        setEvent(days,3,"12:30", new Meeting("name", "people, people", "actions"));
        if (days.get(3).getTasksTotal() == 0)
            counter ++;

        // 10. проверим, что в событие попадает верная информация
        setEvent(days,2,"12:30", new Meeting("name", "people, people", "actions"));
        if (days.get(2).events.get("12:30").getName() == "name")
            counter ++;


        if (counter == 10)
            return true;
        else
            return false;

    }

    public static void setDay(TreeMap<Integer, Day> days, Integer date, Integer sheduleType) {
        if (!days.containsKey(date))
            days.put(date, new Day(date, sheduleType));
    }

    public static void setEvent(TreeMap<Integer, Day> days, Integer date, String time, Event event) {
        if (days.containsKey(date) && !days.get(date).events.containsKey(time) && timeCheck(time) != 0)
            if (!(days.get(date).getSheduleType() == 1 && timeCheck(time) == 2))
                days.get(date).events.put(time, event);

    }

    public static void remEvent(TreeMap<Integer, Day> days, Integer date, String time) {
        if (days.containsKey(date) && days.get(date).events.containsKey(time))
            days.get(date).events.remove(time);
    }

    public static void moveEvent(TreeMap<Integer, Day> days, Integer date1, Integer date2, String time1, String time2){
        if (days.containsKey(date1) && days.get(date1).events.containsKey(time1)) {
            setEvent(days, date2, time2, days.get(date1).events.get(time1));
            remEvent(days, date1, time1);
        }
    }

    public static void setDone(TreeMap<Integer, Day> days, Integer date, String time) {
        if (days.containsKey(date) && days.get(date).events.containsKey(time))
            days.get(date).events.get(time).isDone = true;

    }

    public static int timeCheck(String time) {
        String[] timeparts = time.split(":");
        int hours = Integer.parseInt(timeparts[0]);
        if (hours >= 0 && hours <= 24) {
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


