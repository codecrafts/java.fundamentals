package lesson_7;

public class Triangle implements Figure {
    private Point a;
    private Point b;
    private Point c;

    // конструктор
    private Triangle() {
    }

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Builder newBuilder() {
        return new Triangle().new Builder();
    }

    public class Builder {

        private Builder(){
        }

        public Builder setA(int x, int y){
            Triangle.this.a = new Point(x, y);
            return this;
        }

        public Builder setB(int x, int y){
            Triangle.this.b =  new Point(x, y);
            return this;
        }

        public Builder setC(int x, int y){
            Triangle.this.c =  new Point(x, y);
            return this;
        }

        public Triangle build() {
            return Triangle.this;
        }
    }

    // площадь
    public float getArea() {
        float x1 = a.getX();
        float y1 = a.getY();
        float x2 = b.getX();
        float y2 = b.getY();
        float x3 = c.getX();
        float y3 = c.getY();
        float square = Math.abs (((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3)) / 2);
        if (square == 0)
            square = Float.NaN;
        return square;
    }

    // проверка точек
    public boolean isValid() {
        float x1 = a.getX();
        float y1 = a.getY();
        float x2 = b.getX();
        float y2 = b.getY();
        float x3 = c.getX();
        float y3 = c.getY();
        return !((x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1) || (x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3));
    }
}
