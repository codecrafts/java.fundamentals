import java.util.Scanner;

public class Lesson7 {
    public static void main(String[] args) {
        Dot[] dots = new Dot[4];
        Integer x = 0;
        Integer y = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.println("Введите координату х точки " + i + " :");

            while (input.hasNext()) {
                if (input.hasNextInt()) {
                    x = input.nextInt();
                    break;
                }else {
                    System.out.println("Введенна некорректная координата. Повторите ввод:");
                    input.next();
                }
            }

            System.out.println("Введите координату y точки " + i + " :");

            while (input.hasNext()) {
                if (input.hasNextInt()) {
                    y = input.nextInt();
                    break;
                }else {
                    System.out.println("Введенна некорректная координата. Повторите ввод:");
                    input.next();
                }
            }

            dots[i] = new Dot(x,y);
        }

        Quadrangle quadrangle = new Quadrangle(dots);
        Double square = Double.NaN;

        if (quadrangle.isRectangle()) {
            Rectangle rectangle = new Rectangle(dots, quadrangle);
            square = rectangle.getSquare();
            System.out.print("Площадь прямоугольника равна: ");
            System.out.printf("%.2f",square);
            System.out.println();
        }
        else
            System.out.println("Фигура не является прямоугольником.");

        if (testCode())
            System.out.println("Тест пройден.");
        else
            System.out.println("Тест не пройден.");

    }

    public static boolean checkRectangle(Integer... coords) {
        Dot[] dots = new Dot[4];

        for (int i = 0; i < 4; i++)
            dots[i] = new Dot(coords[i*2],coords[i*2+1]);

        Quadrangle quadrangle = new Quadrangle(dots);
        return quadrangle.isRectangle();
    }

    public static boolean testCode () {
        boolean testPass = false;
        int counter = 0;

        if (checkRectangle(0,0,1,0,0,1,1,1))
            counter++;
        if (checkRectangle(1,1,1,1,1,1,1,1))
            counter++;
        if (!checkRectangle(1,6,9,2,1,13,8,1))
            counter++;

        if (counter == 3)
            testPass = true;

        return testPass;
    }
}
