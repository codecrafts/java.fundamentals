import java.util.Scanner;

public class quadraticEquation {
    //Константин:
    //Написать программу, которая решает квадратные уравнения
    // вида a*x*x + bx + c = 0; (a,b,c - задается пользователем)
    public static void main(String[] args) {
        double a = coefficient("Введите старший коэффициент (а)");

        while (a != 0) {
            System.out.println("Старший коэффициент не может быть равен 0");
            a = coefficient("Введите старший коэффициент (а)");
        }

        double b = coefficient("Введите коэффициент при х (b)");
        double c = coefficient("Введите свободный член (c)");

        double d = discriminantSearch(a, b, c);
        double result;
        if (d < 0) {
            System.out.println(d + " < 0 - квадратное уравнение не имеет корней");
        } else if (d == 0) {
            System.out.println(d + " = 0 - квадратное уравнение имеет 1 корнь");
            result = solutionOfEquation(a, b, d);
            System.out.println("корень уравнения равен x = " + result);
        } else if (d > 0) {
            System.out.println(d + " > 0 - квадратное уравнение имеет 2 корня");
            result = solutionOfEquation(a, b, Math.sqrt(d));
            System.out.println("1 корень уравнения равен x1 = " + result);
            result = solutionOfEquation(a, b,- Math.sqrt(d));
            System.out.println("2 корень уравнения равен x2 = " + result);
        }
    }
    static double coefficient (String text) {
        double value;
        Scanner in = new Scanner(System.in);
        System.out.println(text);
        value = in.nextDouble();
        return value;
    }
    static double discriminantSearch (double a, double b, double c) {
        double discriminant;
        discriminant = Math.pow(b, 2) - 4 * a * c;
        return discriminant;
    }
    static double solutionOfEquation (double a, double b, double rootOfNumber) {
        double result = (-b + rootOfNumber) / 2 * a;
        return result;
    }
    static void test() {
        double discriminantTest = discriminantSearch(1,2,1);
        if (discriminantTest == 0) {
            System.out.println("Проверка дискриминанта пройдена");
        } else System.out.println("В методе по поиску дискрименанта ошибка");

        double solutionTest = solutionOfEquation(1,1,3);
        if ( solutionTest == 1) {
            System.out.println("Проверка решения пройдена");
        } else System.out.println("В методе решения есть ошибка");

    }





}
