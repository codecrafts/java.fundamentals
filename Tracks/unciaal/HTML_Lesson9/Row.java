import java.util.ArrayList;

public class Row {
    private String row;
    private String startTag;
    private String endTag;
    private int indexContinueTag = 0;
    public Row(String row,String startTag,String endTag) {
        this.row = row;
        this.startTag = startTag;
        this.endTag = endTag;
    }
    public ArrayList fillingArray() {
        String subRow = row.substring(indexContinueTag);
        ArrayList rowArray = new ArrayList();
        while (checkStringContainsTag(subRow)) {
            rowArray.add(getFindRow());
            subRow = row.substring(indexContinueTag);
        }
        return rowArray;
    }

    public String getFindRow() {
        int indexTagStart;
        int indexTagEnd;
        indexTagStart = searchStartingPosition(row,startTag, indexContinueTag) + startTag.length();
        indexTagEnd = searchStartingPosition(row,endTag,indexTagStart);
        indexContinueTag = indexTagEnd + endTag.length();
        String findRow = row.substring(indexTagStart,indexTagEnd);
        return findRow;
    }
    public int searchStartingPosition(String htmlText,String searchStr,int fromIndex) {
        int positionStr = htmlText.indexOf(searchStr,fromIndex);
        return positionStr;
    }
    private boolean checkStringContainsTag(String row) {
        if (row.contains(startTag) && row.contains(endTag))return true;
        return false;
    }
    public ArrayList searchHyperlinks(ArrayList<String> rowHyperlinks) {
        ArrayList hyperlinks =new ArrayList();
        for (String href: rowHyperlinks) {
            Row hrefRow =new Row(href," href=\"","\"");
            hyperlinks.add(hrefRow.getFindRow());
        }
        return hyperlinks;
    }
}

