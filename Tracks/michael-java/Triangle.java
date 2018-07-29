package lesson_7;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    float square = 0.0f;

    // конструктор
    public Triangle() {
        a = new Point("A");
        b = new Point("B");
        c = new Point("C");
    }

    // площадь
    public float getSquare() {
        square = Math.abs(( (a.x - c.x)*(b.y - c.y) - (b.x - c.x)*(a.y - c.y) )/2);
        if (square == 0)
            square = Float.NaN;
        return square;
    }
}
