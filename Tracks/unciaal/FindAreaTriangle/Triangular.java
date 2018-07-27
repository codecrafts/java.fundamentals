//Ввести стороны треугольника как поля члены класса (не static)
//Ввести методы класса как реализации интерфейса Figure
public  class Triangular extends Figure {
    private double sizeA;
    private double sizeB;
    private double sizeC;

    public Triangular(double sizeA, double sizeB, double sizeC) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
    }
    public Triangular() {
    }
    @Override
    boolean validationTriangular() {
        if (sizeA >= sizeB && sizeA - sizeB < sizeC && sizeC < sizeA + sizeB) {
            return true;
        } else {
            sizeA = Double.NaN;
            sizeB = Double.NaN;
            sizeC = Double.NaN;
            return false;
        }
    }
    @Override
    double findArea() {
        double areaOfATriangle;
        double triangleSemiperimeter;
        triangleSemiperimeter = (sizeA + sizeB + sizeC) / 2;
        areaOfATriangle = Math.sqrt(triangleSemiperimeter * (triangleSemiperimeter - sizeA) * (triangleSemiperimeter - sizeB) * (triangleSemiperimeter - sizeC));
        return areaOfATriangle;
    }


}
