//Система жесткого планирования.
//Весь день разбит на равные интервалы времени (по часу или по тридцать минут - как будет задано).
//Таски привязываются к этим интервалам. Таски могут быть двух типов - встреча, задача. Данные таски - название, описание.
//Задача - категория, список действий. Встреча - список присутствующих, место проведения.
//Операции над задачами: создать, удалить, переместить, пометить как сделанное/несделанное.
//Система должна учитывать количество сделанных задач в прошедший день.

public class Lesson8 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.createDay(1,1);
        myCalendar.createDay(2,2);
        myCalendar.createDay(3,1);
        int testCounter = 0;
        int testPass = 0;

        testCounter++;
        if (testCreateEvent(myCalendar)) {
            System.out.println("Тест на создание события пройден.");
            testPass++;
        } else
            System.out.println("Тест на создание события не пройден.");

        testCounter++;
        if (testCheckEventMarked(myCalendar)) {
            System.out.println("Тест на пометку 'Сделано' пройден.");
            testPass++;
        } else
            System.out.println("Тест на пометку 'Сделано' не пройден.");

        testCounter++;
        if (testOverrideDay(myCalendar)) {
            System.out.println("Тест на перезапись дня пройден.");
            testPass++;
        } else
            System.out.println("Тест на перезапись дня не пройден.");

        testCounter++;
        if (testDeleteEvent(myCalendar)) {
            System.out.println("Тест на удаление события пройден.");
            testPass++;
        } else
            System.out.println("Тест на удаление события не пройден.");

        testCounter++;
        if (testMoveEvent(myCalendar)) {
            System.out.println("Тест на перемещение события пройден.");
            testPass++;
        } else
            System.out.println("Тест на перемещение события не пройден.");

        testCounter++;
        if (testOverrideEvent(myCalendar)) {
            System.out.println("Тест перезапись события пройден.");
            testPass++;
        } else
            System.out.println("Тест перезапись события не пройден.");

        testCounter++;
        if (testMoveEventWrongShedule(myCalendar)) {
            System.out.println("Тест на перенос события на неверное время пройден.");
            testPass++;
        } else
            System.out.println("Тест на перенос события на неверное время не пройден.");

        testCounter++;
        if (testCreateEventWrongShedule(myCalendar)) {
            System.out.println("Тест на создание событий с неправильным временем пройден.");
            testPass++;
        } else
            System.out.println("Тест на создание событий с неправильным временем не пройден.");

        System.out.println("Обещее число проведенных тестов: " + testCounter);
        System.out.println("Тестов пройдено положительно: " + testPass);

    }

    public static boolean testCreateEvent(MyCalendar myCalendar) {
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        return myCalendar.createEvent(1,"12:00", newTask);
    }

    public static boolean testCheckEventMarked(MyCalendar myCalendar) {
        // добавим событие, пометим его как выполненное, проверим список выполненных событий
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.createEvent(1,"12:00", newTask);
        return myCalendar.markAsDoneEvent(1,"12:00");
    }

    public static boolean testOverrideDay(MyCalendar myCalendar) {
        // проверим, что нельзя создать один и тот же день дважды
        return !myCalendar.createDay(1,2);
    }

    public static boolean testDeleteEvent(MyCalendar myCalendar) {
        // добавим событие, пометим его как выполненное, удалим событие, проверим список выполненных событий
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.createEvent(2,"12:00", newTask);
        return myCalendar.deleteEvent(2,"12:00");
    }

    public static boolean testMoveEvent(MyCalendar myCalendar) {
        // переместим событие с 1го дня на 2ой, проверим список выполненных событий за оба дня
        boolean check = false;
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.createEvent(1,"14:00", newTask);
        return myCalendar.moveEvent(1,2,"14:00","16:30");
    }

    public static boolean testOverrideEvent(MyCalendar myCalendar) {
        // добавим событие, пометим как выполненное, добавим событие на это же время
        Event newMeeting = new Meeting("MeetingName", "MeetingPeople", "MeetingPlace");
        myCalendar.createEvent(1, "10:00", newMeeting);
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        return !myCalendar.createEvent(1,"10:00", newTask);
    }

    public static boolean testMoveEventWrongShedule(MyCalendar myCalendar) {
        // добавим событие в получасовой интервал дня с получасовыми интервалами, попробуем перенести на день с часовыми
        Event newMeeting = new Meeting("MeetingName", "MeetingPeople", "MeetingPlace");
        myCalendar.createEvent(2, "15:30", newMeeting);
        return !myCalendar.moveEvent(2,3,"15:30","12:30");
    }

    public static boolean testCreateEventWrongShedule(MyCalendar myCalendar) {
        // попробуем добавить события на неправильное время
        Event newMeeting = new Meeting("MeetingName", "MeetingPeople", "MeetingPlace");
        return !(myCalendar.createEvent(5, "52:00", newMeeting) ||
            myCalendar.createEvent(5, "12:30", newMeeting) ||
            myCalendar.createEvent(5, "-1:00", newMeeting));
    }
}


