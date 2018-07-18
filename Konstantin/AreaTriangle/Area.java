public class Area {
    static double findeArea(double sizeA,double sizeB,double sizeC) {
        double areaOfATriangle = 0;
        double triangleSemiperimeter;
        if (Triangle.inputSize(sizeA, sizeB, sizeC)) {
            triangleSemiperimeter = (sizeA + sizeB + sizeC) / 2;
            areaOfATriangle = Math.sqrt(triangleSemiperimeter * (triangleSemiperimeter - sizeA) * (triangleSemiperimeter - sizeB) * (triangleSemiperimeter - sizeC));
            System.out.println("Площадь треугольника равна " + areaOfATriangle);
        } else System.out.println("Введены неверные значения попробуйте еще раз");
        return  areaOfATriangle;
    }
    static double findeArea() {
        double sizeA = Triangle.aSize;
        double sizeB = Triangle.bSize;
        double sizeC = Triangle.cSize;
        double areaOfATriangle = 0;
        double triangleSemiperimeter;
        if (Triangle.inputSize(sizeA, sizeB, sizeC)) {
            triangleSemiperimeter = (sizeA + sizeB + sizeC) / 2;
            areaOfATriangle = Math.sqrt(triangleSemiperimeter * (triangleSemiperimeter - sizeA) * (triangleSemiperimeter - sizeB) * (triangleSemiperimeter - sizeC));
            System.out.println("Площадь треугольника равна " + areaOfATriangle);
        } else System.out.println("Введены неверные значения попробуйте еще раз");
        return  areaOfATriangle;
    }
}
