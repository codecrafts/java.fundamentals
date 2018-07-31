package lesson_7;

class BuilderTriangle {
    private static Point a = BuilderDot.createDot();
    private static Point b = BuilderDot.createDot();
    private static Point c = BuilderDot.createDot();

    static Triangle createTriangle(){
        if (a.equals(b) || c.equals(b) || a.equals(c))
            System.out.println ("Введенные координаты идентичны");
        return new Triangle (a, b ,c );
    }
}
