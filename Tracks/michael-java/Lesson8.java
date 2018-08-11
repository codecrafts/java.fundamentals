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
        Shedule shedule = new Shedule();

        EventI eventT = createTask(shedule);
        eventT.printAllInfo();
        eventT.setPerform(true);
        eventT.setDuration(120);
        eventT.printAllInfo();

        EventI eventM = createMeet(shedule);
        eventM.printAllInfo();
        eventM.setPerform(true);
        eventM.setDuration(60);
        eventM.printAllInfo();
        eventM.getIsPerform();
        System.out.println ("За день потрачено часов на все события: " + (eventT.getDuration() + eventM.getDuration ())/60);
        printShedule (shedule);

        System.out.println (tryTests() ? "тест пройден" : "тест не пройден");
    }

    // TODO объединить два метода в один
    private static Task createTask(Shedule shedule) {            // новое событие ЗАДАЧА
        System.out.println ("Создаем новое событие - ЗАДАЧА");
        Date date = inputDate();                                 // ввод даты события
        Day day = shedule.getDay(date);                          // получили день в расписании
        if (!day.checkTaskNotMore3()) {                          // проверка на количество задач в дне
            System.out.println ("Ошибка. На выбранный день превышено количество задач");
            return null;
        } else {
            Task task = new Task(inputText("Введите описание события"), inputText("Введите категорию задачи"));
            createList(task);                                    // заполняем список действий задачи
            day.addNewEvent(task);                               // добавили событие в спиок событий дня
            return task;
        }
    }

    private static Meet createMeet(Shedule shedule) {            // новое событие ВСТРЕЧА
        System.out.println ("Создаем событие - ВСТРЕЧА");
        Date date = inputDate();                                 // ввод даты события
        Day day = shedule.getDay(date);                          // получили день в расписании
        if (day.checkMeetTimeOverlap(date)) {                    // проверка на дублирование времени встречи
            System.out.println ("Ошибка выбора времени встречи. Cовпадение по времени встреч");
            return null;
        } else {
            Meet meet = new Meet(inputText("Введите описание события"), date, inputText("Введите место встречи"));
            createList(meet);                                    // заполняем список участников встречи
            day.addNewEvent(meet);
            return meet;
        }
    }

    private static  String inputText(String text){                // получаем строку ввода с консоли
        System.out.println (text);
        Scanner in = new Scanner (System.in);
        return in.nextLine();
    }

    private static Date inputDate() {                                    // метод воода даты
        Scanner in = new Scanner (System.in);
        int[] meetDate = new int[5];                             // масив для хранения даты, размерность - 5 (год, месяц, день, час, минуты)
        String[] timePart = {"год", "месяц", "день", "час", "минуты"};
        GregorianCalendar day = new GregorianCalendar ();
        System.out.println ("Введите дату и время события");
        for (int i = 0; i < meetDate.length; i++) {
            System.out.println ("введите " + timePart[i]);
            meetDate[i] = in.nextInt ();
        }
        day.set(Calendar.YEAR, meetDate[0]);
        day.set(Calendar.MONTH, meetDate[1]);
        day.set(Calendar.DATE, meetDate[2]);
        day.set(Calendar.HOUR, meetDate[3]);
        day.set(Calendar.MINUTE, meetDate[4]);
        System.out.println(day.getTime());
        return day.getTime();
    }

        private static void createList(Event event) {                      // метод ввода списка
        String member;
        do {
            member = inputText(event.getMessage());
            if (member.equals("0"))
                break;
            event.createArrList(member);
        } while (true);
    }

    private static void printShedule(Shedule shedule){                      // печать расписания по дням
        for (Day anDaysList : shedule.getDaysList()){
            System.out.println ("День " + anDaysList.getDateOfDay());
            for (EventI anEventsList : anDaysList.getEventsList()){
                anEventsList.printAllInfo ();
            }
        }
    }

    static boolean tryTests() {
        int testComplete = 0;

        Shedule shedule = new Shedule();
        Date today = new Date();
        Day day = shedule.getDay(today);

        // проверка на количество задач не более трех в день
        Task task1 = new Task("задача 1", "Важное");
        Task task2 = new Task("задача 2", "Очень важное");
        Task task3 = new Task("задача 3", "Не важное");
        Task task4 = new Task("задача 4", "!!!");
        day.addNewEvent(task1);
        day.addNewEvent(task2);
        day.addNewEvent(task3);
        day.addNewEvent(task4);
        if (!day.checkTaskNotMore3()) testComplete++;

        // проверка на дублирование времени встречи
        Meet meet1 = new Meet("Введите описание события", today, "место встречи");
        Meet meet2 = new Meet("Введите описание события", today, "место встречи");
        day.addNewEvent(meet1);
        day.addNewEvent(meet2);
        if (day.checkMeetTimeOverlap(today)) testComplete++;

        // провека изменения статуса
        task1.setPerform(true);
        meet1.setPerform(true);
        if (task1.getIsPerform() && meet1.getIsPerform()) testComplete++;

        // списать потраченное время на задачу
        task2.setDuration(60);
        meet2.setDuration(120);
        if ((task2.getDuration() + meet2.getDuration()) == 180) testComplete++;

        // учет потраченных часов на задачи и встречи, а также сделанные задачи
        task1.setDuration(30);
        meet1.setDuration(40);
        task2.setPerform(true);
        meet2.setPerform(true);
        if (day.getSolveTask() == 4 && day.getDuration() == 250) testComplete++;

        // удалить
        day.delEvent(task1);
        if (day.getDuration() == 220) testComplete++;

        return testComplete == AMOUNT_TEST;
    }
}