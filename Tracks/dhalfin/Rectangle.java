package ru.codecrafts;

public class Rectangle implements Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private Rectangle() {
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public static Builder newBuilder() {
        return new Rectangle().new Builder();
    }

    public class Builder {
        public Builder setA(int x, int y) {
            Rectangle.this.a = new Point(x, y);
            return this;
        }

        public Builder setB(int x, int y) {
            Rectangle.this.b =  new Point(x, y);
            return this;
        }

        public Builder setC(int x, int y) {
            Rectangle.this.c =  new Point(x, y);
            return this;
        }

        public Builder setD(int x, int y) {
            Rectangle.this.d = new Point(x, y);
            return this;
        }

        public Rectangle build() {
            return Rectangle.this;
        }
    }
    // get the area of rectangle
    public float getSquare() {
        float x1 = a.getX();
        float y1 = a.getY();
        float x2 = b.getX();
        float y2 = b.getY();
        float x3 = c.getX();
        float y3 = c.getY();
        float AB = (float) Math.abs(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        float BC = (float) Math.abs(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2));
        float space = AB * BC;
        if (space == 0)
            space = Float.NaN;
        return space;
    }
    // validation of coordinates
    public boolean isValid() {
        boolean isValidRect = false;
        int sheerSides = 0;

        if ((b.getX() - a.getX()) * (c.getX() - b.getX()) + (b.getY() - a.getY()) * (c.getY() - b.getY()) == 0)
            sheerSides++;
        if ((c.getX() - b.getX()) * (d.getX() - c.getX()) + (c.getY() - b.getY()) * (d.getY() - c.getY()) == 0)
            sheerSides++;
        if ((d.getX() - c.getX()) * (a.getX() - d.getX()) + (d.getY() - c.getY()) * (a.getY() - d.getY()) == 0)
            sheerSides++;
        if ((a.getX() - d.getX()) * (b.getX() - a.getX()) + (a.getY() - d.getY()) * (b.getY() - a.getY()) == 0)
            sheerSides++;
        if (sheerSides == 4)  // If all 4 lines are perpendicular, so then we have a rectangle.
            isValidRect = true;
        return isValidRect;
    }
}
