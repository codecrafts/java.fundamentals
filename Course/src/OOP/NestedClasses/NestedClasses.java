package ru.codecrafts;

// Встроенные классы - это возможность группировать классы, которые логически связаны друг с другом.
// Так же это возможность ограничить доступ к полям интерфейса и уменьшить количество файлов.
public class NestedClasses {

    private static int data_;

    // Встроенные классы могут быть как static так и non-static
    static protected class NestedObserver implements IObserver {
        public void onUpdate(int newData) {
            // Внутренние классы имеют доступ к членам класса, который их содержит
            data_ = newData;
        }
    }

    // Вложенные интерфейсы тоже могут иметь место, но встречаются редко на практике
    static interface IDataReciever {
        void receiveData(int data);
    }

    public static void main(String[] args) {
        // все можно сделать намного компактнее с помощью анонимных классов
        // анонимные классы - это все лишь "синтаксический сахар" для упрощения ввода встроенных классов
        // для некоторых сценариев использования
        var otherObserver = new IObserver() {
            public void onUpdate(int newData) {
                // Внутренние классы имеют доступ к членам класса, который их содержит
                data_ = newData;
            }
        };

        // Теперь создаем источник данных и подписываемся на обновления данных
        DataSource newDataSource = new DataSource();
        newDataSource.addObserver(otherObserver);
        newDataSource.doUpdate();

    }
}
