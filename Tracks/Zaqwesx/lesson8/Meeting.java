public class Meeting extends Event {
    private final String people;
    private final String place;

    public Meeting(String name, String people, String place) {
        super(name);
        this.people = people;
        this.place = place;
    }
}
