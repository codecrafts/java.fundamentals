import java.util.Scanner;

public class Figure {
    private double sizeA;
    private double sizeB;
    private double sizeC;

    public Figure(double sizeA, double sizeB, double sizeC) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
    }

    public double getSizeA() {
        return sizeA;
    }

    public void setSizeA(double sizeA) {
        this.sizeA = sizeA;
    }

    public double getSizeB() {
        return sizeB;
    }

    public void setSizeB(double sizeB) {
        this.sizeB = sizeB;
    }

    public double getSizeC() {
        return sizeC;
    }

    public void setSizeC(double sizeC) {
        this.sizeC = sizeC;
    }

    public double input(String text) {
        double size;
        Scanner in = new Scanner(System.in);
        System.out.println(text);
        size = in.nextDouble();
        return size;
    }
    public double chekEnter(String text, double length) {
        while (length <=0) {
            System.out.println("Длина должна быть больше 0");
            length = input(text);
        }
        return length;
    }
    public double chekEnter(String text, double size1, double size2, double length) {
        double temp = size1;
        double min;
        double max;
        if (size1 < size2) {
            size1 = size2;
            size2 = temp;
        }
        min = size1 - size2;
        max = size1 + size2;
        text = text + " больше " + min + " до " + max;
        while (length <= min || length >= max) {
            length = input(text);
        }
        return length;
    }
    public double getSquare() {
        System.out.println("Площадь фигуры равно 0");
        return 0;
    }
}
