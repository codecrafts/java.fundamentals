import java.util.Scanner;

public class emailValidation {
    static final int maxUsername = 65;
    static final int maxDomen = 255;
    static int countDog = 0;
    public static void main(String[] args) {
        String email = enterEmail();
        findDog(email);
        if (countDog != 1) {
            System.out.println("Вы ввели не корректный адрес.");
            System.out.println("В адресе должен быть один символ @");
        }
         else   checkEmail(email);
    }

    static boolean checkEmail (String email){
            int userNameLength;
            int domenLength;
            boolean check = false;
            boolean nameСhecks = false;
            boolean domenChecks = false;
            userNameLength = findDog(email);
            char[] userName = new char[userNameLength];
            email.getChars(0, userNameLength, userName, 0);
            if(validationMaxWord(userName, maxUsername) && validationDoted(userName, maxUsername) && validationSimbol(userName, maxUsername)) {
                nameСhecks = true;
            }
            if (nameСhecks) System.out.println("Валидация имени пройдена");
            else System.out.println("Валидация имени не пройдена");
            System.out.println(nameСhecks);

            domenLength = email.length() - userNameLength - 1;
            char[] userDomen = new char[domenLength];
            email.getChars(userNameLength + 1, email.length(), userDomen, 0);
            if (validationMaxWord(userDomen, maxDomen) && validationDoted(userDomen, maxDomen) && validationSimbol(userDomen, maxDomen)) {
                domenChecks = true;
            }
            if (domenChecks) System.out.println("Валидация домена пройдена");
            else System.out.println("Валидация домена не пройдена");
            System.out.println(domenChecks);

            if (nameСhecks && domenChecks) check = true;
            return check ;
        }

    static String enterEmail () {
        String input;
        System.out.println("Введите почту");
        Scanner in = new Scanner(System.in);
        input = in.next();
        return input;
    }
    // Проверка наличия символа  @ и возвращение его позиции в строке
    static int findDog(String email) {
        int index = 0;
        int lengthemail = email.length();
        for (int i = 0; i < lengthemail; i++) {
            if (email.charAt(i) == '@') {
                countDog++;
                index = i;
            }
        }

        return index;
    }
    static boolean validationMaxWord(char[] text, int max) {
        boolean testMax = false;
        int countTest = 0;
        if (text.length <= max) {
            testMax = true;
        }
        return testMax;
    }
    static boolean validationDoted(char[] text, int max) {
        boolean testDoted = false;


        if (text[0] == '.' || text[text.length - 1] == '.') {
            System.out.println("точки не могут быть в начале или конце имени пользователя");
            return testDoted = false;
        } else {
            testDoted = true;
        }
        for (int i = 0; i < text.length - 1; i++) {
            if (text[i] == '.' && text[i + 1] == '.') {
                testDoted = false;
                System.out.println("стоящие рядом точки не допускаются");
                return testDoted = false;
            } else {
                testDoted = true;
            }
        }
        return testDoted;
    }
    static boolean validationSimbol(char[] text, int max) {
        boolean testWord = false;
        boolean allTest = false;
        int countTest = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z'|| text[i] >= 'A' && text[i] <= 'Z') countTest++;
            else switch (text[i]){
                case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':case '0':
                case '!':case '#':case '$':case '%':case '&':case '*':case '/':case '+':case '-':case '=':
                case '?':case '^':case '_':case '{':case '}':case '|':case '.':
                countTest++;
                    break;
                default: return testWord = false;
            }
        }
        if (countTest == text.length) testWord =true;
        return testWord;
    }
    static void testCode(){

        if (checkEmail("mkt@yandex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mkt.@yandex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mk..t@yandex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mkt@yan@dex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mkt@yan@dex.ru")) System.out.println("Ура тест пройден");
    }
}



