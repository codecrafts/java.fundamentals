package ru.codecrafts;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int digit1 = enterMetrics("Please, enter the first number: ");
        int digit2 = enterMetrics("Please, enter the second number: ");
        String operating = operation("Now you need to enter the operation: ");
        int outcome = consequence(digit1, digit2, operating);
        System.out.print(digit1 + " " + operating + " " + digit2 + " = " + outcome );
    }
    static int enterMetrics(String text) {
        Scanner in = new Scanner(System.in);
        System.out.println(text);
        int quantity = in.nextInt();
        return quantity;
    }
    static String operation(String sentence) {
        Scanner in = new Scanner(System.in);
        System.out.println(sentence);
        String operation = in.next();
        return operation;
    }
    static int consequence(int dig1, int dig2, String act) {
        int fetus  = 0;
        switch (act) {
            case "+":
                fetus = dig1 + dig2;
                break;
            case "/":
                fetus = dig1 / dig2;
                break;
            case "*":
                fetus = dig1 * dig2;
                break;
            case "^":
                fetus = dig1 ^ dig2;
                break;
            case "&":
                fetus = dig1 & dig2;
                break;
            default:
                System.out.println("You have typed a wrong action, so, please, try again!");
        }
        return fetus;
    }
}


