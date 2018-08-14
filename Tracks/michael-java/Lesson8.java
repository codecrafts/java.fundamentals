/*      Система гибкого планирования.
    На день ставятся не более трех задач, также может быть неограниченное количество встреч.
    Встречи привязаны ко времени, задачи нет.
    Таски могут быть двух типов - встреча, задача.
    Данные таски - название, описание.
    Задача - категория, список действий.
    Встреча - список присутствующих, время и место проведения.
    Операции над задачами: создать, удалить, списать потраченное время на задачу, пометить как сделанное/несделанное.
    Система должна учитывать количество потраченных часов на задачи и встречи, а также сделанные задачи. */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Scanner;

public class Lesson8 {
    private static final int AMOUNT_TEST = 6;

    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        EventI eventT = schedule.createEvent(inputDate(), Event.EventType.TASK);
        eventT.setEventPerform(true);
        eventT.setEventDuration(120);

        EventI eventM = schedule.createEvent(inputDate(), Event.EventType.MEET);
        eventM.setEventPerform(true);
        eventM.setEventDuration(60);
        eventM.getEventPreform();

        System.out.println (tryTests() ? "тест пройден" : "тест не пройден");
    }

    public static  String inputText(String text) {                // получаем строку ввода с консоли
        System.out.println (text);
        Scanner in = new Scanner (System.in);
        return in.nextLine();
    }

    public static Date inputDate() {                             // получаем дату с консоли
        Scanner in = new Scanner (System.in);
        int[] meetDate = new int[5];                             // масив для хранения даты, размерность - 5 (год, месяц, день, час, минуты)
        String[] timePart = {"год", "месяц", "день", "час", "минуты"};
        GregorianCalendar day = new GregorianCalendar();
        System.out.println ("Введите дату и время события");

        for (int i = 0; i < meetDate.length; i++) {
            System.out.println ("введите " + timePart[i]);
            meetDate[i] = in.nextInt();
        }
        // TODO инициализацию в цикл
        day.set(Calendar.YEAR, meetDate[0]);
        day.set(Calendar.MONTH, meetDate[1]);
        day.set(Calendar.DATE, meetDate[2]);
        day.set(Calendar.HOUR, meetDate[3]);
        day.set(Calendar.MINUTE, meetDate[4]);
        System.out.println(day.getTime());
        return day.getTime();
    }

    public static void createList(EventI event) {                        // метод ввода списка
        String something;
        do {
            something = inputText(event.getMessage());
            if (something.equals("0"))
                break;
            event.createArrList(something);
        } while (true);
    }

    public static boolean tryTests() {
        int testComplete = 0;

        Schedule schedule = new Schedule();
        Date today = new Date();
        Day day = schedule.getDay(today);

        // проверка на количество задач не более трех в день
        Task task1 = new Task("задача 1", "Важное");
        Task task2 = new Task("задача 2", "Очень важное");
        Task task3 = new Task("задача 3", "Не важное");
        Task task4 = new Task("задача 4", "!!!");
        day.addNewEvent(task1);
        day.addNewEvent(task2);
        day.addNewEvent(task3);
        day.addNewEvent(task4);
        if (day.getTaskCounter() == 4) testComplete++;

        // проверка на дублирование времени встречи
        Meet meet1 = new Meet("Описание события1", today, "место встречи1");
        Meet meet2 = new Meet("Описание события2", today, "место встречи2");
        day.addNewEvent(meet1);
        day.addNewEvent(meet2);
        if (day.checkMeetTimeOverlap(today)) testComplete++;

        // провека изменения статуса
        task1.setEventPerform(true);
        meet1.setEventPerform(true);
        if (task1.getEventPreform() && meet1.getEventPreform()) testComplete++;

        // списать потраченное время на задачу
        task2.setEventDuration(60);
        meet2.setEventDuration(120);
        if ((task2.getEventDuration() + meet2.getEventDuration()) == 180) testComplete++;

        // учет потраченных часов на задачи и встречи, а также сделанные задачи
        task1.setEventDuration(30);
        meet1.setEventDuration(40);
        task2.setEventPerform(true);
        meet2.setEventPerform(true);
        if (day.getDaySolveEvents () == 4 && day.getDayEventsDuration() == 250) testComplete++;

        // удалить
        day.delEvent(task1);
        if (day.getDayEventsDuration() == 220) testComplete++;

        return testComplete == AMOUNT_TEST;
    }
}