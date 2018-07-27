import java.util.Scanner;

public class AreaTriangle  {
    protected static  double difference;
    protected static double sum;
    protected static double areaResult;
    static Triangular triangular = new Triangular();
    public static void main(String[] args) {
        modeSelection();
    }
    private static void modeSelection() {
        printMessage(9);
        Scanner in = new Scanner(System.in);
        String mode = in.next();
        if (mode.equals("test")) {
            testTiangularArea();
        } else {
            inputSize();
            calculatingResult();
        }
    }
    private static void calculatingResult() {
        boolean validationResult = triangular.validationTriangular();
        if (validationResult) {
            areaResult = triangular.findArea();
            printMessage(6);
            printMessage(8);
        } else {
            areaResult = triangular.findArea();
            printMessage(7);
            printMessage(8);
        }
    }
    private static double input() {
        double size;
        Scanner in = new Scanner(System.in);
        size = in.nextDouble();
        return size;
    }
    private static void inputSize() {
        double aSize;
        double bSize;
        double cSize;
        double tempSize;
        do {
            printMessage(1);
            aSize = input();
            if (!checkPositiveNumber(aSize)) printMessage(2);
        } while (!checkPositiveNumber(aSize));
        do {
            printMessage(3);
            bSize = input();
            if (!checkPositiveNumber(bSize)) printMessage(2);
        } while (!checkPositiveNumber(bSize));
        if(sortNumber(aSize,bSize)) {
            tempSize = aSize;
            aSize = bSize;
            bSize = tempSize;
        }
        do {
            difference = aSize - bSize;
            sum = aSize + bSize;
            printMessage(4);
            cSize = input();
            if (!checkPositiveNumber(cSize) && !checkWithin(aSize,bSize,cSize)) {
                printMessage(5);
            }
        } while (!checkPositiveNumber(cSize) && !checkWithin(aSize,bSize,cSize));
        triangular = new Triangular(aSize,bSize,cSize);
    }
    private static void printMessage(int indexMessage) {
        switch (indexMessage) {
            case 1:
                System.out.println("Введите длину 1 стороны треугольника");
                break;
            case 2:
                System.out.println("Значение должно быть больше 0");
                break;
            case 3:
                System.out.println("Введите длину 2 стороны треугольника");
                break;
            case 4:
                System.out.println("Длина 3 стороны тругольника должна быть от " + difference + " до " + sum);
                break;
            case 5:
                System.out.println("Значение должно быть в заданных пределах и больше 0");
                break;
            case 6:
                System.out.println("Валидация треугольника пройдена");
                break;
            case 7:
                System.out.println("Валидация треугольника не пройдена");
                break;
            case 8:
                System.out.println("Площадь треугольника равна " + areaResult);
                break;
            case 9:
                System.out.println("Для тестиирования введите test");
                break;
            case 10:
                System.out.println("Тест пройден");
                break;
            case 11:
                System.out.println("Тест не пройден");
                break;
        }
    }
    private static boolean checkPositiveNumber(double number) {
        boolean check = false;
        if (number > 0) check = true;
        return check;
    }
    private static  boolean sortNumber(double firstNumber, double secondNumber) {
        if (firstNumber < secondNumber) return true;
            else return false;
    }
    private static boolean checkWithin(double firstNumber, double secondNumber,double  thirdNumber) {
        boolean check = false;
        double differenceNumbers = firstNumber - secondNumber;
        double sumNumbers = firstNumber + secondNumber;
        if (thirdNumber > differenceNumbers && thirdNumber < sumNumbers) check = true;
        return check;
    }
    private static void testTiangularArea() {
        triangular = new Triangular(0,0,0);
        calculatingResult();
        if (Double.isNaN(areaResult))printMessage(10);
        else printMessage(11);
    }
}



