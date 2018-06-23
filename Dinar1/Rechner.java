package ru.codecrafts;
import java.util.Scanner;

public class Rechner {
    static int digit1;
    static int digit2;
    static String operating;
    static Integer outcome;

    public static void main(String[] args) {
        enterMetrics();
        outcome();
        System.out.print(digit1 + " " + operating + " " + digit2 + " = " + outcome);
    }

    static void enterMetrics() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter the first number: ");
        digit1 = in.nextInt();
        System.out.println("Please, enter the second number: ");
        digit2 = in.nextInt();
        System.out.println("Now you need to enter the operation: ");
        operating = in.next();
    }

    static void outcome(){
        switch (operating){
            case "+":
                outcome = digit1 + digit2;
                break;
            case "/":
                outcome = digit1 / digit2;
                break;
            case "*":
                outcome = digit1 * digit2;
                break;
            case "^":
                outcome = digit1 ^ digit2;
                break;
            case "&":
                outcome = digit1 & digit2;
                break;
            default:
                System.out.println("The operation was not identified. Try again, please!");
        }
    }
}