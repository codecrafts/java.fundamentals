// Калькулятор

import java.util.Scanner; //Импорт типа Scanner из пакета java.util;

public class Lesson3 {
    public static void main(String[] args){

        double operand1 = Double.NaN;   // Явно определяем переменную для первого операнда.
        double operand2 = Double.NaN;   // Явно определяем переменную для второго операнда.
        double result = Double.NaN;     // Явно определяем переменную для результата операции.
        String operator = "+";          // Явно определяем переменную для знака операции.

        Scanner input = new Scanner(System.in);  // Создаем объект класса Scanner.

        System.out.println("Введите первый операнд:");  // Запрос на ввод первого операнда.

        while(input.hasNext())      // Метод hasNext() останавливает выполнение программы
        {                           // и ожидает от пользователя ввода в консоль. В случае ввода input.hasNext() = true.
            if(input.hasNextDouble()) // Проверяем, является ли введенный текст элементом типа double.
            {
                operand1 = input.nextDouble();  // Если ввели double, то значению первого операнда присваиваем то,
                break;                          // что ввел пользователь.
            }
            else{                               // Если введен не double, то сообщаем о некорректном вводе и просим повторить.
                System.out.println("Введенное значение не является числом. Повторите ввод:");
                input.next();       // Очищаем значение в input и переходим к считыванию нового.
            }
        }

        System.out.println("Введите второй операнд:");

        while(input.hasNext())
        {
            if(input.hasNextDouble())
            {
                operand2 = input.nextDouble();
                break;
            }
            else{
                System.out.println("Введенное значение не является числом. Повторите ввод:");
                input.next();
            }
        }

        System.out.println("Введите знак операции:");

        while(input.hasNext())
        {
            operator = input.next().trim(); // Считываем знак операции. Делаем trim на случай лишних пробелов.
            if ( operator.equals("+")) {    // Проверяем, корректно ли введен знак.
                break;
            }
            if ( operator.equals("-")) {
                break;
            }
            if ( operator.equals("%")) {
                break;
            }
            if ( operator.equals("/")) {
                break;
            }
            if ( operator.equals("*")) {
                break;
            }
            else{
                System.out.println("Знак операции задан неверно. Повторите ввод:");
            }
        }

        switch (operator) {                     // Рассчитываем result в зависимости от введенного знака.
            case "+": {
                result = operand1 + operand2;
                break;
            }
            case "-": {
                result = operand1 - operand2;
                break;
            }
            case "/": {
                result = operand1 / operand2;
                break;
            }
            case "%": {
                result = operand1 % operand2;
                break;
            }
            case "*": {
                result = operand1 * operand2;
                break;
            }
            default: {                  // В случае некорректного ввода, отправляем пользователя на повторный ввод.
                System.out.println("Неверный знак операции. Повторите ввод:");
                input.next();
            }
        }

        System.out.println("Результат операции: " + operand1 + " " + operator + " " + operand2 + " = " + result);
        input.close(); // Закрываем поток ввода.
    }
}
