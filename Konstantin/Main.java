package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String flag = "u";
        String FirstAction = "akt1";
        double result = 0;
        double num2;

        for(;flag.equals("u");)
        {

            System.out.print("Enter number 1 = ");
            double a = in.nextDouble();

            if (FirstAction.equals("akt1"))
            {
                System.out.print("Enter number 2 = ");
                num2 = in.nextDouble();
                FirstAction = "endakt";
            }
            else num2 = result;

            System.out.print("Сhoose action ( + - * / %) = ");
            String num1 = in.next();

            switch (num1) {
                case "+":
                    result = a + num2;
                    System.out.println(a + " + " + num2 + " = " + result);
                    break;
                case "-":
                    result = a - num2;
                    System.out.println(a + " - " + num2 + " = " + result);
                    break;
                case "*":
                    result = a * num2;
                    System.out.println(a + " * " + num2 + " = " + result);
                    break;
                case "/":
                    result = a / num2;
                    System.out.println(a + " / " + num2 + " = " + result);
                    break;
                case "%":
                    result = a % num2;
                    System.out.println(a + " % " + num2 + " = " + result);
                    break;
                default:
                    System.out.print("Invalid Action");
            }

            System.out.print(" continue enter u, exit enter x = ");
            flag = in.next();


        }

    }
}
