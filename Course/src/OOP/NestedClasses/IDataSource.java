package ru.codecrafts;

// Источников данных также может быть несколько, поэтому вводится интерфейс
public interface IDataSource {
    void doUpdate();
    void addObserver(IObserver obj);
}
