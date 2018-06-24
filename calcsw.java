package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long a;
        long b;
        long result = 0;
        Scanner in = new Scanner(System.in);
        String str;
        String beh="n";

        while (beh.equals("n")) {

            System.out.print("Введите первое число a : ");
            a = in.nextLong();
            System.out.print("Введите второе число b : ");
            b = in.nextLong();

            System.out.print("Выберите операцию над числами (-, %, *, |, >>) : ");

            switch (str = in.next()) {
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

            System.out.print(" Для продожения введите n, для выхода x :");
            beh = in.next();
        }

    }
}
