package ru.codecrafts;

public class Program {
    public static void main(String[] args) {
        makeEmptyClassExperiment();
        makeContactClassExperiment();
    }

    static void makeEmptyClassExperiment()
    {
        EmptyClass contact = new EmptyClass();
        System.out.println("EmptyClass experiment");
        System.out.println(contact.getClass().toString());
        System.out.println(contact.toString());
        System.out.println(contact.hashCode());
        EmptyClass otherContact = new EmptyClass();
        System.out.println(otherContact.equals(contact)); // ReferenceEquals
    }

    static void makeContactClassExperiment()
    {
        Contact contact = new Contact(10);
        System.out.println("Contact class experiment");
        System.out.println(contact.getClass().toString());
        System.out.println(contact.toString());
        System.out.println(contact.hashCode());
        Contact otherContact = new Contact(10);
        System.out.println(otherContact.equals(contact)); // Value Equals
    }
}
