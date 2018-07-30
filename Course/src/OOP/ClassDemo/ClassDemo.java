
package ru.codecrafts;

public class ClassDemo {

    public static void main(String[] args) {
        Person vasya = new Person("Vasya", "Ivanovich", "Pupkin", 40);
        vasya.makeDead();
        if (!vasya.isAlive())
            System.out.println("Vasya is dead!");


        Parent papa = new Parent("papa", "Ivanovich", "Pupkin", 60, vasya);
        papa.makeDead();
        if (!papa.isAlive())
            System.out.println("papa is dead!");

        // Главная суть наследования:
        // Papa is not only a parent, it's also a Person
        Person oneMoreReference = papa;
    }
}
