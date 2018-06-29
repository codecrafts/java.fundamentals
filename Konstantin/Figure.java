public class Figure {
    private double parentSizeA = 0;
    private double parentSizeB = 0;
    private double parentSizeC = 0;

    public Figure(double parentSizeA, double parentSizeB, double parentSizeC) {
        this.parentSizeA = parentSizeA;
        this.parentSizeB = parentSizeB;
        this.parentSizeC = parentSizeC;
    }

    public double getParentSizeA() {
        return parentSizeA;
    }


    public double getParentSizeB() {
        return parentSizeB;
    }

    public double getParentSizeC() {
        return parentSizeC;
    }

    public double getTriangle() {
        System.out.println("площадь Figure = 0");
        return 0;
    }
}
