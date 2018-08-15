package lesson_7;

import java.util.Scanner;

public class Point {
    private int x;
    private int y;

    // конструктор
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    // геттеры
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
