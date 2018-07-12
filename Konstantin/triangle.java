public class Triangle extends Figure implements Input {
    public Triangle(double sizeA, double sizeB, double sizeC) {
        super(sizeA, sizeB, sizeC);
    }

    public void inputSize() {
        double aSize = 0;
        double bSize = 0;
        double cSize = 0;
        double temp;
        boolean resaltCheak;
        aSize = chekEnter("Введите длину стороны A",aSize);
        bSize = chekEnter("Введите длину стороны B",bSize);
        cSize = chekEnter("Введите длину стороны С",aSize,bSize,cSize);
        resaltCheak = chekSide(aSize,bSize,cSize);
        sendSide(resaltCheak,aSize,bSize,cSize);
    }
    public boolean chekSide (double aSize, double bSize, double cSize) {
        double temp;
        double min;
        double max;
        boolean resaltCheak;
        if (aSize < bSize) {
            temp = aSize;
            aSize = bSize;
            bSize = temp;
        }
        min = aSize - bSize;
        max = aSize + bSize;
        if (aSize <= 0 || bSize <= 0 || cSize <= 0) {
            System.out.println("Значения не могут быть меньше 0");
            resaltCheak = false;
        } else if (cSize <= min || cSize >= max) {
            System.out.println("Значение длины стороны С должно быть в пределах от " + min + " до " + max);
            resaltCheak = false;
        } else {
            resaltCheak = true;
        }
        return resaltCheak;
    }
    public void sendSide(boolean resaltCheak, double aSize, double bSize, double cSize) {
        if (resaltCheak) {
            setSizeA(aSize);
            setSizeB(bSize);
            setSizeC(cSize);
        } else {
            setSizeA(0);
            setSizeB(0);
            setSizeC(0);
        }
    }
    public double findeArea() {
        double areaOfATriangle = 0;
        if (getSizeA() > 0 && getSizeB() > 0 && getSizeC() > 0) {
            double triangleSemiperimeter = (getSizeA() + getSizeB() + getSizeC()) / 2;
            areaOfATriangle = Math.sqrt(triangleSemiperimeter * (triangleSemiperimeter - getSizeA()) * (triangleSemiperimeter - getSizeB()) * (triangleSemiperimeter - getSizeC()));
            System.out.println("Площадь треугольника равна " + areaOfATriangle);
        }
       return  areaOfATriangle;
    }
    @Override
    public double getSquare() {
        System.out.println("Площадь тругольника равна 0");
        return 0;
    }
    public double getSquare(int multipliyer) {
        System.out.println("Площадь треугольника введеная пользователем равна " + multipliyer);
        return multipliyer;
    }
    public void makeClassExpirement(){
        Triangle exp = new Triangle(2,3,4);
        System.out.println("hashCode - " + exp.hashCode());
        System.out.println("toString - " + exp.toString());
        Triangle pxe = exp;
        System.out.println("equals - " + exp.equals(pxe));
    }
}
