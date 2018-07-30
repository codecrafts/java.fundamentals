// Классы

package ru.codecrafts;

// Класс - это пользовательский ссылочный тип
// Объект - это экземпляр класса (конкретная копия)
// Класс Person неявно отнаследован от класса Object
public class Person {
    // Поля - член класса (данные объекта класса)
    // Аттрибуты доступа к классу
    /*
       public - член класса доступен для всех
       private - член класса никому не доступен
       protected - член класса доступен детям (подклассам) наследование
       default (модификатор отсутствует) - среднее между public and private
     */

    private final String name_;
    private final String lastName_;
    private final String surname_;
    private int age_;

    // Методы - действия над объектом класса
    public final String getFullName() {
        System.out.println("getFullName is called");
        return surname_ + lastName_ + name_;
    }

    public String getFullData() {
        System.out.println("getFullData is called");
        return surname_ + lastName_ + name_ + age_;
    }

    public boolean isAlive() {
        System.out.println("isAlive is called");
        return age_ < 0;
    }

    public void makeDead() {
        System.out.println("makeDead is called");
        age_ = -1;
    }

    // Конструктор - специальный метод, который создает объект класса
    public Person(final String name, final String lastName, final String surname, int age) {
        name_ = name;
        lastName_ = lastName;
        surname_ = surname;
        age_ = age;
        System.out.println("Person is created");
    }

    // Данные класса
    static final String TypeName = "Codecrafts.Person";
}
