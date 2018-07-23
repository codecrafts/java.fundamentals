/*
Задача:
Пользователь вводит строку. Программа определяет является ли данная строка потенциально валидным IPv4 адресом.
(255.255.255.255 - является, а 255.255.255.257 - нет)
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите IPv4 адрес :");
        String ip = input.next();
        ArrayList<String> splitInput = new ArrayList<>();

        for (String element : ip.split("\\.")) {
            if (inputChecker(element))
                splitInput.add(element);
            else
                break;
        }

        if (numChecker(splitInput) && splitInput.size() == 4)           // Проверяем, что ввод удовлетворяет маске IPv4.
            System.out.println("Введен корректный IPv4 адрес: " + ip);
        else
            System.out.println("Введен некорректный IPv4 адрес.");

        input.close();
    }

    static boolean inputChecker(String input) {
        boolean checker = true;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)))
                continue;
            else {
                checker = false;
                break;
            }
        }

        return checker;
    }

    static boolean numChecker(ArrayList<String> input) {
        boolean checker = false;

        for (String element : input) {
            if (!element.equals("") && Integer.parseInt(element) >= 0 && Integer.parseInt(element) <= 255) {
                checker = true;
            }else {
                checker = false;
                break;
            }
        }

        return checker;
    }
}