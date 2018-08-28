package lesson9;

public class Header {

    private final String headerString;
    private final Tags headerType;

    public Header(String str, Tags tag) {
        headerString = str;
        headerType = tag;
    }

    public Tags getHeaderType() {
        return this.headerType;
    }

    public String getHeaderString() {
        return headerString;
    }
}
