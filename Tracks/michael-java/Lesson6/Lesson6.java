package searchSubstring;

    /*  ≈сть две строки.
        —трока - предложение на русском €зыке и строка с разделител€ми.
        Ќужно подсчитать количество слов использу€ разделители.
     */
public class Lesson6 {

    static String words = "ќднажды, в студеную зимнюю пору...";
    static String separators = "., !-:+";

    public static void main(String[] args) {

        int countWords = 0;

        countWords = countWords(words, separators);
        printResult(countWords);

        System.out.println(testCode() ? "тест пройден" : "тест не пройден");
    }

    static int countWords(String testWords, String testSeparators) {

        boolean isWasLetter = false;   // состо€ние - буква или нет
        int counterWords = 0;          // счетчик слов

        for (int index = 0; index < testWords.length(); index++) {       // перебор элементов тестируемой строки на буква/не буква

            if (isLetter(index, testWords, testSeparators)) {            // элемент строки - буква
                isWasLetter = true;                                      // мен€ем состо€ние на "буква"
            } else {                                                     // элемент строки - не буква
                if (isWasLetter)                                         // сечас не буква, а перед ней - буква, плюсуем слово
                    counterWords++;
                isWasLetter = false;                                     // мен€ем состо€ние на "не буква"
            }
        }
        if(isWasLetter)                                                  // в строке - последн€€ буква
            counterWords++;
        return counterWords;
    }

    static boolean isLetter(int index, String whatTest, String withTest) {      // проверка вхождени€ подстроки в строку

        char letter = whatTest.charAt(index);
        boolean isLetter = true;                                                // состо€ние элемента тестируемой строки: буква/не буква

        for (int j = 0; j < withTest.length(); j++) {                // проверка элемента тестируемой строки
            if (letter == withTest.charAt(j)) {                       // поймали разделитель
                isLetter = false;
                break;
            }
        }
        return isLetter;
    }

    public static void printResult(int result) {

        System.out.println ("¬ строке: " + "\"" + words + "\" " + result + " слов");
    }

    public static boolean testCode () {

        int counter = 0;
        Boolean testPassed = false;

        if (countWords("ћамамылараму", " !") == 1)
            counter++;
        if (countWords( "       ћамамылараму", " !") == 1)
            counter++;
        if (countWords("кто-нибудь - это не кто-то", " -") == 6)
            counter++;
        if (countWords("ћамамылараму     ", " ,") == 1)
            counter++;
        if (countWords(" ћама мыла раму ", " ") == 3)
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