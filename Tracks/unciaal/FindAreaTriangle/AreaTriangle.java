import java.util.Scanner;

public class AreaTriangle  {
    protected static  double difference;
    protected static double sum;
    protected static double areaResult;
    static Triangular triangular = new Triangular();
    public static void main(String[] args) {
        System.out.println("Для тестиирования введите test");
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
        boolean validationResult = triangular.checkTriangular();
        if (validationResult) {
            areaResult = triangular.findArea();
            System.out.println("Валидация треугольника пройдена");;
            System.out.println("Площадь треугольника равна " + areaResult);
        } else {
            areaResult = triangular.findArea();
            System.out.println("Валидация треугольника не пройдена");
            System.out.println("Площадь треугольника равна " + areaResult);
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
            System.out.println("Введите длину 1 стороны треугольника");
            aSize = input();
            if (!checkPositiveNumber(aSize)) System.out.println("Значение должно быть больше 0");
        } while (!checkPositiveNumber(aSize));
        do {
            System.out.println("Введите длину 2 стороны треугольника");
            bSize = input();
            if (!checkPositiveNumber(bSize)) System.out.println("Значение должно быть больше 0");
        } while (!checkPositiveNumber(bSize));
        if(sortNumber(aSize,bSize)) {
            tempSize = aSize;
            aSize = bSize;
            bSize = tempSize;
        }
        do {
            difference = aSize - bSize;
            sum = aSize + bSize;
            System.out.println("Длина 3 стороны тругольника должна быть от " + difference + " до " + sum);
            cSize = input();
            if (!checkPositiveNumber(cSize) && !checkWithin(aSize,bSize,cSize)) {
                System.out.println("Значение должно быть в заданных пределах и больше 0");
            }
        } while (!checkPositiveNumber(cSize) && !checkWithin(aSize,bSize,cSize));
        triangular = new Triangular(aSize,bSize,cSize);
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
        int testCount = 0;
        if (Double.isNaN(areaResult)) testCount++;
        triangular = new Triangular(1,2,3);
        calculatingResult();
        if (Double.isNaN(areaResult)) testCount++;
        triangular = new Triangular(2,2,2);
        calculatingResult();
        if (triangular.findArea() == 1.7320508075688772) testCount++;
        triangular = new Triangular(-2,-2,-2);
        calculatingResult();
        if (Double.isNaN(areaResult)) testCount++;
        if (testCount == 4) System.out.println("Тест пройден");
        else System.out.println("Тест не пройден");

    }
}



