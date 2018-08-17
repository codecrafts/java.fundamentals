/*      Система гибкого планирования.
    На день ставятся не более трех задач, также может быть неограниченное количество встреч.
    Встречи привязаны ко времени, задачи нет.
    Таски могут быть двух типов - встреча, задача.
    Данные таски - название, описание.
    Задача - категория, список действий.
    Встреча - список присутствующих, время и место проведения.
    Операции над задачами: создать, удалить, списать потраченное время на задачу, пометить как сделанное/несделанное.
    Система должна учитывать количество потраченных часов на задачи и встречи, а также сделанные задачи. */

import java.time.*;

public class Lesson8 {

    public static void main(String[] args) {

        LocalDateTime today = LocalDateTime.now();

        Schedule schedule = new Schedule();

        // проверка на количество задач не более трех в день
        EventI task1 = schedule.addNewEvent(EventType.TASK, today,"задача 1","Очень важное");
        task1.addToArrList ("действие 1");
        task1.addToArrList ("действие 2");
        EventI task2 = schedule.addNewEvent(EventType.TASK, today,"задача 2","Важное");
        EventI task3 = schedule.addNewEvent(EventType.TASK, today,"задача 3","Не важное");
        EventI task4 = schedule.addNewEvent(EventType.TASK, today,"задача 4","!!!");
        System.out.println (task4 == null ? "тест пройден" : "тест не пройден");

        // проверка на дублирование времени встречи
        EventI meet1 = schedule.addNewEvent(EventType.MEET, today,"Встреча 1","место встречи 1");
        EventI meet2 = schedule.addNewEvent(EventType.MEET, today,"Встреча 2","место встречи 2");
        meet1.addToArrList ("Иван Иванович");
        meet1.addToArrList ("Петр Петрович");
        System.out.println (meet2 == null ? "тест пройден" : "тест не пройден");

        // провека изменения статуса, а также сделанные задачи
        task3.setEventPerform(true);
        meet1.setEventPerform(true);
        System.out.println (task3.getEventPreform() && meet1.getEventPreform() ? "тест пройден" : "тест не пройден");
        System.out.println (schedule.getDay(today).amtSolveEvents () == 2 ? "тест пройден" : "тест не пройден");


        // списать потраченное время на задачу, учет потраченных часов на задачи и встречи,
        task2.setEventMinuteDuration(60);
        meet1.setEventMinuteDuration(120);
        System.out.println ((task2.getEventMinuteDuration() + meet1.getEventMinuteDuration()) == 180 ? "тест пройден" : "тест не пройден");
        System.out.println (schedule.getDay(today).getDayEventsMinuteDuration() == 180 ? "тест пройден" : "тест не пройден");

        // удалить
        System.out.println (schedule.getDay(today).delEvent(task1) ? "тест пройден" : "тест не пройден");
    }
}