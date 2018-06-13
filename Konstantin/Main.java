package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String flag = "u";
        double result = 0;
        double b;
        while(flag.equals("u")) {


            System.out.print(" continue enter u, exit enter x = ");
            flag = in.next();
            if (flag.equals("x")) break;

            System.out.print("Enter number 1 = ");
            double a = in.nextDouble();

            if (result == 0 ){
                System.out.print("Enter number 2 = ");
                b = in.nextDouble();}
            else b = result;

            System.out.print("Сhoose action ( + - * / %) = ");
            String с = in.next();

            if (с.equals("+"))
                System.out.println(a + " + " + b + " = " + (result = a + b));
            else if (с.equals("-"))
                System.out.println(a + " - " + b + " = " + (result = a - b));
            else if (с.equals("*"))
                System.out.println(a + " * " + b + " = " + (result = a * b));
            else if (с.equals("/"))
                System.out.println(a + " / " + b + " = " + (result = a / b));
            else if (с.equals("%"))
                System.out.println(a + " % " + b + " = " + (result = a % b));
            else
                System.out.print("Invalid Action");

        }

    }
}
