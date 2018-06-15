package ru.codecrafts;
import java.util.Scanner;
public class Rechner
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String button = "Y";
        int result = 0;
        int digit2;

        for (;button.equals("go") || button.equals("Y");)
        {
            System.out.println("Please enter the first number: ");
            int digit1 = in.nextInt();

            if (button.equals("Y") )
            {
                System.out.println("Please enter the second number: ");
                digit2 = in.nextInt();
            }
            else digit2 = result;

            System.out.println("Now you need to enter the operation: ");
            String operation = in.next();

            switch (operation)
            {
                case "+":
                    result = digit1 + digit2;
                    System.out.println(digit1 + " + " + digit2 + " = " + result);
                    break;
                case "/":
                    result = digit1 / digit2;
                    System.out.println(digit1 + " / " + digit2 + " = " + result);
                    break;
                case "*":
                    result = digit1 * digit2;
                    System.out.println(digit1 + " * " + digit2 + " = " + result);
                    break;
                case "^":
                    result = digit1 ^ digit2;
                    System.out.println(digit1 + " ^ " + digit2 + " = " + result);
                    break;
                case "&":
                    result = digit1 & digit2;
                    System.out.println(digit1 + " & " + digit2 + " = " + result);
                    break;
                default:
                    System.out.print("The operation was not identified. Try again.");
            }
            System.out.println("To continue press go, to exit press exit");
            button = in.next();
        }
    }
}


