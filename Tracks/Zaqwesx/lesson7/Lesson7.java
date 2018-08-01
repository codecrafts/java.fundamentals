import java.util.Scanner;

public class Lesson7 {
    public static void main(String[] args) {
        Dot[] dots = new Dot[4];
        int x = 0;
        int y = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Введите координаты точек. Порядок ввода определяет построение фигуры.");

        for (int i = 0; i < 4; i++) {
            System.out.println("X" + i + " :");

            while (input.hasNext()) {
                if (input.hasNextInt()) {
                    x = input.nextInt();
                    break;
                }else {
                    System.out.println("Введенна некорректная координата. Повторите ввод координаты Х" + i + ":");
                    input.next();
                }
            }

            System.out.println("Y" + i + " :");

            while (input.hasNext()) {
                if (input.hasNextInt()) {
                    y = input.nextInt();
                    break;
                }else {
                    System.out.println("Введенна некорректная координата. Повторите ввод координаты Y" + i + ":");
                    input.next();
                }
            }

            dots[i] = new Dot(x, y);     // Заполняем массив точек введенными координатами.
        }

        input.close();

        Rectangle rectangle = new Rectangle(dots);
        double square = rectangle.getSquare();
        System.out.print("Площадь прямоугольника равна: ");
        System.out.printf("%.2f", square);
        System.out.println();

        if (testCode())
            System.out.println("Тест пройден.");
        else
            System.out.println("Тест не пройден.");

    }

    public static Dot[] setCoords(Integer... coords) {      // Метод превращает массив цифр в массив координат.
        Dot[] dots = new Dot[4];                            // Удобно для проведения тестов.

        for (int i = 0; i < 4; i++)
            dots[i] = new Dot(coords[i*2], coords[i*2+1]);

        return dots;
    }



    public static boolean testCode () {
        boolean testPass = false;
        int counter = 0;
        Dot[] testDots;

        testDots = setCoords(0,0,2,0,2,1,0,1);
        Rectangle testRect1 = new Rectangle(testDots);
        if (testRect1.getSquare() == 2)
            counter++;

        testDots = setCoords(0,0,1,1,0,1,1,0);
        Rectangle testRect2 = new Rectangle(testDots);
        if (Double.isNaN(testRect2.getSquare()))
            counter++;

        testDots = setCoords(0,0,1,1,2,2,3,3);
        Rectangle testRect3 = new Rectangle(testDots);
        if (Double.isNaN(testRect3.getSquare()))
            counter++;

        if (counter == 3)
            testPass = true;

        return testPass;
    }
}
