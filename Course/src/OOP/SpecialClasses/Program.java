// Специальные типы классов - абстрактные классы и перечисления

package ru.codecrafts;

public class Program {

    class B extends A
    {
        C c_;// null ссылка по умолчанию.
        B() { System.out.println("B"); c_ = null; }
    }
    class A
    {
        A() { System.out.println("A"); }
    }
    class C
    {
        C() { System.out.println("C"); }

        void print() { System.out.println("C"); }
    }

    public static void main(String[] args) {
        Currency newCcy = Currency.EUR;
        Planet curPlanet = Planet.EARTH;
        Planet otherPlanet = Planet.EARTH;
        Body newBody = new Body();
        Body otherBody = newBody;
        var currentClass = otherBody.getClass();

        Program pr = new Program();

        String str = "2234";
        String newStr = new String("2323");

        System.out.println(curPlanet == otherPlanet);

        int a = 10;
        double b = 20.5;
        int c = 2;
        int answer = 20;
        answer = answer + (b / a * c + a);
    }
}
