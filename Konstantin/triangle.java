import java.util.Scanner;

public class triangle {
    public static void main(String[] args) {
        double sizeA = inputSizeTriangle("Введите длину стороны А");
        double sizeB = inputSizeTriangle("Введите длину стороны В");
        double temp;
        double minSizeC;
        double maxSizeC;
        if (sizeA < sizeB) {
            temp = sizeA;
            sizeA = sizeB;
            sizeB = temp;
        }
        minSizeC = sizeA - sizeB;
        maxSizeC = sizeA + sizeB;
        double sizeC = inputSizeTriangle("Введите длину стороны С " + "(может быть больше " + minSizeC + " и меньше " + maxSizeC);
        areaOfATriangle areaTriangle = new areaOfATriangle(sizeA, sizeB, sizeC);
        areaTriangle.areaTriangle();
    }
    static double inputSizeTriangle (String message) {
        double input = 0;
        while (input<=0) {
            System.out.println(message);
            Scanner in = new Scanner(System.in);
            input = in.nextDouble();
            if (input <= 0) System.out.println("Вы ошиблись значение не может быть меньше или равно 0");
        }
        return input;
    }
}
