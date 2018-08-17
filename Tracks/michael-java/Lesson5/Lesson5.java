package lesson_5;
/*
Пользователь вводит натуральное число. Программа переводит введенное число в римскую систему счисления.
Например: 5 -> V, 8 -> VIII, 10 -> X и тд
 */

import java.util.Scanner;

public class Lesson5 {
    static final int amountTest = 5;    // количество тестов

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
        System.out.println ("Введите натуральное число от 1 до 3999:");
        int number = in.nextInt();
        return number;
    }

    static String arabicToRome(int arabicNum){
        String romeNum = "";        // римское число
        int[] arabic = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        if (arabicNum >= 4000 || arabicNum <= 0)        // входящее число входит в допустимый диапазон
            return "";

        int index = arabic.length - 1;                  // индекс элемента массива арабско-Римских чисел
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
        if (romeNum.equals(""))
            System.out.println ("Число вне диапазона");
        else
            System.out.println ("Результат перевода числа " + arabicNum + " в Римскую систему - " + romeNum);
    }

    static boolean tests (){
        int testComplete = 0;      // переменная хранит состояние прохождения теста

        if(arabicToRome(-12345).equals ("")) testComplete++;
        if(arabicToRome(-1).equals ("")) testComplete++;
        if(arabicToRome(4000).equals ("")) testComplete++;
        if(arabicToRome(0).equals ("")) testComplete++;
        if(!arabicToRome(123).equals ("")) testComplete++;

        return testComplete == amountTest;
    }
}