public class Meeting extends Event {
    String name;
    String people;
    String place;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return "Событие: Встреча. Место: " + this.place + " Люди: " + this.people;
    }

    public Meeting(String name, String people, String place) {
        this.isDone = false;
        this.name = name;
        this.people = people;
        this.place = place;
    }
}
