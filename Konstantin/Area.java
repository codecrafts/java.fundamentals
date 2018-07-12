import java.util.Scanner;

public class Area  {
    public static void main(String[] args) {
    modeSelection();
    Input abc = new Triangle(0,0,0);
    abc.inputSize();
    abc.findeArea();
    }
    static void modeSelection(){
        System.out.println("Для тестирования введите - test");
        Scanner in = new Scanner(System.in);
        String choice = in.next();
        System.out.println(choice);
        if (choice.equals("test")) checkOfWork();
    }
    static void checkOfWork() {
        Triangle test = new Triangle(2,2,2);
        if (test.findeArea() == 1.7320508075688772) System.out.println("Тест 1 пройден ");
        test.chekSide(7,9,5);
        if(test.findeArea() == 17.41228014936585) System.out.println("Тест 2 пройден");
        test.chekSide(-3,0,6);
        if (test.findeArea() == 0)System.out.println("Тест 3 пройден");
    }
}
