package ru.codecrafts;

// Интерфейсы могут наследоваться друг от друга.
public interface ISqlEntity extends IUniqueEntity {
    void storeInDB();
    void loadFromDB();
}
