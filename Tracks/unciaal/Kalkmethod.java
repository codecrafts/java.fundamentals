import java.util.Scanner;

public class Kalkmethod {
    static double number1;
    static double number2;
    static String arithmeticOperation;
    static Double result;
    public static void main(String[] args) {
        inputData();
        result();
        System.out.print(" " + number1 + " " + arithmeticOperation + " " + number2 + " = " + result );

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
    static void result (){
        switch (arithmeticOperation){
            case "+":
            result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "%":
                result = number1 % number2;
                break;
            default:
                System.out.println("Не верное арифметическое действие");
        }
    }

}
