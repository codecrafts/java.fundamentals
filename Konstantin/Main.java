package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	Scanner in = new Scanner (System.in);
	System.out.print("Enter number 1 = ");
	double a = in.nextDouble();

	System.out.print("Enter number 2 = ");
	double b = in.nextDouble();

	System.out.print("Сhoose action ( + - * / %) = ");
	String с = in.next();

	if (с.equals("+") )
		System.out.println( a + " + " + b + " = " + (a + b) );
	else if (с.equals("-") )
		System.out.println( a + " - " + b + " = " + (a - b) );
	else if (с.equals("*") )
		System.out.println( a + " * " + b + " = " + (a * b) );
	else if (с.equals("/") )
		System.out.println( a + " / " + b + " = " + (a / b) );
	else if (с.equals("%") )
		System.out.println( a + " % " + b + " = " + (a % b) );
	else
		System.out.print("Invalid Action");
	//Для pull request 

    }
}
