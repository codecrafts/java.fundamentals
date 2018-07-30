// Операции со строчками

// Первоисточники
/*
https://docs.oracle.com/javase/10/docs/api/java/lang/String.html
https://docs.oracle.com/javase/10/docs/api/java/lang/StringBuilder.html
https://docs.oracle.com/javase/10/docs/api/java/lang/StringBuffer.html
https://developer.android.com/reference/java/lang/String
https://developer.android.com/reference/java/lang/StringBuilder
https://developer.android.com/reference/java/lang/StringBuffer
*/

// Типовые практические задачи
/*
 1. Валидация. Строка имеет опеределенный вид. Например проверить, что введен телефон.
 2. Парсинг. Вычленение частей из строки. Например вычленить из телефон код страны
 3. Преобразование. Из одного формата строчку преобразовать в другую
 4. Форматирование. Собрать строчку из нескольких компонент.
*/

// Подходы к решению задач
/*
  1. Свести к операциям над массивов символов.
  2. Использовать встроенные методы классов String.
  3. Для операций форматирования и модификации использовать StringBuilder или StringBuffer.
  4. Регулярные выражения. Специальный язык для модификации строк.
*/

package ru.codecrafts;
public class StringDemo {

    public static void main(String[] args) {
        validateString();
        parseString();
        replaceString();
        formatString();
    }

    // Проверяем, что строка имеет опеределенный вид.
    static void validateString() {
        // Можно проверить префикс, постфикс или просто слово
        String tag = "<html>";
        if (tag.contains("html") && tag.startsWith("<") && tag.endsWith(">"))
            System.out.println("OK!");


    }

    static void parseString() {
        String str = "Talk is cheap. Show me the code.";
        // Можно разбить строку на слова
        String[] words = str.split(" ");

        // Задача подсчитать количество символов
        int spaceCount = 0;
        for ( int i = 0; i < str.length(); i++ ) {
            char ch = str.charAt(i);
            if (ch == ' ')
                spaceCount++;
        }
        System.out.println("Количество пробелов: " + spaceCount);
    }

    static void replaceString() {
        String str = "Talk is cheap. Show me the code.";
        // Если нужно модифицировать, то нужно явно преобразовать в массив символов
        char[] charArray = str.toCharArray();
        for ( int i = 0; i < charArray.length; i++) {
            // Сделать с ним действия
            if (charArray[i] == '.')
                charArray[i] = '!';
        }
        // И снова преобразовать в строку
        String newStr = new String(charArray);
        System.out.println(newStr);

        // Популярные действия со строками
        String strWithoutSpaces = str.trim();
        String otherStr = strWithoutSpaces.replace('.', '!');
        System.out.println(otherStr);
    }

    static void formatString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("Talk");
        strBuild.append(" is ");
        strBuild.append(" cheap!");
        String str = strBuild.toString();
        System.out.println(str);
    }

}
