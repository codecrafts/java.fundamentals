package ru.codecrafts;
import java.util.Scanner;
    /*
    Даны вершины прямоугольника x1, y1, x2, y2, x3, y3, x4, y4 (вводятся с консоли).
    Написать программу, которая считает площадь прямоугольника.
    Решить задачу в объектно-ориентированном стиле программирования, то есть ввести сущность.
    Также использовать наследование классов или интерфейсов при решении задачи. Написать автотесты к решению задачи.
    Введенные точки могут не образовывать нужную фигуру, площадь в этом случае NaN.
     */
public class Task_7 {
    static final int Test_size = 5;

    public static void main(String[] args) {
        Point a = inputPointXY("A");
        Point b = inputPointXY("B");
        Point c = inputPointXY("C");
        Point d = inputPointXY("D");
        Figure oblong = new Rectangle(a, b, c, d);

        if(!oblong.isValid ())
            System.out.println ("The entered coordinates do not form a rectangle!");
        else
            System.out.println ("The area of rectangle is " + oblong.getSquare());
        }

    static boolean attemptTest(){
        int testCounter = 0;
        Figure testOblong = Rectangle.newBuilder()       // the case when the coordinates lie on the same line
                .setA(0, 0)
                .setB(2, 2)
                .setC(1, 1)
                .setD(1, 0)
                .build();
        Figure testOblong1 = Rectangle.newBuilder()      // the case where the coordinates of two points are identical
                .setA(0, 0)
                .setB(2, 2)
                .setC(2, 2)
                .setD(1, 0)
                .build();
        Figure testOblong2 = Rectangle.newBuilder()      // the case where the coordinates form a rectangle
                .setA(0, 0)
                .setB(0, 2)
                .setC(2, 2)
                .setD(2, 0)
                .build();

        if (!testOblong.isValid ()) testCounter++;             // check whether three points lie on the same line
        if (!testOblong1.isValid ()) testCounter++;            // checking the entered coordinates
        if (testOblong2.isValid ()) testCounter++;
        if (testOblong2.getSquare() != 0) testCounter++;       // check the area
        if (Double.isNaN(testOblong.getSquare())) testCounter++;
        System.out.println (attemptTest() ? "test passed" : "test failed");
        return testCounter == Test_size;                       // return true if all tests passed successfully
    }
    public static Point inputPointXY(String point){
        Scanner get = new Scanner(System.in);
        System.out.println("Enter the 1-st coordinate of point: " +  point);
        int x = get.nextInt();
        System.out.println("Enter the 2-nd coordinate of point: ");
        int y = get.nextInt();
        return new Point(x, y);
    }
}

