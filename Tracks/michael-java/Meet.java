/* Данные "Встреча" :
- список присутствующих,
- время,
- место проведения. */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Meet extends Event {                               // событие - встреча

    private Date meetTime;                                      // время встречи
    private String place;                                       // место встречи
    private ArrayList<String> membersList = new ArrayList<> ();         // список участников встречи


    // конструктор
    public Meet(String description, Date meetTime, String place){
        super(meet, description);
        this.meetTime = meetTime;
        this.place = place;
    }

    // геттеры
    public Date getMeetTime(){
        return meetTime;
    }

    public String getPlace(){
        return place;
    }

    public String getMessage(){
        return "Введите участника встречи. Введите 0-ноль для выхода.";
    }

    public void createArrList(String members) {         // заполняем список участников встречи
        membersList.add(members);
    }

    public ArrayList<String> getList() {
        return membersList;
    }

    public void printAllInfo() {                        // печать инфы встречи
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yy.");
        Date meetTime = this.meetTime;
        super.printAllInfo ();
        System.out.println ("Событие встреча назначена на - " + sdf.format(meetTime));
        System.out.println ("Место встречи: " + place);
        System.out.print ("Список участников: ");
        printList();
        System.out.println ("--------------------\n");
    }

    public void printList(){                            // печать списка участников встречи
        StringBuilder membersSheet = new StringBuilder ("| ");
        for (String anListToDo : membersList) {
            membersSheet.append(anListToDo).append(" | ");
        }
        System.out.println ("Список участников: " + membersSheet);
    }
}
