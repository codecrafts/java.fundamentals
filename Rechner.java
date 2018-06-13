package ru.codecrafts;
import java.util.Scanner;
public class Rechner {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String button = "y";
        int result = 0;
        int y;
        int i = 0;
        while (button.equals("y"))
        {
            System.out.print("To continue press y, to exit press n: ");
            button = in.next();
            if (button.equals("n"))
                break;

        System.out.println("Please enter the first number: ");
        int x = in.nextInt();
        if (i == 0 )
        {
            System.out.println("Please enter the second number: ");
            y = in.nextInt();
        }
        else y = result;

        System.out.println("Now you need to enter the operation: ");
        String z = in.next();

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
            i++;
        }
    }
}


