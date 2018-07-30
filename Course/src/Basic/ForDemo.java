package ru.codecrafts;

public class ForDemo
{
    public static void main(String[] args)
    {
        // For-цикл: сначала проверка условия - потом действие
        System.out.println("Result of for cycle:");
        for ( int i = 0; i < 10; i++ ) // Инициализация счетчика, булево выражение, Действие после итерации цикла
        { // Начало тела цикла
            // DEMO: Использование Break
            // if (i == 5)
            //    break;
            // DEMO: Использование Continue
             if (i == 4)
                 continue;
            System.out.print ("Ku-Ku ");
        } // Конец тела цикла for

        System.out.println("\nResult of for-each cycle:");
        String[] kukus = { "Ku-Ku ", "Ku-Ku ", "Ku-Ku " };
        for ( String val : kukus )
        { // Начало тела цикла
            System.out.print (val);
        } // Конец тела цикла foreach
    }
}
