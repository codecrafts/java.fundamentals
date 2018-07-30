package ru.codecrafts;

// Абстрактный класс - класс, для которого нельзя создать объект, поскольку это лишено смысла
public class Body { // Трехмерное тело
    //  public abstract double getVolume(); // Абстрактный метод - это метод  у которого нет тела

    // В отличие от интерфейсов могут сожержать реализацию методов
    // public double getVolume(double multiplier) { return multiplier * getVolume(); }
    static Body newBody = new Body();
    static Body otherBody = newBody;
}
