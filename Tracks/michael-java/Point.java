package lesson_7;

public class Point {
    private int x;
    private int y;

    // конструктор
    public Point (int x, int y){
        this.x = x;
        this.y = y;
    }

    // геттеры
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void printCoordinate(){
        System.out.println (x + " " + y);
    }

}
