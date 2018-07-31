package lesson_7;

class Checker {
    // проверка лежат ли три точки на одной прямой
    static boolean dotInLine(Triangle triple){
        int x1 = triple.getA().getX();
        int y1 = triple.getA().getY();
        int x2 = triple.getB().getX();
        int y2 = triple.getB().getY();
        int x3 = triple.getC().getX();
        int y3 = triple.getC().getY();

        return (x3 - x1) * (y2 - y1) == (y3 - y1) * (x2 - x1);
    }
}
