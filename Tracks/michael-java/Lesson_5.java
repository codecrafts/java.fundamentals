package lesson_5;
/*
Пользователь вводит натуральное число. Программа переводит введенное число в римскую систему счисления.
Например: 5 -> V, 8 -> VIII, 10 -> X и тд
 */

import java.util.Scanner;

public class Lesson_5 {
    public static void main(String[] args) {
        int arabicNumber = 0;           // введенное число
        String romeNumber = "";         // результат перевода арабского в римское

        arabicNumber = getArabicNumber();               // ввод числа с консоли
        romeNumber = arabicToRome(arabicNumber);        // перевод из араб в Рим
        outToConsole(romeNumber, arabicNumber);         // вывод в консоль

        System.out.println (tests () ? "тест пройден" : "тест не пройден");         // вывод в консоль результата прохождения тестов
    }

    static int getArabicNumber() {
        Scanner in = new Scanner (System.in);
        int number;
        System.out.println ("Введите натуральное число от 1 до 3999:");
        number = in.nextInt();
        return number;
    }
    static String arabicToRome(int arabicNum){
        String romeNum = "";        // римское число
        int index;                  // индекс элемента массива арабско-Римских чисел
        int[] arabic = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        if (arabicNum >= 4000 || arabicNum <= 0)        // входящее число входит в допустимый диапазон
            return null;

        index = arabic.length - 1;
        while(arabicNum > 0)                            // в цикле собираем Римское число
        {
            if(arabicNum >= arabic[index])
            {
                romeNum += roman[index];
                arabicNum -= arabic[index];
            }
            else
                index--;
        }
        return romeNum;
    }

    static void outToConsole(String romeNum, int arabicNum){
        if (romeNum == null)
            System.out.println ("Число вне диапазона");
        else
            System.out.println ("Результат перевода числа " + arabicNum + " в Римскую систему - " + romeNum);
    }

    static boolean tests (){
        boolean testCondition = false;      // переменная хранит состояние прохождения теста

        testCondition = arabicToRome(-12345) == null ? true : false;
        testCondition = arabicToRome(-1) == null ? true : false;
        testCondition = arabicToRome(4000) == null ? true : false;
        testCondition = arabicToRome(0) == null ? true : false;
        testCondition = arabicToRome(123) == null ? false : true;

        return testCondition;
    }
}
