package lesson9;

public class Header {
    private final String headerString_;
    private final Tags headerType_;

    public Header(String string, Tags tag) {
        headerString_ = string;
        headerType_ = tag;
    }

    public Tags getHeaderType() {
        return this.headerType_;
    }

    public String getHeaderString() {
        return headerString_;
    }
}