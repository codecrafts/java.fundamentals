public class Meeting extends Event {
    private final String people_;
    private final String place_;

    public Meeting(String name, String people, String place) {
        super(name);
        this.people_ = people;
        this.place_ = place;
    }
}
