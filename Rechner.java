package ru.codecrafts;
import java.util.Scanner;
public class Rechner {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the first number: ");
        int x = in.nextInt();
        System.out.println("Please enter the second number: ");
        int y = in.nextInt();
        System.out.println("Now you need to enter the operation: ");
        String z = in.next();
        int result = 0;

        if (z.equals("+"))
            System.out.println(x + " + " + y + " = " + (result = x + y));
        else if (z.equals("/"))
            System.out.println(x + " / " + y + " = " + (result = x / y));
        else if (z.equals("*"))
            System.out.println(x + " * " + y + " = " + (result = x * y));
        else if (z.equals("^"))
            System.out.println(x + " ^ " + y + " = " + (result = x ^ y));
        else if (z.equals("&"))
            System.out.println(x + " & " + y + " = " + (result = x & y));
        else
            System.out.print("The operation was not identified. Try again.");

        int i = 0;
        String button = "yes";
        while (i < 1000 & button.equals("yes"))
        {
            Scanner big = new Scanner(System.in);
            System.out.print("To continue press yes, to exit press no: ");
            button = big.next();
            if (button.equals("no"))
                break;

            System.out.println("Enter the operation again: ");
            String r = in.next();
            System.out.println("Please enter the third number: ");
            int b = in.nextInt();
            i++;

            if (r.equals("+"))
                System.out.println(b + " + " + result + " = " + (b + result));
            else if (r.equals("/"))
                System.out.println(b + " / " + result + " = " + (b / result));
            else if (r.equals("*"))
                System.out.println(b + " * " + result + " = " + (b * result));
            else if (r.equals("^"))
                System.out.println(b + " ^ " + result + " = " + (b ^ result));
            else if (r.equals("&"))
                System.out.println(b + " & " + result + " = " + (b & result));
            else
                System.out.print("The operation was not identified. Try again.");
            }
        }
    }

