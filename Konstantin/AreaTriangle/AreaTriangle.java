import java.util.Scanner;

public class AreaTriangle {
    public static void main(String[] args) {
        System.out.println("Для тестирования введите - test");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        System.out.println(choice);
        if (choice.equals("test")) {
            Tests.checkLogic();
        } else {
            Triangle.inputSize();
            Area.findeArea();
        }
    }
}
