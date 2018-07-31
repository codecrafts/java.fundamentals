package lesson_7;
    /*
    Даны вершины треугольника x1, y1, x2, y2, x3, y3 (вводятся с консоли). Написать программу, которая считает площадь треугольника.
    Решить задачу в объектно-ориентированном стиле программирования - то есть ввести сущность.
    Также использовать наследование классов или интерфейсов при решении задачи.
    Написать автотесты к решению задачи.
    Введенные точки могут не образовывать нужную фигуру, площадь в этом случае NaN.
     */

public class Lesson_7 {
    static final int AMOUNT_TEST = 4;

    public static void main(String[] args) {

        Triangle trigon = BuilderTriangle.createTriangle();

        if (Checker.dotInLine (trigon))
            System.out.println ("Треугольник не треугольный!");
        else
            System.out.println ("Площадь треугольника = " + trigon.getSquare());

        System.out.println (tryTests() ? "тест пройден" : "тест не пройден");       // тесты
    }


    static boolean tryTests(){      // тесты
        int testComplete = 0;       // переменная хранит состояние прохождения теста

        Triangle testTrigon = Triangle.newBuilder()
                .setA(0, 0)
                .setB(2, 2)
                .setC(1, 1)
                .build();

        Triangle testTrigon2 = Triangle.newBuilder()
                .setA(0, 0)
                .setB(0, 2)
                .setC(2, 0)
                .build();

        if (Checker.dotInLine (testTrigon)) testComplete++;                 // проверка лежат ли три точки на одной прямой
        if (!Checker.dotInLine (testTrigon2)) testComplete++;
        if (testTrigon2.getSquare() != 0) testComplete++;                   // проверка площади
        if (Float.isNaN(testTrigon.getSquare())) testComplete++;

        return testComplete == AMOUNT_TEST;                                 // возвращаем истину, если прошли все тесты успешно
    }
}
