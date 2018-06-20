import java.util.Scanner;

public class Kalknew {

        public static void main(String[] args) {
            double res;
            double number1 = inputNumber("Введите первое число");
            double number2 = inputNumber("Введите второе число");
            String arithmeticOperation = operation("Какое действие надо произвести над числами?");
            res = result(number1, number2, arithmeticOperation);
            System.out.print(" " + number1 + " " + arithmeticOperation + " " + number2 + " = " + res );
        }
        static double inputNumber (String text){
            double number;
            Scanner in = new Scanner(System.in);
            System.out.println(text);
            number = in.nextDouble();
            return number;
        }
        static String operation (String text){
            String operation;
            Scanner in = new Scanner(System.in);
            operation = in.next();
            return operation;
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


