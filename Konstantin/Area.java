import javax.naming.ldap.Control;
import java.util.Scanner;

public class Area  {
    public static void main(String[] args) {
    start();
    InWord abc = new Triangle(0,0, 0);
    abc.inputSize();
    abc.areaFind();


    }
    static void start(){
        System.out.println("Для тестирования введите - test");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        System.out.println(choice);
        if (choice.equals("test")) test();
    }
    static void test() {
        Triangle test = new Triangle(2,2,2);
        if (test.areaFind() == 1.7320508075688772) System.out.println("Тест 1 пройден ");
        test.chekAndSend(7,9,5);
        if(test.areaFind() == 17.41228014936585) System.out.println("Тест 2 пройден");
        test.chekAndSend(-3,0,6);
        if (test.areaFind() == 0)System.out.println("Тест 3 пройден");
    }
}
