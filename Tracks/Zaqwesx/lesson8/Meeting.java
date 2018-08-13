public class Meeting extends Event {
    private String people;
    private String place;

    public Meeting(String name, String people, String place) {
        super(name);
        this.people = people;
        this.place = place;
    }
}
