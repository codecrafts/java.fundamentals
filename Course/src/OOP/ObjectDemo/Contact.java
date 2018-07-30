package ru.codecrafts;

// На самом деле класс EmptyClass неявно наследуется от Object класса
// + содержит конструктор по умолчанию

public class Contact {
    private int id_;

    public Contact(int id) {
        id_ = id;
    }

    @Override
    public String toString() { return Integer.toString(id_); }

    @Override
    public int hashCode() { return id_; }

    @Override
    public boolean equals(Object other) {
        if ( other == null ) return false;
        if (other == this) return true;
        if ( !(other instanceof Contact) ) return false;
        Contact otherMyClass = (Contact) other;

        return this.id_ == otherMyClass.id_;
    }
}

// https://docs.oracle.com/javase/10/docs/api/java/lang/Object.html
// https://developer.android.com/reference/java/lang/Object
// Изучите официальную документацию и ответьте на следующие вопросы:
/*
 1. Из каких еще методов состоит клаcc Object?
 2. Почему я не переопределил другие методы?
 3. Каким требованиям должен соответствовать метод equals?
*/
