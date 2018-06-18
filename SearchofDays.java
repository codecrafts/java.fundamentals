package ru.codecrafts;
import java.util.*;
public class SearchofDays {
    /*В целях оптимизации трафика для интернет-магазина нужно написать программу,
     которая находит три дня недели, по которым наибольшие продажи.

    Входные данные:
    Массив чисел (продажи в рублях). Идут по порядку по дням неделям. Данные за несколько недель.
    Выходные данные:
    Три дня недели с максимальными продажами.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How much days do we have? ");
        int number = sc.nextInt();
        int days[] = new int[number];
        for(int i = 0;i < number; i++) {
            System.out.println("How many sales did we make per each day? ");
            days[i] = sc.nextInt();
        }
        int max[]= new int[3];
        for(int i = 0; i < 3; i++) {
            max[i] = getMaxIndex(days);
        }
        System.out.print("Indices of the 3 largest sales are: ");
        for(int i = 0; i < 3; i++) {
            System.out.print(max[i]+" ");
        }
    }
    public static int getMaxIndex(int arr[])
    {
        int max = arr[0];
        int pos = 0;
        for(int i = 1;i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                pos = i;
            }
        }
        arr[pos] = -99999;
        return pos;
    }
}
