package lesson9;

public class Test {

    private final static int FIRST_ELEMENT_OF_HEADER_LIST = 0;
    private final static int SECOND_ELEMENT_OF_HEADER_LIST = 1;
    private final static int THERD_ELEMENT_OF_HEADER_LIST = 2;

    public static void doTest() throws NoHTMLException {

        HtmlRow htmlRow = new HtmlRow("\uFEFF<html>");
        System.out.println (htmlRow.isHTMLFile() ? "тест 1 is HTML пройден" : "тест не пройден");

        htmlRow = new HtmlRow("\uFEFF<!DOCTYPE html>");
        System.out.println (htmlRow.isHTMLFile() ? "тест 2 is HTML пройден" : "тест не пройден");

        htmlRow = new HtmlRow("qwerty");
        System.out.println(!htmlRow.isHTMLFile() ? "тест 3 is HTML пройден" : "тест не пройден");

        htmlRow = new HtmlRow("\uFEFF<html> <h1>Заголовок</h1>");
        htmlRow.parsingHeader();

        System.out.println(htmlRow.getHeader(FIRST_ELEMENT_OF_HEADER_LIST).getHeaderString() != null && htmlRow.getHeader(FIRST_ELEMENT_OF_HEADER_LIST).getHeaderType() != null ? "тест 4 пройден" : "тест не пройден");

        htmlRow = new HtmlRow("\uFEFF<html> <h1>Заголовок H1</h1>  123 ");
        htmlRow.parsingHeader();
        System.out.println(htmlRow.getHeader(FIRST_ELEMENT_OF_HEADER_LIST).getHeaderString().equals("Заголовок H1") ? "тест 5 пройден" : "тест не пройден");

        htmlRow = new HtmlRow("\uFEFF<html> <html> <h1>Заголовок H1</h1> <h3>Заголовок H3</h3> <h2>Заголовок H2</h2> ");
        htmlRow.parsingHeader();
        System.out.println(htmlRow.getHeader(FIRST_ELEMENT_OF_HEADER_LIST).getHeaderString().equals("Заголовок H1") ? "тест 6 пройден" : "тест не пройден");
        System.out.println(htmlRow.getHeader(SECOND_ELEMENT_OF_HEADER_LIST).getHeaderString().equals("Заголовок H3") ? "тест 7 пройден" : "тест не пройден");
        System.out.println(htmlRow.getHeader(THERD_ELEMENT_OF_HEADER_LIST).getHeaderString().equals("Заголовок H2") ? "тест 8 пройден" : "тест не пройден");
        System.out.println(htmlRow.getHeader(FIRST_ELEMENT_OF_HEADER_LIST).getHeaderType().equals(Tags.H1) ? "тест 9 пройден" : "тест не пройден");
        System.out.println(htmlRow.getHeader(SECOND_ELEMENT_OF_HEADER_LIST).getHeaderType().equals(Tags.H3) ? "тест 10 пройден" : "тест не пройден");
        System.out.println(htmlRow.getHeader(THERD_ELEMENT_OF_HEADER_LIST).getHeaderType().equals(Tags.H2) ? "тест 11 пройден" : "тест не пройден");
    }
}
