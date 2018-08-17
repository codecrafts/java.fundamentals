package lesson_6;
    /* Пользователь вводит строку.
    Программа определяет является ли данная строка валидным российским телефоном.
    (+76939985727 - является, +96939985727 - нет)
    */

import java.util.Scanner;

public class Lesson_6 {
    static final int amountTest = 9;                                    // количество тестов

    public static void main(String[] args) {

        boolean phoneCondition = false;                                 // состояние соответствия номера коду РФ

        String telephoneNumber = getTelephoneNumber();                  // получаем телефонный номер
        phoneCondition = isTruePhone (telephoneNumber);                 // проверка на валидность
        resultOutput(phoneCondition);                                               // вывод результата
        System.out.println (testCode() ? "тест пройден" : "тест не пройден");       // тесты
    }

    static String getTelephoneNumber() {                // ввод
        Scanner in = new Scanner (System.in);
        String phoneNumber;
        System.out.println ("Введите 12-и значный номер телефона в формате +12345678901:");
        phoneNumber = in.next ();
        return phoneNumber;
    }

    static void resultOutput(boolean conditionRF){      //вывод
        if (conditionRF)
            System.out.println ("Введенный номер телефона ЯВЛЯЕТСЯ ВАЛИДНЫМ российским телефоном");
        else
            System.out.println ("Введенный номер телефона НЕ ЯВЛЯЕТСЯ ВАЛИДНЫМ российским телефоном");
    }

    static boolean isTruePhone(String phoneNumber) {    // проверка на валидность и принадлежность номера РФ

        boolean isAllNumber = true;
        for(int numberPosition = 1; numberPosition < phoneNumber.length(); numberPosition++) {         // проверка на все ли цифры в номере
            if (phoneNumber.charAt (numberPosition) < '0' || phoneNumber.charAt (numberPosition) > '9')
                isAllNumber = false;
        }

        return phoneNumber.startsWith ( "+" ) && phoneNumber.startsWith ( "7", 1 ) && phoneNumber.length () == 12 && isAllNumber;
    }

    static boolean testCode(){      // тесты
        int testComplete = 0;      // переменная хранит состояние прохождения теста

        if( !isTruePhone ( "231234")) testComplete++;                   // заведомо не валидный тест
        if( !isTruePhone ( "+7123-123-12-34")) testComplete++;          // заведомо не валидный тест
        if( !isTruePhone ( "71231231234")) testComplete++;              // заведомо не валидный тест
        if( !isTruePhone ( "+31231231234")) testComplete++;             // заведомо не валидный тест
        if( !isTruePhone ( "+7123123O234")) testComplete++;             // заведомо не валидный тест
        if( !isTruePhone ( "+7231234")) testComplete++;                 // заведомо не валидный тест
        if( !isTruePhone ( "+7(904)231234")) testComplete++;            // заведомо не валидный тест
        if( !isTruePhone ( "+7(904)231-23-45")) testComplete++;         // заведомо не валидный тест
        if( isTruePhone ( "+71231234567")) testComplete++;              // валидный тест

        return testComplete == amountTest;              // возвращаем истину, если прошли все тесты успешно
    }
}
