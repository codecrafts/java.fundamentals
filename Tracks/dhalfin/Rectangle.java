package ru.codecrafts;

public class Rectangle implements Figure {
    private Point A;
    private Point B;
    private Point C;
    private Point D;

    private Rectangle() {
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
    }

    public static Builder newBuilder() {
        return new Rectangle().new Builder();
    }

    public class Builder {
        public Builder setA(int x, int y) {
            Rectangle.this.A = new Point(x, y);
            return this;
        }

        public Builder setB(int x, int y) {
            Rectangle.this.B =  new Point(x, y);
            return this;
        }

        public Builder setC(int x, int y) {
            Rectangle.this.C =  new Point(x, y);
            return this;
        }

        public Builder setD(int x, int y) {
            Rectangle.this.D = new Point(x, y);
            return this;
        }

        public Rectangle build() {
            return Rectangle.this;
        }
    }
    // get the area of rectangle
    public double getSquare() {
        double x1 = A.getX();
        double y1 = A.getY();
        double x2 = B.getX();
        double y2 = B.getY();
        double x3 = C.getX();
        double y3 = C.getY();
        double AB = Math.abs(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double BC = Math.abs(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        double space = AB * BC;
        if (space == 0)
            space = Double.NaN;
        return space;
    }
    // validation of coordinates
    public boolean isValid() {
        boolean isValidRect = false;
        int sheerSides = 0;

        if ((B.getX() - A.getX()) * (C.getX() - B.getX()) + (B.getY() - A.getY()) * (C.getY() - B.getY()) == 0)
            sheerSides++;
        if ((C.getX() - B.getX()) * (D.getX() - C.getX()) + (C.getY() - B.getY()) * (D.getY() - C.getY()) == 0)
            sheerSides++;
        if ((D.getX() - C.getX()) * (A.getX() - D.getX()) + (D.getY() - C.getY()) * (A.getY() - D.getY()) == 0)
            sheerSides++;
        if ((A.getX() - D.getX()) * (B.getX() - A.getX()) + (A.getY() - D.getY()) * (B.getY() - A.getY()) == 0)
            sheerSides++;
        if (sheerSides == 4)  // If all 4 lines are perpendicular, so then we have a rectangle.
            isValidRect = true;
        return isValidRect;
    }
}
