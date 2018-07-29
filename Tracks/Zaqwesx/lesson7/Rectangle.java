public class Rectangle extends Quadrangle {
    private Quadrangle quadrangle;

    public Rectangle(Dot[] dotArray, Quadrangle quadrangle) {
        super(dotArray);
        this.quadrangle = quadrangle;
    }

    public Double getSquare() {
        Double square;
        Rectangle rectangle = new Rectangle(getDotArray(), quadrangle);
        Dot[] dots = rectangle.getDotArray();

        if (DotUtils.getDistance(dots[0],dots[1]) <= DotUtils.getDistance(dots[0],dots[2]))
            if (DotUtils.getDistance(dots[0],dots[2]) <= DotUtils.getDistance(dots[0],dots[3]))
                square = DotUtils.getDistance(dots[0],dots[1]) * DotUtils.getDistance(dots[0],dots[2]);
            else
                square = DotUtils.getDistance(dots[0],dots[1]) * DotUtils.getDistance(dots[0],dots[3]);
        else
            if (DotUtils.getDistance(dots[0],dots[1]) <= DotUtils.getDistance(dots[0],dots[3]))
                square = DotUtils.getDistance(dots[0],dots[2]) * DotUtils.getDistance(dots[0],dots[1]);
            else
                square = DotUtils.getDistance(dots[0],dots[2]) * DotUtils.getDistance(dots[0],dots[3]);

        return square;
    }
}
