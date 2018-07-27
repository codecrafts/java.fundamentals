import java.util.Scanner;

public class emailValidation {
    static final int maxUsername = 65;
    static final int maxDomen = 255;
    public static void main(String[] args) {
        boolean  checkEmail;
        String email = enterEmail();
        if (findDog(email)) {
            checkEmail = checkEmail(email);
            printResult(checkEmail);
        } else  printResult(false);
    }
    static boolean checkEmail (String email) {
            int userNameLength;
            int domenLength;
            boolean check = false;
            boolean nameСhecks = false;
            boolean domenChecks = false;
            userNameLength = findeIndexDog(email);
            char[] userName = new char[userNameLength];
            email.getChars(0, userNameLength, userName, 0);
            if(validationMaxWord(userName, maxUsername) && validationDoted(userName) && validationSimbol(userName)) {
                nameСhecks = true;
            } else return false;
            domenLength = email.length() - userNameLength - 1;
            char[] userDomen = new char[domenLength];
            email.getChars(userNameLength + 1, email.length(), userDomen, 0);
            if (validationMaxWord(userDomen, maxDomen) && validationDoted(userDomen) && validationSimbol(userDomen)) {
                domenChecks = true;
            } else return false;
            if (nameСhecks && domenChecks) check = true;
            return check ;
        }
    static void printResult (boolean checkEmail){
        if (checkEmail) System.out.println("Валидация Email пройдена.");
        else System.out.println("Валидация Email не пройдена.");
    }

    static String enterEmail () {
        String input;
        System.out.println("Введите почту");
        Scanner in = new Scanner(System.in);
        input = in.next();
        return input;
    }
    static boolean findDog(String email) {
        int index = 0;
        int lengthemail = email.length();
        for (int i = 0; i < lengthemail; i++) {
            if (email.charAt(i) == '@') {
                index++;
            }
        }
        if (index != 1) return false;
        return true;
    }
    static int findeIndexDog(String email) {
        int index = 0;
        int lengthemail = email.length();
        for (int i = 0; i < lengthemail; i++) {
            if (email.charAt(i) == '@') {
                index = i;
            }
        }
        return index;
    }
    static boolean validationMaxWord(char[] text, int max) {
        boolean testMax = false;
        if (text.length <= max) {
            testMax = true;
        }
        return testMax;
    }
    static boolean validationDoted(char[] text) {
        boolean testDoted = false;
        if (text[0] == '.' || text[text.length - 1] == '.') {
            return false;
        } else {
            testDoted = true;
        }
        for (int i = 0; i < text.length - 1; i++) {
            if (text[i] == '.' && text[i + 1] == '.') {
                return false;
            } else {
                testDoted = true;
            }
        }
        return testDoted;
    }
    static boolean validationSimbol(char[] text) {
        boolean testWord = false;
        int countTest = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z'|| text[i] >= 'A' && text[i] <= 'Z') countTest++;
            else {
                switch (text[i]) {
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case '0':
                    case '!':
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '*':
                    case '/':
                    case '+':
                    case '-':
                    case '=':
                    case '?':
                    case '^':
                    case '_':
                    case '{':
                    case '}':
                    case '|':
                    case '.':
                        countTest++;
                        break;
                    default:
                        return false;
                }
            }
        }
        if (countTest == text.length) testWord =true;
        return testWord;
    }
    static boolean testCode() {
        int testcount = 0;
        if (checkEmail("mkt@yandex.ru")) {
            System.out.println("Ура тест пройден");
            testcount++;
        }
        if (!checkEmail("mkt.@yandex.ru")) {
            System.out.println("Ура тест пройден");
            testcount++;
        }
        if (!checkEmail("mk..t@yandex.ru")) {
            System.out.println("Ура тест пройден");
            testcount++;
        }
        if (!checkEmail("mkt@yan@dex.ru")) {
            System.out.println("Ура тест пройден");
            testcount++;
        }
        if (!checkEmail("mkt@yan@dex.ru")) {
            System.out.println("Ура тест пройден");
            testcount++;
        }
        if (testcount == 5)return true;
        else return false;
    }


}



