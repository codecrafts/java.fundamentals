package ru.codecrafts;
import java.util.Scanner;
public class Rechner {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter the first number: ");
        int x = in.nextInt();
        System.out.println("Please enter the first number: ");
        int y = in.nextInt();
        System.out.println("Now you need to enter the operation: ");
        String z = in.next();

        if (z.equals("+"))
            System.out.println(x + " + " + y + " = " + (x + y));
        else if (z.equals("/"))
            System.out.println(x + " / " + y + " = " + (x / y));
        else if (z.equals("*"))
            System.out.println(x + " * " + y + " = " + (x * y));
        else if (z.equals("^"))
            System.out.println(x + " ^ " + y + " = " + (x ^ y));
        else if (z.equals("&"))
            System.out.println(x + " & " + y + " = " + (x & y));
        else
            System.out.print("The operation was not identified. Try again.");
    }
}

