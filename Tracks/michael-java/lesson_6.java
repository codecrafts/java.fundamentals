package Lesson_6;
    /* Пользователь вводит строку.
    Программа определяет является ли данная строка валидным российским телефоном.
    (+76939985727 - является, +96939985727 - нет)
    */

import java.util.Scanner;

public class lesson_6 {

    public static void main(String[] args) {
        
        final int lengthPhoneNumber = 12;                               // количество символов в номере телефона
        boolean phoneCondition = false;                                 // соответствие номера коду РФ

        String telephoneNumber = getTelephoneNumber();                  // получаем телефонный номер
        phoneCondition = isTruePhone (telephoneNumber);                 // проверка на валидность
        resultOutput(phoneCondition);                                        // вывод результата
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
    static void resultOutput(boolean conditionRF){
        if (conditionRF)
            System.out.println ("Введенный номер телефона ЯВЛЯЕТСЯ ВАЛИДНЫМ российским телефоном");
        else
            System.out.println ("Введенный номер телефона НЕ ЯВЛЯЕТСЯ ВАЛИДНЫМ российским телефоном");
    }

    // проверка на валидность и принадлежность номера РФ
    static boolean isTruePhone(String phoneNumber) {

        if (!phoneNumber.startsWith("+")) return false;         // провека - первый не плюс

        if (phoneNumber.length() != lengthPhoneNumber) return false;           // проверка на 12 знаков

        for(int numberPosition = 1; numberPosition<phoneNumber.length(); numberPosition++) {         // проверка на цифры в номере
            if (phoneNumber.charAt (numberPosition) < '0' || phoneNumber.charAt (numberPosition) > '9')
                return false;;
        }
        return phoneNumber.startsWith ("7", 1) ? true : false;
    }

    // тест
    static boolean testCode(){
        boolean testCondition = false;      // переменная хранит состояние прохождения теста

        testCondition = isTruePhone("231234") ? false : true;
        testCondition = isTruePhone("+7123-123-12-34") ? false : true;
        testCondition = isTruePhone("71231231234") ? false : true;
        testCondition = isTruePhone("+31231231234") ? false : true;
        testCondition = isTruePhone("+7123123O234") ? false : true;
        testCondition = isTruePhone("+7231234") ? false : true;
        testCondition = isTruePhone("+7(904)231234") ? false : true;
        testCondition = isTruePhone("+7(904)231-23-45") ? false : true;
        testCondition = isTruePhone("+71231234567") ? true : false;

        return testCondition;
    }
}
