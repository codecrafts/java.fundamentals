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
        System.out.println("Enter the number of elements to be inserted: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0;i < n; i++)
        {
            System.out.println("Enter an element: ");
            a[i] = sc.nextInt();
        }
        int max[]= new int[3];
        for(int i = 0; i < 3; i++)
        {
            max[i] = getMaxIndex(a);
        }
        System.out.print("Indices of the three highest integers are: ");
        for(int i = 0; i < 3; i++)
        {
            System.out.print(max[i]+" ");
        }
    }
    public static int getMaxIndex(int arr[])
    {
        int max = arr[0];
        int pos = 0;
        for(int i = 1;i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                pos = i;
            }
        }
        arr[pos] = -99999;
        return pos;


        /*double max1 = 0;
        double max2 = 0;
        double max3 = 0;
        double[] salesOnWeeks = {1256, 3297, 934, 1548, 6980.49, 1333, 4190, 479.89, 1005, 459, 1180, 1937, 4590, 244, 1390, 4599, 8790};

        for (int i = 0; i <= salesOnWeeks.length; i++){
            if (salesOnWeeks[i] < max1) {
                max1 = salesOnWeeks[i];
                max2 = max1 - 1;
                max3 = max2 - 1;
            }
        }
        System.out.println(max1 + ", " + max2 + ", "+ max3);*/

        /*int indexOfMax1 = 0;
        int indexOfMax2 = 0;
        int indexOfMax3 = 0;
        for (int i = 1; i < salesOnWeeks.length; i++) {
            if (salesOnWeeks[i] > salesOnWeeks[indexOfMax1]) indexOfMax1 = i;
        }
        for (int i = 1; i < salesOnWeeks.length - 1; i++) {
            if (salesOnWeeks[i] > salesOnWeeks[indexOfMax2]) indexOfMax2 = i;
        }
        for (int i = 1; i < salesOnWeeks.length - 2; i++) {
            if (salesOnWeeks[i] > salesOnWeeks[indexOfMax3]) indexOfMax3 = i;
        }
        System.out.print(indexOfMax1 + ", " + indexOfMax2 + ", " + indexOfMax3);*/
        /*double[] tempArray = salesOnWeeks.clone();
        Arrays.sort(tempArray);
        double max1 = tempArray[tempArray.length - 1];
        double max2 = tempArray[tempArray.length - 2];
        double max3 = tempArray[tempArray.length - 3];
        double result1 = Arrays.asList(salesOnWeeks).indexOf(max1);
        double result2 = Arrays.asList(salesOnWeeks).indexOf(max2);
        double result3 = Arrays.asList(salesOnWeeks).indexOf(max3);
        System.out.println(result1 + ", " + result2 + ", " + result3);*/
    }
}



