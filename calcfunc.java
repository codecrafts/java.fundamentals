package com.company;
import java.util.Scanner;
public class Main {
    static long a;
    static long b;
    static long result;
    static String str;

    public static long minus(long a, long b)
    {
        return a - b;
    }
    public static long percent(long a, long b)
    {
        return a % b;
    }
    public static long mult(long a, long b)
    {
        return a * b;
    }
    public static long bitor(long a, long b)
    {
        return a | b;
    }
    public static long rshift(long a, long b)
    {
        return a >> b;
    }
    public static void inputout()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите два числа а и b, операцию(-, %, *, |, >>) через Enter:");
        a = in.nextLong();
        b = in.nextLong();
        str = in.next();

    }

    public static void main(String[] args) {

        inputout();

        switch (str) {
            case "-":
                result = minus(a, b);
                System.out.println("Результат операции - над числами " + a + " и " + b + " = " + result);
                break;

            case "%":
                result = percent(a, b);
                System.out.println("Результат операции % над числами " + a + " и " + b + " = " + result);
                break;

            case "*":
                result = mult(a, b);
                System.out.println("Результат операции * над числами " + a + " и " + b + " = " + result);
                break;

            case "|":
                result = bitor(a, b);
                System.out.println("Результат операции - над числами " + a + " и " + b + " = " + result);
                break;

            case ">>":
                result = rshift(a, b);
                System.out.println("Результат операции >> над числами " + a + " и " + b + " = " + result);
                break;

            default:
                System.out.println("Операция выбрана не верно!");
        }    
    }
}
