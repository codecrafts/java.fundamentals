import java.util.ArrayList;

public class Row {
    private String _row_;
    private String _startTag_;
    private String _endTag_;
    private int _indexContinueTag_;
    public Row(String row, String startTag, String endTag, int indexTag) {
        this._row_ = row;
        this._startTag_ = startTag;
        this._endTag_ = endTag;
        this._indexContinueTag_ = indexTag;

    }
    public ArrayList writeArray() {
        String subRow = _row_.substring(_indexContinueTag_);
        ArrayList<String> rowArray = new ArrayList<String>();
        while (subRow.contains(_startTag_) && subRow.contains(_endTag_)) {
            rowArray.add(getFindRow());
            subRow = _row_.substring(_indexContinueTag_);
        }
        return rowArray;
    }

    public String getFindRow() {
        int indexTagStart = _row_.indexOf (_startTag_, _indexContinueTag_) + _startTag_.length();
        int indexTagEnd = _row_.indexOf (_endTag_,indexTagStart);
        _indexContinueTag_ = indexTagEnd + _endTag_.length();
        String findRow = _row_.substring(indexTagStart,indexTagEnd);
        return findRow;
    }

    public ArrayList getHyperlinks(ArrayList<String> rowHyperlinks) {
        ArrayList<String> hyperlinks = new ArrayList<String>();
        for (String href: rowHyperlinks) {
            this._row_ = href;
            this._startTag_ = "href=\"";
            this._endTag_ = "\"";
            this._indexContinueTag_ = 0;
            hyperlinks.add(getFindRow());
        }
        return hyperlinks;
    }
}

