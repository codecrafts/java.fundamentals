// Тестирование

// Для Чего?
/*
Есть задача
В целях повышения эффективности работы команды для менеджера надо написать программу,
которая выводит номера недельных итераций, когда было выполнено задач выше среднего.
Входные данные:
Массив чисел (количество закрытых задач). Идут по порядку по итерациям.
Выходные данные.
Номера итераций, когда была производительность в задачах была выше среднего значения.
*/
// Нужно проверить программу перед тем как давать клиенту

package ru.codecrafts;

import java.io.Console;
import java.util.ArrayList;

// Тестирование - процесс выполнения программы с целью нахождения ошибки
public class TestDemo {
    public static void main(String[] args) {
        manualTesting();
    }

    // Ручное тестирование - когда человек проводит действия над программой и сам проверяет
    static void manualTesting() {
        // Берёт входные данные
        int[] completedTasks = {5, 8, 10, 15, 13, 12, 8, 9, 7, 10, 15, 20, 18, 16, 13, 10};

        // Проводит действия
        int averageValue = getAverage(completedTasks);
        ArrayList<Integer> aboveAverage = getAboveAverage(completedTasks, averageValue);

        // И проверяет глазками в консоли
        printResult(averageValue, aboveAverage);

    }
    // Недостатков туча:
    // - Мамой клянусь, что проверял (человеческий фактор)
    // - Вы не обновили версию? Я опять тестировал старую версию? (каждый раз все заново)

    static void printResult(int averageValue, ArrayList<Integer> aboveAverage) {
        System.out.println("Среднее значение выполненных задач - " + averageValue);
        System.out.println("Номера итераций с количеством задач выше среднего");
        for ( Integer val : aboveAverage )
            System.out.println( val );
    }

    // Автотестирование - когда человек пишет код, который проверяет программу.
    static void autoTesting() {
        // Генерит входные значения
        int[] in = {5, 8, 10, 15, 13, 12, 8, 9, 7, 10, 15, 20, 18, 16, 13, 10};

        // Проводит действия в коде
        int averageValue = getAverage(in);
        ArrayList<Integer> out = getAboveAverage(in, averageValue);

        // И проверяет с помощью тестового кода свой боевой код
        boolean allPassed = runChecks(in, out, averageValue);
        if (allPassed)
            System.out.println("Все клево! :-)");
        else
            System.out.println("Эх, Беда! :-(");
    }
    // Недостаток?
    // - Так их же писать надо, а потом поддерживать
    // - Верно, а ты что хотел свой код оставить без тестов?
    // Или лень?

    // ? Что же проверяют ?
    // - Инварианты (здравый смысл)
    // - Требования (общая логика)
    static boolean runChecks(int[] in, ArrayList<Integer> out, int averageValue) {
        if ( out.size() > in.length )
            return false;

        for ( Integer val : out) {
            if (val < averageValue)
                return false;
        }

        return true;
    }

    // Функция - хороший кандидат для автотестирования:
    // Есть вход, есть выход. Все можно проверить явно.
    static ArrayList<Integer> getAboveAverage(int[] completedTasks, int averageValue) {
        ArrayList<Integer> retVal = new ArrayList<Integer>();
        for (int i = 0 ; i < completedTasks.length ; i++) {
            if (averageValue < completedTasks[i]) {
                retVal.add(completedTasks[i]);
            }
        }
        return retVal;
    }
    // С методом без параметров и возвращаемого значения - все сложнее.
    // Можно проверить по косвенным признакам.

    // Задание
    // 1. Как бы вы протестировали эту функцию?
    // 2. Найдите в ней ошибку
    static int getAverage(int[] completedTasks) {
        int averageValue = 0;
        for (int x : completedTasks) {
            averageValue += x;
        }
        return averageValue / completedTasks.length;
    }

}