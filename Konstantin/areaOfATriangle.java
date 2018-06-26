public class areaOfATriangle {
    double sizA;
    double sizB;
    double sizC;
    public areaOfATriangle(double sizeA, double sizeB, double sizeC) {
        sizA = sizeA;
        sizB = sizeB;
        sizC = sizeC;
    }
    public void areaTriangle(){
        double triangleSemiperimeter;
        double areaOfATriangle;
        triangleSemiperimeter = (sizA + sizB + sizC)/2;
        areaOfATriangle = triangleSemiperimeter * (triangleSemiperimeter - sizA) * (triangleSemiperimeter - sizB) * (triangleSemiperimeter - sizC);
        if (areaOfATriangle <= 0) System.out.println("Такой треугольник не существует ");
        else {
            areaOfATriangle = Math.sqrt(triangleSemiperimeter * (triangleSemiperimeter - sizA) * (triangleSemiperimeter - sizB) * (triangleSemiperimeter - sizC));
            System.out.println("Площадь треугольника равна " + areaOfATriangle);
        }
    }

}
