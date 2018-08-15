package lesson_7;
    /*
    Даны вершины треугольника x1, y1, x2, y2, x3, y3 (вводятся с консоли). Написать программу, которая считает площадь треугольника.
    Решить задачу в объектно-ориентированном стиле программирования - то есть ввести сущность.
    Также использовать наследование классов или интерфейсов при решении задачи.
    Написать автотесты к решению задачи.
    Введенные точки могут не образовывать нужную фигуру, площадь в этом случае NaN.
     */

import java.util.Scanner;

public class Lesson_7 {
    static final int AMOUNT_TEST = 5;

    public static void main(String[] args) {

        Point a = inputPointCoordinate("A");
        Point b = inputPointCoordinate("B");
        Point c = inputPointCoordinate("C");
        Figure trigon = new Triangle(a, b, c);

        if(!trigon.isValid ())
            System.out.println ("Введенные кординаты не образуют треугольник");
        System.out.println ("Площадь треугольника = " + trigon.getArea());

        System.out.println (tryTests() ? "тест пройден" : "тест не пройден");       // тесты
    }

    static boolean tryTests(){      // тесты
        int testComplete = 0;       // переменная хранит состояние прохождения теста

        Figure testTrigon = Triangle.newBuilder()         // координаты лежат на одной прямой
                .setA(0, 0)
                .setB(2, 2)
                .setC(1, 1)
                .build();

        Figure testTrigon1 = Triangle.newBuilder()        // координаты двух точек идентичны
                .setA(0, 0)
                .setB(2, 2)
                .setC(2, 2)
                .build();

        Figure testTrigon2 = Triangle.newBuilder()        // координаты образуют треугольник
                .setA(0, 0)
                .setB(0, 2)
                .setC(2, 0)
                .build();

        if (!testTrigon.isValid ()) testComplete++;                                  // проверка лежат ли три точки на одной прямой
        if (!testTrigon1.isValid ()) testComplete++;                                 // проверка введенных координат
        if (testTrigon2.isValid ()) testComplete++;
        if (testTrigon2.getArea() != 0) testComplete++;                      // проверка площади
        if (Float.isNaN(testTrigon.getArea())) testComplete++;

        return testComplete == AMOUNT_TEST;                                          // возвращаем истину, если прошли все тесты успешно
    }

    public static Point inputPointCoordinate(String point){
        Scanner take = new Scanner (System.in);
        System.out.println("Введите 1ю коодинату для точки " +  point);
        int x = take.nextInt ();
        System.out.println("Введите 2ю коодинату для точки ");
        int y = take.nextInt ();
        return new Point( x, y );
    }
}

