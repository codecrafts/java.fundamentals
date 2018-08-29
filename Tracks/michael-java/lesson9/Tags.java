package lesson9;

public enum Tags {
    H1 ("<h1>", "</h1>"),
    H2 ("<h2>", "</h2>"),
    H3 ("<h3>", "</h3>"),
    H4 ("<h4>", "</h4>"),
    H5 ("<h5>", "</h5>"),
    H6 ("<h6>", "</h6>");

    private final String openTag_;
    private final String closeTag_;

    Tags(String openTag, String closeTag) {
        openTag_ = openTag;
        closeTag_ = closeTag;
    }

    public String getOpenTag() {
        return openTag_;
    }
    public String getCloseTag() {
        return closeTag_;
    }
}
