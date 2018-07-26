/*
Задача:
Пользователь вводит строку. Программа определяет является ли данная строка потенциально валидным IPv4 адресом.
(255.255.255.255 - является, а 255.255.255.257 - нет)
*/
import java.util.Scanner;

public class Lesson6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите IPv4 адрес :");
        String ip = input.next();

        if (isIP(ip))
            System.out.println("Введен корректный IPv4 адрес: " + ip);
        else
            System.out.println("Введен некорректный IPv4 адрес.");

        System.out.println (testCode() ? "Тест пройден." : "Тест не пройден.");
        input.close();
    }

    static boolean isIP(String input) {
        boolean isIp = true;
        StringBuilder tempNum = new StringBuilder();
        int dotCounter = 0;
        int intParse;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)))
                tempNum.append(input.charAt(i));
            else if ((input.charAt(i) == '.') && !(tempNum.length() == 0) && (tempNum.length() <= 3)) {
                intParse = Integer.parseInt(tempNum.toString());
                if ((intParse >= 0) && (intParse <= 255)) {
                    tempNum.setLength(0);
                    dotCounter++;
                }else {
                    isIp = false;
                    break;
                }
            }else {
                isIp = false;
                break;
            }
        }

        if (dotCounter != 3)
            isIp = false;

        return isIp;
    }

    static boolean testCode() {
        boolean testPassed = false;
        int passCounter = 0;

        if (!isIP("asda.asd.asd.asd"))
            passCounter++;
        if (!isIP("123...123123"))
            passCounter++;
        if (!isIP("...123"))
            passCounter++;
        if (!isIP("0...1"))
            passCounter++;
        if (!isIP("123. 123.123.123"))
            passCounter++;
        if (!isIP("123.123.123.123."))
            passCounter++;
        if (!isIP(".123.123.123.123"))
            passCounter++;
        if (!isIP("123.222.-1.123"))
            passCounter++;
        if (!isIP("777.123.1.1"))
            passCounter++;
        if (isIP("123.123.123.123"))
            passCounter++;

        if (passCounter == 10)
            testPassed = true;

        return testPassed;

    }
}