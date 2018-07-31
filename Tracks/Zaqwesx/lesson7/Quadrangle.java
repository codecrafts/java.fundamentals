public class Quadrangle {
    private Dot[] dotArray;

    public Dot[] getDotArray() {
        return dotArray;
    }

    public boolean isRectangle() {
        boolean isRect = false;
        int perpSides = 0;

        // Проверяем взаимную перпендикулярность всех прямых по координатам в заданном порядке.

        if ((dotArray[1].getX() - dotArray[0].getX())*(dotArray[2].getX() - dotArray[1].getX()) +
                (dotArray[1].getY() - dotArray[0].getY())*(dotArray[2].getY() - dotArray[1].getY()) == 0)
            perpSides++;

        if ((dotArray[2].getX() - dotArray[1].getX())*(dotArray[3].getX() - dotArray[2].getX()) +
                (dotArray[2].getY() - dotArray[1].getY())*(dotArray[3].getY() - dotArray[2].getY()) == 0)
            perpSides++;

        if ((dotArray[3].getX() - dotArray[2].getX())*(dotArray[0].getX() - dotArray[3].getX()) +
                (dotArray[3].getY() - dotArray[2].getY())*(dotArray[0].getY() - dotArray[3].getY()) == 0)
            perpSides++;

        if ((dotArray[0].getX() - dotArray[3].getX())*(dotArray[1].getX() - dotArray[0].getX()) +
                (dotArray[0].getY() - dotArray[3].getY())*(dotArray[1].getY() - dotArray[0].getY()) == 0)
            perpSides++;

        if (perpSides == 4)  // Если все 4 прямые перпендикулярны - то у нас прямоугольник.
            isRect = true;

        return isRect;
    }

    public Quadrangle(Dot[] dotArray) {
        this.dotArray = dotArray;
    }
}