package lesson_7;

class BuilderTriangle {
    private static Point a = BuilderDot.createDot();
    private static Point b = BuilderDot.createDot();
    private static Point c = BuilderDot.createDot();
    private static int x1 = a.getX();
    private static int y1 = a.getY();
    private static int x2 = b.getX();
    private static int y2 = b.getY();
    private static int x3 = c.getX();
    private static int y3 = c.getY();

    static Triangle createTriangle(){
        if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3))
            System.out.println ("Введенные координаты идентичны");
        return new Triangle (a, b ,c );
    }
}
