package lesson_7;
    /*
    Даны вершины треугольника x1, y1, x2, y2, x3, y3 (вводятся с консоли). Написать программу, которая считает площадь треугольника.
    Решить задачу в объектно-ориентированном стиле программирования - то есть ввести сущность.
    Также использовать наследование классов или интерфейсов при решении задачи.
    Написать автотесты к решению задачи.
    Введенные точки могут не образовывать нужную фигуру, площадь в этом случае NaN.
     */

public class Lesson_7 {
    static final int amountTest = 4;
    public static void main(String[] args) {

        Triangle trigon = new Triangle();
        float area = trigon.getSquare();
        System.out.println ("Площадь треугольника = " + area);
    }
    /*
    static boolean tryTests(){      // тесты
        int testComplete = 0;      // переменная хранит состояние прохождения теста

        if( trigon.getSquare() != 0 ) testComplete++;               // заведомо не валидный тест

        if( Triangle.getSquare() != 0) testComplete++;              // валидный тест

        return testComplete == amountTest              // возвращаем истину, если прошли все тесты успешно
    }*/
}
