package ru.codecrafts;
import java.util.Scanner;

public class Primenumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To what range we will look for prime numbers? ");
        int num = scanner.nextInt();

        if (num <= 2) {
            System.out.println("\n Unfortunately there are no prime numbers available in this range!");
            System.exit(0);
        }
        System.out.println("\n Prime numbers from 1 to " + num + " are:");
        printPrime(num);
    }

    static void printPrime(int num) {
        for (int i = 3; i <= num; i++) {
            if (Primenumber.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    static boolean isPrime(int num) {
        if (num < 2){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}