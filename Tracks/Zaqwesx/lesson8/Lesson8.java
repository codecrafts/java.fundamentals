//Система жесткого планирования.
//Весь день разбит на равные интервалы времени (по часу или по тридцать минут - как будет задано).
//Таски привязываются к этим интервалам. Таски могут быть двух типов - встреча, задача. Данные таски - название, описание.
//Задача - категория, список действий. Встреча - список присутствующих, место проведения.
//Операции над задачами: создать, удалить, переместить, пометить как сделанное/несделанное.
//Система должна учитывать количество сделанных задач в прошедший день.

public class Lesson8 {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        if (testScenario1(myCalendar))
            System.out.println("Тест 1 пройден.");
        else
            System.out.println("Тест 1 не пройден.");

        if (testScenario2(myCalendar))
            System.out.println("Тест 2 пройден.");
        else
            System.out.println("Тест 2 не пройден.");

        if (testScenario3(myCalendar))
            System.out.println("Тест 3 пройден.");
        else
            System.out.println("Тест 3 не пройден.");

        if (testScenario4(myCalendar))
            System.out.println("Тест 4 пройден.");
        else
            System.out.println("Тест 4 не пройден.");

        if (testScenario5(myCalendar))
            System.out.println("Тест 5 пройден.");
        else
            System.out.println("Тест 5 не пройден.");

        if (testScenario6(myCalendar))
            System.out.println("Тест 6 пройден.");
        else
            System.out.println("Тест 6 не пройден.");

        if (testScenario7(myCalendar))
            System.out.println("Тест 7 пройден.");
        else
            System.out.println("Тест 7 не пройден.");

    }

    public static boolean testScenario1(MyCalendar myCalendar) {
        // добавим событие, пометим его как выполненное, проверим список выполненных событий
        boolean check = false;
        myCalendar.CreateDay(1,1);
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.CreateEvent(1,"12:00", newTask);
        myCalendar.MarkAsDoneEvent(1,"12:00");
        if (myCalendar.CountCompletedEvents(1) == 1)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }

    public static boolean testScenario2(MyCalendar myCalendar) {
        // проверим, что нельзя создать один и тот же день дважды
        boolean check = false;
        myCalendar.CreateDay(4,1);
        myCalendar.CreateDay(4,2);
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.CreateEvent(4,"12:30", newTask);
        myCalendar.MarkAsDoneEvent(4,"12:30");
        if (myCalendar.CountCompletedEvents(4) == 0)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }

    public static boolean testScenario3(MyCalendar myCalendar) {
        // добавим событие, пометим его как выполненное, удалим событие, проверим список выполненных событий
        boolean check = false;
        myCalendar.CreateDay(2,2);
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.CreateEvent(2,"12:00", newTask);
        myCalendar.MarkAsDoneEvent(2,"12:00");
        myCalendar.DeleteEvent(2,"12:00");
        if (myCalendar.CountCompletedEvents(2) == 0)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }

    public static boolean testScenario4(MyCalendar myCalendar) {
        // переместим событие с 1го дня на 2ой, проверим список выполненных событий за оба дня
        boolean check = false;
        myCalendar.CreateDay(1,1);
        myCalendar.CreateDay(2,2);
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.CreateEvent(1,"12:00", newTask);
        myCalendar.MarkAsDoneEvent(1,"12:00");
        myCalendar.MoveEvent(1,2,"12:00","16:30");
        if (myCalendar.CountCompletedEvents(1) == 0 && myCalendar.CountCompletedEvents(2) == 1)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }

    public static boolean testScenario5(MyCalendar myCalendar) {
        // добавим событие, пометим как выполненное, добавим событие на это же время
        boolean check = false;
        myCalendar.CreateDay(1,1);
        Event newMeeting = new Meeting("MeetingName", "MeetingPeople", "MeetingPlace");
        myCalendar.CreateEvent(1, "12:00", newMeeting);
        myCalendar.MarkAsDoneEvent(1,"12:00");
        Event newTask = new Task("TaskName","TaskCategory", "TaskActions");
        myCalendar.CreateEvent(1,"12:00", newTask);
        if (myCalendar.CountCompletedEvents(1) == 1)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }

    public static boolean testScenario6(MyCalendar myCalendar) {
        // добавим событие в получасовой интервал дня с получасовыми интервалами, попробуем перенести на день с часовыми
        boolean check = false;
        myCalendar.CreateDay(2,2);
        myCalendar.CreateDay(3,1);
        Event newMeeting = new Meeting("MeetingName", "MeetingPeople", "MeetingPlace");
        myCalendar.CreateEvent(2, "15:30", newMeeting);
        myCalendar.MarkAsDoneEvent(2,"15:30");
        myCalendar.MoveEvent(2,3,"15:30","12:30");
        if (myCalendar.CountCompletedEvents(2) == 1 && myCalendar.CountCompletedEvents(3) == 0)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }

    public static boolean testScenario7(MyCalendar myCalendar) {
        // попробуем добавить события на неправильное время
        boolean check = false;
        myCalendar.CreateDay(5,1);
        Event newMeeting = new Meeting("MeetingName", "MeetingPeople", "MeetingPlace");
        myCalendar.CreateEvent(5, "52:00", newMeeting);
        myCalendar.MarkAsDoneEvent(5,"52:00");
        myCalendar.CreateEvent(5, "12:30", newMeeting);
        myCalendar.MarkAsDoneEvent(5,"12:30");
        myCalendar.CreateEvent(5, "-1:00", newMeeting);
        myCalendar.MarkAsDoneEvent(5,"-1:00");
        if (myCalendar.CountCompletedEvents(5) == 0)
            check = true;
        myCalendar.ResetCalendar();
        return check;
    }
}


