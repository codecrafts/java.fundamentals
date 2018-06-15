package ru.codecrafts;
import java.util.ArrayList;
import java.util.Scanner;
public class Rechner
{
    public static void main(String[] args)
    {
            ArrayList<Integer> digits = new ArrayList<>();
            Scanner big = new Scanner(System.in);
            String button = "yes";
            int result;

            System.out.println("Please enter so much numbers as you wish. You have only 5 operations to choose: +, /, *, ^, &  ");

            for(;button.equals("yes");)
            {
                if (big.hasNextInt())
                    digits.add(big.nextInt());
                else
                    button = "no";
            }

            String operation = big.next() ;
            result = digits.get(0);
            //for
            for ( int i = 1;i<digits.size();i++)
            {
                switch (operation)
                    {
                        case "+":
                            result = result + digits.get(i);
                            break;
                        case "/":
                            result = result / digits.get(i);
                            break;
                        case "*":
                            result = result * digits.get(i);
                            break;
                        case "^":
                            result = result ^ digits.get(i);
                            break;
                        case "&":
                            result = result & digits.get(i);
                            break;
                        default:
                            System.out.print("You have made wrong action.");
                    }
            }
        System.out.println(result);
    }
}




