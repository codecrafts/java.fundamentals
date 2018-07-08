import java.util.Scanner;

public class emailValidation {
    static final int maxUsername = 65;
    static final int maxDomen = 255;
    static int countDog = 0;
    public static void main(String[] args) {
        testCode();
        /*String email = enterEmail();
        findDog(email);
        if (countDog != 1) {
            System.out.println("Вы ввели не корректный адрес.");
            System.out.println("В адресе должен быть один символ @");
        }
         else   checkEmail(email);
*/
    }

    static boolean checkEmail (String email){
            int userNameLength;
            int domenLength;
            boolean check = false;
            boolean nameСhecks;
            boolean domenChecks;
            userNameLength = findDog(email);
            char[] userName = new char[userNameLength];
            email.getChars(0, userNameLength, userName, 0);
            nameСhecks = validation(userName, maxUsername);
            if (nameСhecks) System.out.println("Валидация имени пройдена");
            else System.out.println("Валидация имени не пройдена");
            System.out.println(nameСhecks);

            domenLength = email.length() - userNameLength - 1;
            char[] userDomen = new char[domenLength];
            email.getChars(userNameLength + 1, email.length(), userDomen, 0);
            domenChecks = validation(userDomen, maxDomen);
            if (domenChecks) System.out.println("Валидация домена пройдена");
            else System.out.println("Валидация домена не пройдена");
            System.out.println(domenChecks);

            if (nameСhecks && domenChecks) check = true;
            return check ;
        }

    static String enterEmail (){
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
    static boolean validation(char[] text, int max) {
        boolean testDoted = false;
        boolean testDubleDoted = false;
        boolean testWord = false;
        boolean allTest = false;
        boolean testMax = false;
        int countTest = 0;
        if (text.length <= max) {
            testMax = true;
        }
        if (text[0] == '.' || text[text.length-1] == '.') {
            System.out.println("точки не могут быть в начале или конце имени пользователя");
            return allTest = false;
        } else {
            testDoted = true;
        }
        for (int i = 0; i < text.length - 1; i++) {
            if (text[i] == '.' && text[i + 1] == '.') {
                testDubleDoted = false;
                System.out.println("стоящие рядом точки не допускаются");
                return allTest = false;
            } else {
                testDubleDoted = true;
            }
        }
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z'|| text[i] >= 'A' && text[i] <= 'Z') {
                countTest++;
            } else if (text[i] >= '0' && text[i] <= '9'|| text[i] >= '0' && text[i] <= '9') {
                countTest++;
            } else if (text[i] == '!' || text[i] == '#' || text[i] == '$' || text[i] == '%' || text[i] == '&' || text[i] == '*' ) {
                countTest++;
            } else if (text[i] == '+' || text[i] == '-' || text[i] == '/' || text[i] == '=' || text[i] == '?' || text[i] == '^' ) {
                countTest++;
            } else if (text[i] == '_' || text[i] == '{' || text[i] == '}' || text[i] == '|' || text[i] == '?' || text[i] == '.' ) {
                countTest++;
            } else return allTest = false;
        }
        if (countTest == text.length) testWord =true;
        if (testDoted && testDubleDoted && testWord && testMax) allTest = true;
        return allTest;
    }
    static void testCode (){

        if (checkEmail("mkt@yandex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mkt.@yandex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mk..t@yandex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mkt@yan@dex.ru")) System.out.println("Ура тест пройден");
        if (!checkEmail("mkt@yan@dex.ru")) System.out.println("Ура тест пройден");
    }
}



