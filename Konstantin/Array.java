import java.util.ArrayList;
import java.util.Scanner;

public class Array
{
    public static void main(String[] args)
    {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String flag = "u";
        double result = 0;

        System.out.println(" Введите несколько чисел через Enter ");
        System.out.println(" Для окончания набора введите действие выполняемое над числами");

        for(;flag.equals("u");)
        {
            if (in.hasNextDouble())
                numbers.add(in.nextDouble());
            else
                flag = "x";
        }


        String action = in.next() ;
        if (numbers.size()>0);
        result = numbers.get(0);

        for ( int i = 1;i<numbers.size();i++)
        {
                switch (action)
                {
                    case "+":
                        result = result + numbers.get(i);
                        break;
                    case "-":
                        result = result - numbers.get(i);
                        break;
                    case "*":
                        result = result * numbers.get(i);
                        break;
                    case "/":
                        result = result / numbers.get(i);
                        break;
                    case "%":
                        result = result % numbers.get(i);
                        break;
                    default:
                        System.out.print("Неправильное действие");
                }
        }
        System.out.println(result);
    }

}
