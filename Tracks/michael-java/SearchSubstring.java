package searchSubstring;
    /*
        Есть две строки.
        Строка - предложение на русском языке и строка с разделителями.
        Нужно подсчитать количество слов используя разделители.
     */

public class SearchSubstring {

    static String words = "... мама -папа, (дед+баба) ели к_а_ш_у!";
    static String separators = "., !-:+";

    public static void main(String[] args) {

        int countWords = 0;

        countWords = countWords(words, separators);
        printResult(countWords);

        System.out.println(testCode() ? "тест пройден" : "тест не пройден");
    }

    static int countWords(String testWords, String testSeparators) {

        boolean isWasLetter = false;   // состояние - буква или нет
        int counterWords = 0;          // счетчик слов

        for (int index = 0; index < testWords.length(); index++) {       // перебор элементов тестируемой строки на буква/не буква

            if (isLetter(index, testWords, testSeparators)) {            // элемент строки - буква
                isWasLetter = true;                                      // меняем состояние на "буква"
                if(index == testWords.length() - 1)                      // в строке - последняя буква
                    counterWords++;
            } else {                                                     // элемент строки - не буква
                if (isWasLetter)                                         // сечас не буква, а перед ней - буква, плюсуем слово
                    counterWords++;
                isWasLetter = false;                                     // меняем состояние на "не буква"
            }
        }
        return counterWords;
    }

    static boolean isLetter(int index, String whatTest, String withTest) {      // проверка вхождения подстроки в строку

        char letter = whatTest.charAt(index);
        boolean isLetter = true;                                                // состояние элемента тестируемой строки: буква/не буква

        for (int j = 0; j < withTest.length(); j++) {                // проверка элемента тестируемой строки
            if (letter == withTest.charAt(j)) {                       // поймали разделитель
                isLetter = false;
                break;
            }
        }
        return isLetter;
    }

    public static void printResult(int result) {

        System.out.println ("В строке: " + "\"" + words + "\" " + result + " слов");
    }

    public static boolean testCode () {

        int counter = 0;
        Boolean testPassed = false;

        if (countWords("Мамамылараму", " !") == 1)
            counter++;
        if (countWords( "       Мамамылараму", " !") == 1)
            counter++;
        if (countWords("кто-нибудь - это не кто-то", " -") == 6)
            counter++;
        if (countWords("Мамамылараму     ", " ,") == 1)
            counter++;
        if (countWords(" Мама мыла раму ", " ") == 3)
            counter++;
        if (countWords(" ", " !.") == 0)
            counter++;
        if (countWords("", " ") == 0)
            counter++;

        if (counter == 7)
            testPassed = true;
        return testPassed;
    }

}
