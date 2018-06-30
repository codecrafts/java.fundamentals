import java.util.Scanner;

public class emailValidation {
    public static void main(String[] args) {
        int userNameLength;
        int domenLength;
        int maxUsername = 65;
        int maxDomen = 255;
        boolean nameСhecks;
        boolean domenChecks;
        String email = writeEmail("Введите почту");
        userNameLength = indexDog(email);
        char[] userName = new char[userNameLength];
        email.getChars(0, userNameLength, userName, 0);
        nameСhecks = test(userName, maxUsername);
        if(nameСhecks) System.out.println("Валидация имени пройдена");
        else System.out.println("Валидация имени не пройдена");
        System.out.println(nameСhecks);

        domenLength = email.length() - userNameLength - 1;
        char[] userDomen = new char[domenLength];
        email.getChars(userNameLength + 1, email.length(), userDomen, 0);
        domenChecks = test(userDomen, maxDomen);
        if(domenChecks) System.out.println("Валидация домена пройдена");
        else System.out.println("Валидация домена не пройдена");
        System.out.println(domenChecks);
    }
    static String writeEmail(String message) {
        String input;
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        input = in.next();
        return input;
    }
    // Проверка наличия символа  @ и возвращение его позиции в строке
    static int indexDog(String email) {
        int index = 0;
        int count = 0;
        int lengthemail = email.length();
        for (int i = 0; i < lengthemail; i++) {
            if (email.charAt(i) == '@') {
                count++;
                index = i;
            }
        }
        if (count != 1) {
            System.out.println("Вы ввели не корректный адрес.");
            System.out.println("В адресе должен быть один символ @");
        }
        return index;
    }
    static boolean test(char[] text, int max) {
        boolean testDoted = false;
        boolean testDubleDoted = false;
        boolean testWord = false;
        boolean allTest = false;
        boolean testMax = false;
        int countTest = 0;
        if (text.length <= max) {
            testMax = true;
        }
        if (text[0] != '.' || text[text.length] != '.') {
            testDoted = true;
        } else {
            System.out.println("точки не могут быть в начале или конце имени пользователя");
        }
        for (int i = 0; i < text.length - 1; i++) {
            if (text[i] == '.' && text[i + 1] == '.') {
                testDubleDoted = false;
                System.out.println("стоящие рядом точки не допускаются");
                break;
            } else {
                testDubleDoted = true;
            }
        }
        for (int i = 0; i < text.length; i++) {
            if (text[i] >= 'a' && text[i] <= 'z'|| text[i] >= 'A' && text[i] <= 'Z') {
                countTest++;
            }
            if (text[i] >= '0' && text[i] <= '9'|| text[i] >= '0' && text[i] <= '9') {
                countTest++;
            }
            if (text[i] == '!' || text[i] == '#' || text[i] == '$' || text[i] == '%' || text[i] == '&' || text[i] == '*' ) {
                countTest++;
            }
            if (text[i] == '+' || text[i] == '-' || text[i] == '/' || text[i] == '=' || text[i] == '?' || text[i] == '^' ) {
                countTest++;
            }
            if (text[i] == '_' || text[i] == '{' || text[i] == '}' || text[i] == '|' || text[i] == '?' || text[i] == '.' ) {
                countTest++;
            }
        }
        if (countTest == text.length) testWord =true;
        if (testDoted && testDubleDoted && testWord && testMax) allTest = true;
    return allTest;
    }
}



