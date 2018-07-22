/*
Пользователь вводит натуральное число. Программа переводит введенное число в шестнадцатиричную систему счисления.
Например: 15 -> F, 16 -> 10 и тд
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson5 {
    public static void main(String[] args) {

        int decNumber = inputNat();
        String hex = hexNums(reverseOfArray(decToHex(inputNat())));
        int subIndex = 0;

        for (int i = 0; i < hex.length(); i++) {   // Считаем сколько лишних нулей в начале числа в ответе.
            if (hex.charAt(i) != '0') {
                subIndex = i;
                break;
            }
        }
        System.out.println("В шестнадцатеричной системе счисления натуральное число "
                + decNumber + " будет иметь вид: " + hex.substring(subIndex,hex.length()));
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

        return number;
    }

    static ArrayList<Byte> decToHex(int natNum) {   // Метод перевода из десятичной системы в шестнадцатеричную.
        ArrayList<Byte> hexMassive = new ArrayList<>();
        byte byteNum = 0;

        for (int i = 0; i < 8; i++) {
            byteNum = (byte) (natNum & 0x0F);
            hexMassive.add(byteNum);
            natNum >>= 4;
        }

        return hexMassive;
    }

    static ArrayList<Byte> reverseOfArray(ArrayList<Byte> arrayToReverse) {       // Метод для инверсии списка.
        ArrayList<Byte> reversedArray = new ArrayList<>();
        for (int i = arrayToReverse.size()-1; i >= 0; i--) {
            reversedArray.add(arrayToReverse.get(i));
        }
        return reversedArray;
    }

    static String hexNums(ArrayList<Byte> input) {
        String numHex = "";                                             // находится в начале массива.

        for (Byte i : input) {           // Сопоставление цифр буквам 16-ричного алфавта.
            switch (Integer.toString(i)) {
                case "10":
                    numHex += "A";
                    break;
                case "11":
                    numHex += "B";
                    break;
                case "12":
                    numHex += "C";
                    break;
                case "13":
                    numHex += "D";
                    break;
                case "14":
                    numHex += "E";
                    break;
                case "15":
                    numHex += "F";
                    break;
                default:
                    numHex += i;
                    break;
            }
        }

        return numHex;
    }
}