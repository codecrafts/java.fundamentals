package com.company;
import java.util.Scanner;

public class Main {
    public static int nod(int a, int b) {
        if (b == 0)
            return a;
        return nod(b, a % b);
    }
    public static void main(String[] args) {

        int a;
        int b;
        int result;
        Scanner in = new Scanner(System.in);

        System.out.println(" Данная программа находит НОД чисел а и b");
        System.out.println(" Введите число a:");
        a = in.nextInt();
        System.out.println(" Введите число b:");
        b = in.nextInt();
        result = nod(a, b);

        System.out.println(" НОД а и b = " + result);

   }
}
 