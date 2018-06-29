public class CalculationTriangle {
    private double sizA;
    private double sizB;
    private double sizC;
    public CalculationTriangle(double sizeA, double sizeB, double sizeC) {
        sizA = sizeA;
        sizB = sizeB;
        sizC = sizeC;
    }
    public void areaTriangle() {
        double triangleSemiperimeter = (sizA + sizB + sizC)/2;
        double areaOfATriangle;
        areaOfATriangle = triangleSemiperimeter * (triangleSemiperimeter - sizA) * (triangleSemiperimeter - sizB) * (triangleSemiperimeter - sizC);
        if (areaOfATriangle <= 0) System.out.println("Такой треугольник не существует ");
        else {
            areaOfATriangle = Math.sqrt(triangleSemiperimeter * (triangleSemiperimeter - sizA) * (triangleSemiperimeter - sizB) * (triangleSemiperimeter - sizC));
            System.out.println("Площадь треугольника равна " + areaOfATriangle);
        }
    }
}
