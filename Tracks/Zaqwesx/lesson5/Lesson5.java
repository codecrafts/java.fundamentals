/*
Пользователь вводит натуральное число. Программа переводит введенное число в шестнадцатиричную систему счисления.
Например: 15 -> F, 16 -> 10 и тд
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson5 {
    public static final int BYTE_IN_INT = 8; // Константа. Количество byte в int.

    public static void main(String[] args) {
        int decNumber = inputNat();
        StringBuffer hexNumber = decToHex(decNumber);
        System.out.println("В шестнадцатеричной системе счисления натуральное число "
                + decNumber + " будет иметь вид: " + hexNumber);
    }

    static int inputNat() {             // Метод проверки ввода числа.
        int number = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите натуральное число:");

        while (input.hasNext()) {
            if (input.hasNextInt()) {
                number = input.nextInt();
                if (number > 0) {
                    break;
                }else {
                    System.out.println("Введенное значение не является натуральным числом. Повторите ввод:");
                }
            }else {
                System.out.println("Введенное значение не является натуральным числом. Повторите ввод:");
                input.next();
            }
        }

        input.close();
        return number;
    }

    static StringBuffer decToHex(int natNum) {   // Метод перевода из десятичной системы в шестнадцатеричную.
        byte byteNum = 0;
        StringBuffer hexNum = new StringBuffer();

        for (int i = 0; i < BYTE_IN_INT; i++) {
            byteNum = (byte) (natNum & 0x0F);
            hexNum.insert(0,Character.toString((char) byteNum));
            natNum >>= 4;
        }
        return hexNum;
    }

    static String hexNums(String input) {       // Замена чисел десятичного алфавита на шентснадцатеричный.
        String numHex = "";

        switch (input) {
            case 1:
                numHex = "A";
                break;
//            case 11:
////                numHex = "A";
////                break;
////            case 12:
////                numHex = "A";
////                break; 'A';
////            case 13:
////                numHex = "A";
////                break;
////            case 14:
////                numHex = "A";
////                break;
////            case 15:
////                numHex = "A";
////                break;
//            default:
////                numHex = Byte.toString(input);
//                break;
//        }
//
//        return input;
//    }
}