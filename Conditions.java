package ru.codecrafts;

import java.util.Scanner; // Импорт типа Scanner из пакета java.util

public class Conditions
{
    public static void main(String[] args)
    {
        System.out.println("Enter number:"); // Вывод в консоль
        Scanner in = new Scanner(System.in); // Создается объект класса Scanner
        int a = in.nextInt(); // Считывается из консоли объект типа int

        // Условное выражение
        if ( a == 0) // Условие1 в скобках
        {
            System.out.println("a == 0"); // Блок1 если условие a == 0 выполнено (true)
            System.out.println("a == 0");
        }
        else if (a == 1) // Условие2 в скобках
        {
            System.out.println("a == 1"); // Блок2 если условие a == 1 выполнено (true)
        }
        else if (a == 2)  // Условие3 в скобках
            System.out.println("a == 2"); // Блок3 если условие a == 2 выполнено (true)
        else
            System.out.println("a is another value"); // Блок4 если никакое условие не было выполнено

        // Сокращенная форма условного выражения
        String textToConsole = a > 0 ?
                "a is positive"  :
                "a is negetive";
        System.out.println(textToConsole); // Печать в консоль
    }
}
