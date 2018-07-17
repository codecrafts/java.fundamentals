package com.company;
import java.util.Scanner;
public class Main {

    public static boolean checkindex(String str) {
       if(str.length()==6)
       {
        if(Character.isDefined(str.charAt(0))==true || Character.isDefined(str.charAt(1))==true || Character.isDefined(str.charAt(2))==true
                || Character.isDefined(str.charAt(3))==true || Character.isDefined(str.charAt(4))==true || Character.isDefined(str.charAt(5))==true)
        {
            return true;
        }
        else
        {
            return false;
        }
       }
       else {
           return false;
       }
    }


    public static void main(String[] args) {
        String str="301848";
        String substr;
        if(checkindex(str)==true)
        {
            substr=str.substring(0,3);
            switch (substr.charAt(0))
            {
                case '1':
                    System.out.println("Москва и область");
                    break;
                case '2':
                    System.out.println("Брянская область");
                    break;
                case '3':
                    System.out.println("Тульская область");
                    break;
                    default:
                        System.out.println("Такого индекса нет");
            }
        }
    }
}
