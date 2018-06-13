package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String flag = "u";
        double result = 0;
        double b;

        for(int i = 0;flag.equals("u");i++)
        {

            System.out.print("Enter number 1 = ");
            double a = in.nextDouble();

            if (i == 0 )
            {
                System.out.print("Enter number 2 = ");
                b = in.nextDouble();
            }
            else b = result;

            System.out.print("Сhoose action ( + - * / %) = ");
            String c = in.next();

            switch (c) {
                case "+":
                    result = a + b;
                    System.out.println(a + " + " + b + " = " + result);
                    break;
                case "-":
                    result = a - b;
                    System.out.println(a + " - " + b + " = " + result);
                    break;
                case "*":
                    result = a * b;
                    System.out.println(a + " * " + b + " = " + result);
                    break;
                case "/":
                    result = a / b;
                    System.out.println(a + " / " + b + " = " + result);
                    break;
                case "%":
                    result = a % b;
                    System.out.println(a + " % " + b + " = " + result);
                    break;
                default:
                    System.out.print("Invalid Action");
            }

            System.out.print(" continue enter u, exit enter x = ");
            flag = in.next();


        }

    }
}
