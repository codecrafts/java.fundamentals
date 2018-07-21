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
        String ip = "";

        while (input.hasNext()) {
            ip = input.next();
            if (inputChecker(ip)) {                                     // Проверяем, что вводятся только цифры или точки.
                ArrayList<String> splitArray = inputSplitter(ip);       // Разбиваем строку на кусочки по точкам.

                if (numChecker(splitArray) && splitArray.size() == 4)   // Проверяем, что кусочки это цифры в диапазоне 0-255
                    break;                                              // и кусочков всего 4.
                else
                    System.out.println("Некорректный ввод. Повторите попытку.");
            }else
                System.out.println("Некорректный ввод. Повторите попытку.");
        }

        input.close();
        System.out.println("Введен корректный IPv4 адрес: " + ip);
    }

    static boolean inputChecker(String input) {
        boolean checker = true;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)) || input.charAt(i) == '.')
                continue;
            else {
                checker = false;
                break;
            }
        }
        return checker;
    }

    static ArrayList<String> inputSplitter(String input) {
        ArrayList<String> splitInput = new ArrayList<>();

        for (String element : input.split("\\.")) {
            splitInput.add(element);
        }
        return splitInput;
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