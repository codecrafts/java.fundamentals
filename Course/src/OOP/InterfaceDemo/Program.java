package ru.codecrafts;

public class Program {

    public static void main(String[] args) {
        Contact newContact = new Contact("");
        printId(newContact);
    }

    // Интерфейсы применяются когда мы хотим использовать поведение не вдаваясь в детали реализации
    // Часто применяется в JDК. Например интерфейс IClonable
    public static void printId(IUniqueEntity entity) {
        System.out.println("Unique ID: " + entity.getUniqueId());
    }
}
