package ru.codecrafts;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        boolean digit = false;
        String number = inputText();
        if(number.equals("test")) {
            autoTesting();
        }
        else {
            digit = checkNumber(number);
            printString(digit);
        }
    }
    static String inputText() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter the phone number or write test ");
        String mark = in.next();
        return mark;
    }
    //Входные данные: номер телефона - строка
    //Выходные  данные: булена тип (прав, неправ номер)
    static boolean validateString(String mark) {
        if (mark.startsWith("+79") || mark.startsWith("89"))
            return true;
        else
            return false;
    }
    static boolean countString(String bar) {
        if(bar.length() == 12 && bar.startsWith("+7"))
            return true;
        else if (bar.length() == 11 && bar.startsWith("8"))
            return true;
        else
            return false;
    }
    static boolean checkString(String text) {
        boolean testString = false;
        char[] numberName = new char[text.length()];
        text.getChars(0, text.length(), numberName, 0);
        for (int i = 0; i < numberName.length; i++) {
            switch (numberName[i]) {
                case '+':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    testString = true;
                    break;
                default:
                    return testString = false;
            }
        }
        return testString;
    }
    static void autoTesting() {
        if (checkNumber("89262512628" ) &&  !checkNumber("0912409988997"))
            System.out.println("Test passed!");
        else
            System.out.println("Test failed!");
    }
    static boolean checkNumber(String number) {
        if(validateString(number) && countString(number) && checkString(number))
            return true;
        else
            return false;
    }
    static void printString(boolean end) {
        if(end)
            System.out.println("Number is correct!");
        else
            System.out.println("Number is not correct!");
    }
}
