package lesson_6;
    /* Пользователь вводит строку.
    Программа определяет является ли данная строка валидным российским телефоном.
    (+76939985727 - является, +96939985727 - нет)

     Коды ошибок:
    10 - в номере первый символ не "+"
    20 - в номере не 12 знаков
    30 - в номере присутствуют не только цифры
    7 - номер телефона  с кодом РФ
    8 - номер телефона  с кодом не РФ     */

import java.util.Scanner;

public class lesson_6 {

    public static void main(String[] args) {
        int errorCode = 0;                                              // код ошибки
        String telephoneNumber = getTelephoneNumber();                  // получаем телефонный номер
        errorCode = isTruePhone (telephoneNumber);                      // проверка на валидность
        resultOutput(errorCode);                                        // вывод результата
        System.out.println (testCode() ? "тест пройден" : "тест не пройден");       // тесты
    }

    // ввод
    static String getTelephoneNumber() {
        Scanner in = new Scanner (System.in);
        String phoneNumber;
        System.out.println ("Введите 12-и значный номер телефона в формате +12345678901:");
        phoneNumber = in.next ();
        return phoneNumber;
    }

    //вывод
    static void resultOutput(int error){
        switch (error) {
            case 10:
                System.out.println ("Введенный номер телефона не содержит +");
                break;
            case 20:
                System.out.println ("Введенный номер телефона неверной длины");
                break;
            case 30:
                System.out.println ("Введенный номер телефона содержит левые символы");
                break;
            case 7:
                System.out.println ("Введенный номер телефона является валидным российским телефоном");
                break;
            case 8:
                System.out.println ("Введенный номер телефона является валидным не российским телефоном");
                break;
        }
    }

    // проверка на валидность и принадлежность номера РФ
    static int isTruePhone(String phoneNumber) {

        if (!phoneNumber.startsWith("+")) return 10;         // провека - первый не плюс

        if (phoneNumber.length() != 12) return 20;           // проверка на 12 знаков

        for(int numberPosition = 1; numberPosition<phoneNumber.length(); numberPosition++) {         // проверка на цифры в номере
            if (phoneNumber.charAt (numberPosition) < '0' || phoneNumber.charAt (numberPosition) > '9')
                return 30;
        }
        return phoneNumber.startsWith ("7", 1) ? 7 : 8;
    }

    // тест
    static boolean testCode(){
        int testPass = 0;               // счетчик проходжения тестов
        
        if (isTruePhone("231234") >= 10) testPass++;
        if (isTruePhone("+7123-123-12-34") >= 10) testPass++;
        if (isTruePhone("71231231234") >= 10) testPass++;
        if (isTruePhone("+31231231234") < 10) testPass++;
        if (isTruePhone("+7123123O234") >= 10) testPass++;
        if (isTruePhone("+7231234") >= 10) testPass++;
        if (isTruePhone("+7(904)231234") >= 10) testPass++;
        if (isTruePhone("+7(904)231-23-45") >= 10) testPass++;
        if (isTruePhone("+71231234567") < 10) testPass++;

        return testPass == 9 ? true : false;
    }
}
