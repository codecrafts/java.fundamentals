package ru.codecrafts;
import java.util.Scanner;
public class Rechner
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String button = "Y";
        int result = 0;
        int zahl2;

        for (;button.equals("go")|button.equals("Y");)
        {
            System.out.println("Please enter the first number: ");
            int zahl1 = in.nextInt();

            if (button.equals("Y") )
            {
                System.out.println("Please enter the second number: ");
                zahl2 = in.nextInt();
            }
            else zahl2 = result;

            System.out.println("Now you need to enter the operation: ");
            String operation = in.next();

            switch (operation)
            {
                case "+":
                    result = zahl1 + zahl2;
                    System.out.println(zahl1 + " + " + zahl2 + " = " + result);
                    break;
                case "/":
                    result = zahl1 / zahl2;
                    System.out.println(zahl1 + " / " + zahl2 + " = " + result);
                    break;
                case "*":
                    result = zahl1 * zahl2;
                    System.out.println(zahl1 + " * " + zahl2 + " = " + result);
                    break;
                case "^":
                    result = zahl1 ^ zahl2;
                    System.out.println(zahl1 + " ^ " + zahl2 + " = " + result);
                    break;
                case "&":
                    result = zahl1 & zahl2;
                    System.out.println(zahl2 + " & " + zahl2 + " = " + result);
                    break;
                default:
                    System.out.print("The operation was not identified. Try again.");
            }
            System.out.println("To continue press go, to exit press exit");
            button = in.next();
        }
    }
}


