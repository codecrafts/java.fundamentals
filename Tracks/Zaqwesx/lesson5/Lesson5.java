/*
Пользователь вводит натуральное число. Программа переводит введенное число в шестнадцатиричную систему счисления.
Например: 15 -> F, 16 -> 10 и тд
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson5 {
    public static final int shiftNum = 8;   // В int 32 бита. Каждые 4 бита это коэффициент степени 16. Для получения
                                            // всех степеней 16 из int необходимо 8 сдвигов.
    public static final char[] hexSymbols = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static void main(String[] args) {
        int decNumber = inputNat();
        String hexValue = new String(decToHex(decNumber));

        System.out.println("В шестнадцатеричной системе счисления натуральное число "
                + decNumber + " будет иметь вид: " + hexValue);
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
                    System.out.println("Введенно некорректное число. Повторите ввод:");
                }
            }else {
                System.out.println("Введенно некорректное число. Повторите ввод:");
                input.next();
            }
        }

        input.close();
        return number;
    }

    static char[] decToHex(int natNum) {   // Метод перевода из десятичной системы в шестнадцатеричную.
        byte byteNum;
        char[] hexNum = new char[8];

        for (int i = 0; i < shiftNum; i++) {
            byteNum = (byte) (natNum & 0x0F);
            hexNum[hexNum.length - 1 - i] = hexSymbols[byteNum];
            natNum >>= 4;
        }
        return hexNum;
    }
}