import java.util.ArrayList;
import java.util.Scanner;

public class Array
{
    public static void main(String[] args)
    {
        ArrayList<Double> Numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Scanner act = new Scanner(System.in);
        String flag = "u";
        double result = 0;

        System.out.println(" Введите несколько чисел через Enter ");
        System.out.println(" Для окончания набора введите любую букву и нажмите Enter");

        for(;flag.equals("u");)
        {
            if (in.hasNextDouble())
                Numbers.add(in.nextDouble());
            else
                flag = "x";
        }

        System.out.println(" Введите действие ( + - * / %) ");
        String action = act.next() ;

        for ( int i = 0;i<Numbers.size();i++)
        {
            switch (action)
            {
                case "+":
                    result = result + Numbers.get(i);
                    break;
                case "-":
                    result = result - Numbers.get(i);
                    break;
                case "*":
                    result = result * Numbers.get(i);
                    break;
                case "/":
                    result = result / Numbers.get(i);
                    break;
                case "%":
                    result = result % Numbers.get(i);
                    break;
                default:
                    System.out.print("Не правильное действие");
            }
        }
        System.out.println(result);
    }

}
