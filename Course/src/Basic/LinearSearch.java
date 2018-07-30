package ru.codecrafts;

public class LinearSearch {
    public static void main(String[] args) {
        // Ингридиенты
        int[] array = { 10, 50, 60, 70 }; // Входные данные: массив чисел
        int valueToFind = 60;             // Входные данные: искомое число
        int indexOfFoundValue = -1;       // Выходные данные: индекс в массиве
        // Рецепт приготовления
        for ( int i = 0; i < array.length; i++) { // Перебираем все элементы массива
            if ( array[i] == valueToFind) { // Сравиваем элемент массива с искомым
                // Запоминаем индекс и завершаем перебор.
                // indexOfFoundValue = i;
                break;
            }
        }

        // Блюдо подано
        System.out.print("Index of found value: ");
        System.out.print(indexOfFoundValue);
    }
}
