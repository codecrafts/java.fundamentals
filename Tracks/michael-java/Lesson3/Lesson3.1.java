package CodeCrafts;

import java.util.Scanner;

public class Lesson3.1 {
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

        switch (action)
        {
            case "+":
                result = firstNumber + secondNumber;
                System.out.println("Складываем " + firstNumber + "+" + secondNumber + "=" + result);
                break;
            case "*":
                result = firstNumber * secondNumber;
                System.out.println("Умножаем " + firstNumber + "*" + secondNumber + "=" + result);
                break;
            case "/":
                result = firstNumber / secondNumber;
                System.out.println("Делим " + firstNumber + "/" + secondNumber + "=" + result);
                break;
            case "^":
                result = (int)firstNumber ^ (int)secondNumber;      // Приведение к целым числам
                System.out.println("В случае ввода дробных чисел, они будут приведены к целым!");
                System.out.println("XOR: " + (int)firstNumber  + "^" + (int)secondNumber + "=" + (int)result);
                break;
            case "&":
                result = (int)firstNumber & (int)secondNumber;      // Приведение к целым числам
                System.out.println("В случае ввода дробных чисел, они будут приведены к целым!");
                System.out.println("Bitwise-AND: " + (int)firstNumber  + "&" + (int)secondNumber + "=" + (int)result);
                break;
            default:
                System.out.println("Ошибка выбора действия!");
        }
    }
}