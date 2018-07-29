package lesson_7;

import java.util.Scanner;

public class Point {

    float x;
    float y;
    private String name;

    // конструктор
    public Point(String name) {
        this.name = name;
        Scanner take = new Scanner (System.in);
        System.out.println ("Введите координату X для точки " + name);
        x = take.nextFloat();
        System.out.println ("Введите координату Y для точки " + name);
        y = take.nextFloat();
    }

    public Point (float x, float y){
        this.x = x;
        this.y = y;
    }

    public void getCoordinate(){
        System.out.println (x + " " + y);
    }

}
