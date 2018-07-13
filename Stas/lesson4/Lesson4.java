/*
Задача:
В целях повышения эффективности работы команды для менеджера надо написать программу,
которая выводит номера недельных итераций, когда было выполнено задач ниже среднего.

Входные данные:
Массив чисел (количество закрытых задач). Идут по порядку по итерациям.

Выходные данные.
Номера итераций, когда была производительность в задачах была ниже среднего значения.
*/

import java.util.ArrayList;
import java.util.Scanner; //Импорт типа Scanner из пакета java.util;

public class Lesson4 {
    public static void main(String[] args){
        int lengthOfPeriod = 0;      // Переменная для длины массива недель.
        double summ = 0;            // Переменная для рассчета суммы выполненых заданий.
        double average;         // Переменная для поиска среднего значения выполненных заданий.

        Scanner input = new Scanner(System.in);
        System.out.println("Введите кличество недель для рассчета:");

        while ( input.hasNext() ){
            if ( input.hasNextInt() ){ // В случае ввода input.hasNext() = true. Проверяем, является ли введенный текст элементом типа double.
                lengthOfPeriod = input.nextInt();  // Если ввели double, то значению первого операнда присваиваем то, что ввел пользователь.
                if ( lengthOfPeriod > 0 )  // Делаем проверку, что введено положительное кол-во недель.
                    break;
                else{
                    System.out.println("Введенное значение меньше 1. Повторите ввод:");
                }
            }else{                               // Если введен не double, то сообщаем о некорректном вводе и просим повторить.
                System.out.println("Введенное значение не является числом. Повторите ввод:");
                input.next();       // Очищаем значение в input и переходим к считыванию нового.
            }
        }

        Double[] allWeeks = new Double[lengthOfPeriod];  // Инициализируем массив для недельных оценок.

        for ( int i  = 0; i < lengthOfPeriod; i++ ){     // Цикл для заполенения массива значениями.
            int k = i + 1;
            System.out.println("Введите количество выполненных задач на " + k + " неделе:");
            while ( input.hasNext() ){
                if ( input.hasNextInt() ){
                    allWeeks[i] = input.nextDouble();
                    break;
                }else{
                    System.out.println("Введенное значение не является числом. Повторите ввод:");
                    input.next();
                }
            }
        }

        System.out.println("Статистика выполненных работ:");

        for ( int i  = 0; i < lengthOfPeriod; i++ ){    // Вывод статистики выполненных задач по неделям.
            int k = i + 1;
            System.out.println("На " + Integer.toString(k) + "ой неделе было выполенено " + Double.toString(allWeeks[i]) + " задач.");
        }

        for ( int i = 0; i < lengthOfPeriod; i++ ){     // Суммирование значений массива недель.
            summ += allWeeks[i];
        }

        average = summ / lengthOfPeriod;        // Рассчет среднего значения выполненных задач.
        System.out.printf("Среднее количество выполненных задач в неделю за период равно: %.2f", average);
        System.out.println();
        ArrayList<Integer> badWeeks = new ArrayList<Integer>(); // Создаем массив для индексов недель с низкой производительность.

        for ( int i = 0; i < lengthOfPeriod; i++ ){
            if ( allWeeks[i] < average ) badWeeks.add(i+1);  // Заполняем массив индексами "плохих" недель.
        }

        for ( int week : badWeeks ){     // Вывод статистики "плохих" недель.
            System.out.println("Низкая производительность на неделе номер: " + week);
        }
        input.close();  // Закрываем поток ввода.
    }
}
