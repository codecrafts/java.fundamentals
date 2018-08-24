package lesson9;

public class Header {
    private final String string_;
    private final Tags type_;

    public Header(String str) throws CustomException {
        Tags tag_ = null;
        String str_ = null;
        if ( str == null || str.isEmpty()) throw new CustomException("Пустая строка");
        for (Tags tag: Tags.values()) {
            if(str.contains(tag.getOpenTag()) && str.contains(tag.getCloseTag())) {
                str_ = (str.replace(tag.getOpenTag(), "")).replace(tag.getCloseTag(), "").trim();
                tag_ = tag;
            }
        }
        type_ = tag_;
        string_ = str_;
    }

    public Tags getHeaderType(){
        return type_;
    }

    public String getHeaderString(){
        return string_;
    }
}
