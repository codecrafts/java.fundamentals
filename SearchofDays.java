package ru.codecrafts;
import java.util.*;
import java.util.concurrent.Callable;

public class SearchofDays {
    /*В целях оптимизации трафика для интернет-магазина нужно написать программу,
     которая находит три дня недели, по которым наибольшие продажи.

    Входные данные:
    Массив чисел (продажи в рублях). Идут по порядку по дням неделям. Данные за несколько недель.
    Выходные данные:
    Три дня недели с максимальными продажами.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many days do we have? ");
        int number = sc.nextInt();
        int sales[] = new int[number];

        for(int i = 0; i < sales.length; i++) {
            System.out.println("How many sales did we make per each day? ");
            sales[i] = sc.nextInt();
        }
        int days[] = new int[7];
        int indexDay = 0;

        for (int i = 0; i < sales.length; i++) {

            days[indexDay] = days[indexDay] + sales[i];
            indexDay++;
            if (indexDay > 6) indexDay = 0;
        }
        for(int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
        }

        int max[]= new int[3];
        for(int i = 0; i < 3; i++) {
            max[i] = getMaxIndex(days);
        }
        System.out.print("Indices of the 3 largest sales are: ");
        for(int i = 0; i < 3; i++) {
            switch (max[i]){
                case 0:
                    System.out.print("Monday "); break;
                case 1:
                    System.out.print("Tuesday "); break;
                case 2:
                    System.out.print("Wednesday "); break;
                case 3:
                    System.out.print("Thursday "); break;
                case 4:
                    System.out.print("Friday "); break;
                case 5:
                    System.out.print("Saturday "); break;
                case 6:
                    System.out.print("Sunday "); break;
            }
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
