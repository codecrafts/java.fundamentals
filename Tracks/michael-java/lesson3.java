package CodeCrafts;

    import java.util.Scanner;

public class lesson3 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
		float result;

        System.out.println("Программа-калькулятор.");

        System.out.println("Введите ваше первое число:");
        float firstNumber = in.nextFloat();

        System.out.println("Введите ваше второе число:");
        float secondNumber = in.nextFloat();

        System.out.println("Введите необходимое действие: +, *, /, ^, &");
        String action = in.next();

        if (action.equals("+"))
        {
            result = firstNumber + secondNumber;
            System.out.println("Сложение: " + firstNumber + "+" + secondNumber + "=" + result);
        }
        else
        if (action.equals("*"))
        {
            result = firstNumber * secondNumber;
            System.out.println("Умножение: " + firstNumber + "*" + secondNumber + "=" + result);
        }
        else
        if (action.equals("/"))
        {
            result = firstNumber / secondNumber;
            System.out.println("Деление: " + firstNumber + "/" + secondNumber + "=" + result);
        }
        else
        if (action.equals("^"))
        {
            result = (int)firstNumber ^ (int)secondNumber;      // Приведение к целым числам
            System.out.println("Если были введены дробные числа, они будут приведены к целым int!");
            System.out.println("XOR: " + (int)firstNumber  + "^" + (int)secondNumber + "=" + (int)result);
        }
        else if (action.equals("&"))
        {
            result = (int)firstNumber & (int)secondNumber;      // Приведение к целым числам
            System.out.println("Если были введены дробные числа, они будут приведены к целым int!");
            System.out.println("Bitwise-AND: " + (int)firstNumber  + "&" + (int)secondNumber + "=" + (int)result);
        }
        else
            System.out.println("Ошибка выбора действия!");

    }
}
