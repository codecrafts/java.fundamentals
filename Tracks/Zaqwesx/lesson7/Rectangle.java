public class Rectangle extends Quadrangle {
    private double square;

    public Rectangle(Dot[] dotArray) {
        super(dotArray);
    }

    public double getSquare() {
        Dot[] dots = super.getDotArray();

        if (super.isRectangle())
            square = dots[0].getDistance(dots[1]) * dots[1].getDistance(dots[2]);
        else
            square = 0.0/0;

        if (square == 0)
            square = 0.0/0;

        return square;
    }
}
