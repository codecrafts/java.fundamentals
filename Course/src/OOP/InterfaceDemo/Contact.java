package ru.codecrafts;

// Класс Contact определяет (наследуется от) интерфейсов IUniqueEntity, Cloneable
// То есть тип Contact должен реализовать все методы, чтобы считаться интерфейсом IUniqueEntity
// От интерфейсов можно наследоваться множественно.
public class Contact implements IUniqueEntity, Cloneable {
    private long id_;
    private String name_;

    Contact(String name) {
        id_ = System.currentTimeMillis();
        name_ = name;
    }

    public long getUniqueId() { return id_; }

    // Плохой пример, поскольку Cloneable не имеет метода clone (Effective Java)
    @Override
    public Contact clone() { return new Contact(name_); }
}
