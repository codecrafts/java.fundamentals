package ru.codecrafts;
import java.util.Scanner;

public class SwitchDemo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter the first number: ");
        int x = in.nextInt();
        System.out.println("Please enter the first number: ");
        int y = in.nextInt();
        System.out.println("Now you need to enter the operation: ");
        String z = in.next();

        switch (z) // Выражение - это переменная типа String
        {
            case "+": // Случай, если значение z = +
            case "/": // Случай, если значение z = /
            {
                System.out.println(x + " + " + y + " = " + (x + y)); // Блок1
                System.out.println(x + " / " + y + " = " + (x / y)); // Блок1
            }
            case "*": // Случай, когда операция - это деление
                System.out.println(x + " * " + y + " = " + (x * y)); // Блок2
                break; // Конец Блок3
            case "^": // Случай, когда операция - это XOR
                System.out.println(x + " ^ " + y + " = " + (x ^ y)); // Блок3
                break; // Конец Блок4
            case "&": // Случай, когда операция - это битовая И
                System.out.println(x + " & " + y + " = " + (x & y)); // Блок4
                break; // Конец Блока5
            default: // Случай по умолчанию
                System.out.print("The operation was not identified. Try again."); // Блок по умолчанию
        }
    }
}
