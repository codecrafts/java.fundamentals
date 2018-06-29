package com.company;
import java.util.Scanner;
public class Main {
    static long a;
    static long b;
    static long result;
    static String str;

    public static void minus(long a, long b)
    {
        long result = 0;
        result = a - b;
    }
    public static void percent(long a, long b)
    {
        long result = 0;
        result = a % b;
    }
    public static void mult(long a, long b)
    {
        long result = 0;
        result = a * b;
    }
    public static void bitor(long a, long b)
    {
        long result = 0;
        result = a | b;
    }
    public static void rshift(long a, long b)
    {
        long result = 0;
        result = a >> b;
    }
    public static void inputout()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите два числа а и b, операцию(-, %, *, |, >>) через Enter:");
        a = in.nextLong();
        b = in.nextLong();
        str = in.next();

    }

    public static void resultop()
    {
        inputout();

        switch (str) {
            case "-":
                result = a - b;
                System.out.println("Результат операции - над числами " + a + " и " + b + " = " + result);
                break;

            case "%":
                result = a % b;
                System.out.println("Результат операции % над числами " + a + " и " + b + " = " + result);
                break;

            case "*":
                result = a * b;
                System.out.println("Результат операции * над числами " + a + " и " + b + " = " + result);
                break;

            case "|":
                result = a | b;
                System.out.println("Результат операции - над числами " + a + " и " + b + " = " + result);
                break;

            case ">>":
                result = a >> b;
                System.out.println("Результат операции >> над числами " + a + " и " + b + " = " + result);
                break;

            default:
                System.out.println("Операция выбрана не верно!");
        }
    }
    public static void main(String[] args) {

        resultop();
    }
}
