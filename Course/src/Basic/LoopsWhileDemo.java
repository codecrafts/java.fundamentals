package ru.codecrafts;

public class LoopsWhileDemo
{
    public static void main(String[] args)
    {
        // While-цикл: сначала проверка условия - потом действие
        int i = 0; // Счетчик цикла
        System.out.println("Result of while cycle:");
        while( i < 10 ) // Булево выражение, которое определяет условие выхода из цикла
        { // Начало тела цикла
            // DEMO: Использование Break
            if (i == 5)
               break;
            System.out.print ("Ku-Ku ");
            i++;
        } // Конец тела цикла while

        // Do-While-цикл: сначала действие, потом проверка условия
        i = 0; // Обнуляем счетчик
        System.out.println("Result of do-while cycle:");
        do
        { // Начало тела цикла
            // DEMO: Использование continue
            if (i == 5) {
                i++;
                continue;
            }
            System.out.print ("Ku-Ku ");
            i++;
        } // Конец тела цикла do-while
        while( i < 10 ); // Булево выражение, которое определяет условие выхода из цикла
    }
}
