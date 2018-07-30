// Отношения между классами: Наследование vs Композиция
// Используется для многократного использования классов

// Наследование - отношения типа является. Круг является фигурой. А трава растением.
// Создает новый тип через внутренности старого типа
// Наследник имеет доступ к protected и public членам класса родителя

// Композиция - это отношение между объектами. Один объект состоит или находится в крепкой связи с другими.
// Создает новый тип посредством (используя как интсрумент) другой тип
// Класс контейнер имеет доступ только к public-членам класса.

package ru.codecrafts;

// Класс Student отнаследован от класса Person
// Ограничение Java: Родительский класс только один
public class Parent extends Person {

    // Композиция: Класс Parent также содержит объект класса Person
    private Person child_;

    // Может быть один ко многим, то есть содержать несколько объектов
    // private ArrayList<Person> children_;

    public Parent(String name, String lastName, String surname, int age, Person child) {
        super(name, lastName, surname, age); // Вызов конструктор класса Person
        this.child_ = child; // ключевое слово this используется явно, чтобы указать к чему относится член класса
        System.out.println("Parent is created");
    }

    public String getChildData() { return child_.getFullName(); }

    // Parent.getFullData(boolean bIncludeChildren)
    // Перегружает (дополняет)
    // Person.getFullData()
    public String getFullData(boolean bIncludeChildren) {
        if (!bIncludeChildren)
            return super.getFullData();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getFullData());
        stringBuilder.append(getChildData());

        return stringBuilder.toString();
    }

    // Parent.getFullData(boolean bIncludeChildren)
    // Переопределяет (замещает)
    // Person.getFullData()
    @Override
    public String getFullData() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getFullData());
        stringBuilder.append(getChildData());

        return stringBuilder.toString();
    }
}
