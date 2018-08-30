package ru.codecrafts;

import java.util.ArrayList;

// Источник данных - класс, который абстрагирует клиентов от природы данных (файл, БД, CSV-файл)
// Внутри себя делает преобразование из одного формата в другой (общий)

// Также можно сделать реализацию IDataSource специально для тестовых целей
// Такой подход называется созданием стаба или мокирование данных.
// Это позволяет отвязать юнит или интеграционные тесты от сложного источника данных.
public class DataSource implements IDataSource {
    private ArrayList<IObserver> observers_;

    public DataSource() {
        observers_ = new ArrayList<IObserver>();
    }

    public void doUpdate() {
        for (IObserver observer : observers_) {
            observer.onUpdate(0);
        }
    }

    public void addObserver(IObserver obj) {
        observers_.add(obj);
    }
}
