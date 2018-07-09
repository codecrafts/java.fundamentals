package CodeCrafts;

    import java.util.Scanner;

public class lesson3 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Программа-калькулятор.");
        System.out.println("Введите ваше первое число:");

        float result;
        float first = in.nextFloat();
        System.out.println("Введите ваше второе число:");
        float second = in.nextFloat();
        System.out.println("Введите необходимое действие: +, *, /, ^, &");
        String action = in.next();

        if (action.equals("+"))
        {
            result = first + second;
            System.out.println("Сложение: " + first + "+" + second + "=" + result);
        }
        else
        if (action.equals("*"))
        {
            result = first * second;
            System.out.println("Умножение: " + first + "*" + second + "=" + result);
        }
        else
        if (action.equals("/"))
        {
            result = first / second;
            System.out.println("Деление : " + first + "/" + second + "=" + result);
        }
        else
        if (action.equals("^"))
        {
            result = (int)first ^ (int)second;      // Приведение к целым числам
            System.out.println("Если были введены дробные числа, они будут приведены к целым int!");
            System.out.println("XOR: " + (int)first  + "^" + (int)second + "=" + (int)result);
        }
        else if (action.equals("&"))
        {
            result = (int)first & (int)second;      // Приведение к целым числам
            System.out.println("Если были введены дробные числа, они будут приведены к целым int!");
            System.out.println("Bitwise-AND: " + (int)first  + "&" + (int)second + "=" + (int)result);
        }
        else

        System.out.println("Ошибка выбора действия!");



    }
}
