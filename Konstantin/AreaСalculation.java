import java.util.Scanner;

public class AreaСalculation extends Figure {

    public AreaСalculation(double parentSizeA, double parentSizeB, double parentSizeC) {
        super(parentSizeA, parentSizeB, parentSizeC);
    }
    public static void main(String[] args) {

        AreaСalculation triangle = new AreaСalculation(0,0,0);
        triangle.getTriangle();
        triangle.getTriangle("Перегрузка акзургереП");

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
        CalculationTriangle areaTriangle = new CalculationTriangle(sizeA, sizeB, sizeC);
        areaTriangle.areaTriangle();
    }
    static double inputSizeTriangle (String message) {
        double input = 0;
        while (input <= 0) {
            System.out.println(message);
            Scanner in = new Scanner(System.in);
            input = in.nextDouble();
            if (input <= 0) System.out.println("Вы ошиблись значение не может быть меньше или равно 0");
        }
        return input;
    }

    @Override
    public double getTriangle() {
        System.out.println("площадь AreaCalculation = 0");
        return super.getTriangle();
    }
    public double getTriangle(String word) {
        System.out.println("при перегрузке метода выводит в консоль " + word);
        return 21;
    }
}
