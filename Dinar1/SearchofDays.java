package ru.codecrafts;
import java.util.Arrays;
public class SearchofDays
{
    /*В целях оптимизации трафика для интернет-магазина нужно написать программу,
     которая находит три дня недели, по которым наибольшие продажи.

    Входные данные:
    Массив чисел (продажи в рублях). Идут по порядку по дням неделям. Данные за несколько недель.
    Выходные данные:
    Три дня недели с максимальными продажами.*/

    public static void main(String[] args)
    {
        double[] salesOnWeeks = {1256, 3297, 934, 1548, 6980.49, 1333, 4190, 479.89, 1005, 459, 1180, 1937, 4590, 244, 1390, 4599, 8790};
        Arrays.sort(salesOnWeeks);
        for (int i = salesOnWeeks.length - 3; i < salesOnWeeks.length; i++)
            System.out.println(salesOnWeeks[i]);
    }
}
