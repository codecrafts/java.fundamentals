package ru.codecrafts;

// Наблюдателей может быть несколько, поэтому вводится интерфейс
public interface IObserver {
    void onUpdate(int newData);
}
