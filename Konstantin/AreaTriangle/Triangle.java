import java.util.Scanner;

public class Triangle {
    static double aSize;
    static double bSize;
    static double cSize;

    static void inputSize() {
        double difference;
        double sum;
        String text;
        do {
            text = "Введите длину 1 стороны треугольника";
            aSize = input(text);
            if (!checkPositiveNumber(aSize)) System.out.println("Значение должно быть больше 0");
        } while (!checkPositiveNumber(aSize));
        do {
            text = "Введите длину 2 стороны треугольника";
            bSize = input(text);
            if (!checkPositiveNumber(bSize)) System.out.println("Значение должно быть больше 0");
        } while (!checkPositiveNumber(bSize));
        sortNumber(aSize,bSize);
        do {
            difference = aSize - bSize;
            sum = aSize + bSize;
            text = "Длина 3 стороны тругольника должна быть от " + difference + " до " + sum;
            cSize = input(text);
            if (!checkPositiveNumber(cSize) && !checkWithin(aSize,bSize,cSize)) {
                System.out.println("Значение должно быть в заданных пределах и больше 0");
            }
        } while (!checkPositiveNumber(cSize) && !checkWithin(aSize,bSize,cSize));
    }
    static boolean inputSize(double firstNumber, double secondNumber,double  thirdNumber) {
        aSize = firstNumber;
        bSize = secondNumber;
        cSize = thirdNumber;
        sortNumber(aSize,bSize);
        double difference = aSize - bSize;
        double sum = aSize + bSize;
        boolean inputError;
        if (!checkPositiveNumber(aSize)) {
            System.out.println("Значение должно быть больше 0");
            inputError = false;
        } else inputError = true;
        if (!checkPositiveNumber(bSize)) {
            System.out.println("Значение должно быть больше 0");
            inputError =false;
        } else inputError = true;
        if (!(checkPositiveNumber(cSize) && checkWithin(aSize,bSize,cSize))) {
            System.out.println("Значение должно быть больше " + difference + " и меньше " + sum + "и больше 0");
            inputError =false;
        } else inputError = true;
        return inputError;
    }
    static double input(String text) {
        double size;
        Scanner in = new Scanner(System.in);
        System.out.println(text);
        size = in.nextDouble();
        return size;
    }

    static boolean checkPositiveNumber(double number) {
        boolean chek = false;
        if (number > 0) chek = true;
        return chek;
    }
    static void sortNumber(double firstNumber, double secondNumber) {
        if (firstNumber < secondNumber) {
            aSize = secondNumber;
            bSize = firstNumber;
        } else {
            aSize = firstNumber;
            bSize = secondNumber;
        }
    }
    static boolean checkWithin(double firstNumber, double secondNumber,double  thirdNumber) {
        boolean chek = false;
        double differenceNumbers = firstNumber - secondNumber;
        double sumNumbers = firstNumber + secondNumber;
        if (thirdNumber > differenceNumbers && thirdNumber < sumNumbers) chek = true;
        return chek;
    }
}
