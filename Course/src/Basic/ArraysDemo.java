package ru.codecrafts;
import java.util.ArrayList;

public class ArraysDemo
{
    public static void main(String[] args)
    {
        // Статические массив
        System.out.println("Static array demo:");
        String[] ccys = {"USD", "EUR", "RUB"}; // Инициализация массива

        // Доступ к элементам массива - специальные операторы языка
        ccys[1] = "YES";      // Запись во !вторую! ячейку
        String usd = ccys[0]; // Чтение из ячейки
        System.out.println("First element: " + usd);

        // Итерация по всем членам массива
        for ( String ccy : ccys )
            System.out.println(ccy);

        // Динамические массив
        System.out.println("Dynamic array (ArrayList) demo:");
        ArrayList<int> newCcys = new ArrayList<int>(); // Создание объекта ссылочного типа

        // Наполнение массива
        newCcys.add("RUB");
        newCcys.add("EUR");
        newCcys.add("USD");

        // Доступ к элементам контейнера осуществляется с помощью методов
        newCcys.set(1, "YES"); // Запись во вторую ячейку.
        usd = newCcys.get(0);  // Чтение из ячейки
        System.out.println("First element: " + usd);

        // Итерация по всем членам контейнера
        for ( String ccy : newCcys)
            System.out.println(ccy);
    }
}
