package com.company;
import java.util.Scanner;

class PostIndexCheck {

    public static void main(String[] args) {
        String strIndex = IndexEnter();
        boolean chckIndex;
        int number;
        Scanner in = new Scanner(System.in);
            if (checkIndex(strIndex)) {
                checkPrint(chckIndex = checkIndex(strIndex));
            }
            else if (strIndex.equals("test")) {
            testCode();
        }
            else {
                checkPrint(false);
            }


    }

    static String IndexEnter()
    {
        String rindex;
        Scanner in = new Scanner(System.in);
        System.out.println("Введите почтовый индекс России или test: ");
        rindex = in.next();
        return rindex;
    }

    static boolean checkIndex(String index)
    {
        int count = 0;
        if(index.length()==6)
        {
            for(int i=0; i<index.length(); i++)
            {
                if(Character.isDigit(index.charAt(i)) && index.charAt(0)!='0')
                {
                   count++;
                }
                else
                {
                    return false;
                }
            }
        }
        if (count == 6)
        {
            return true;
        }
        return false;
    }

    static void checkPrint (boolean checkIndex){
        if (checkIndex)
        {
            System.out.println("Проверка индекса успешно пройдена.");
        }
        else
        {
            System.out.println("Проверка индекса не была пройдена.");
        }
    }
    static boolean testCode() {
        int testcount = 0;
        int testcount1 = 0;
        if (checkIndex("301848") && !checkIndex("12345A")) {
            System.out.println("Тест 1 пройден успешно!");
            testcount++;
        }
        if (checkIndex("866558") && !checkIndex("5A90BG")) {
            System.out.println("Тест 2 пройден успешно!");
            testcount++;
        }
        if(testcount == 2) return true;
        else return false;

    }

}
