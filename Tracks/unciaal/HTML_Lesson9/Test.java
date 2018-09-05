import java.util.ArrayList;

public class Test {
    public static void makeTests (){

        //тест с верными входными данными
        Row testRow = new Row("<a href=\"http://google.com\">Google it</a>","<a","</a>",0);
        ArrayList<String> findRow = testRow.writeArray();
        String textTest = findRow.get(0);
        if (textTest.equals(" href=\"http://google.com\">Google it")) {
            ArrayList<String> hyperlinks = testRow.getHyperlinks(findRow);
            String result =  hyperlinks.get(0);
            if (result.equals("http://google.com")) System.out.println("Тест с верными входными данными пройден");
        }

        //тест с не верными входными данными
        Row testWrongRow = new Row(" href=\"http://google.com\">Google it","<a","</a>",0);
        ArrayList<String> findWrongRow = testWrongRow.writeArray();
        if (findWrongRow.size() == 0) {
             System.out.println("Тест с неверными входными данными пройден");
        }

    }


}
