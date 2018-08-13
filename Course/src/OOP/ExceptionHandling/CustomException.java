package ru.codecrafts;

// Этот класс определяет пользовательское исключение
// Исключение - это специальный тип, который используется в try-catch-finally блоках, а также в throws method declarations.
public class CustomException extends Exception {
    public CustomException() {}
    public CustomException(String message)
    {
        super(message);
    }
}
