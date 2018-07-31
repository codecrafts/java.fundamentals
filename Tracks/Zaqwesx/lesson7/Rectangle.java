public class Rectangle extends Quadrangle {
    private Double square;          // Используем ссылочный тип, т.к. нужен NaN.

    public Rectangle(Dot[] dotArray) {
        super(dotArray);
    }

    public Double getSquare() {
        Dot[] dots = super.getDotArray();

        if (super.isRectangle())
            square = dots[0].getDistance(dots[1]) * dots[1].getDistance(dots[2]);
        else
            square = Double.NaN;

        if (square == 0)
            square = Double.NaN;

        return square;
    }
}
