import java.util.Scanner;

public class Kalknew {

        static double number1;
        static double number2;
        static String arithmeticOperation;
        public static void main(String[] args) {
            double res;
            inputData();
            res = result(number1, number2, arithmeticOperation);
            System.out.print(" " + number1 + " " + arithmeticOperation + " " + number2 + " = " + res );
        }
        static void inputData () {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите первое число");
            number1 = in.nextDouble();
            System.out.println("Введите второе число");
            number2 = in.nextDouble();
            System.out.println("Какое действие надо произвести над числами?");
            arithmeticOperation = in.next();
        }
        static double result (double num1, double num2, String oper){
            double result = 0;
            switch (oper){

                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                default:
                    System.out.println("Не верное арифметическое действие");
            }

            return result;

        }

    }


