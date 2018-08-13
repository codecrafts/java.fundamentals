package ru.codecrafts;

// Обработка исключений - это специальный механизм обработки ошибок и других редких ситуации в коде
// Данный механизм позволяет структуировать код обработки ошибок и отделить его от основного кода программы.

public class ExceptionHandlingDemo {
    public static void main(String[] args) {

        // Ключевое слово try используется для определения защищенного блока
        // Защищенный блок - это блок, в котором могут произойти исключения.
        try {
            throwException("not-throw");
            accessNullPointer(null);
            System.out.println("This will be not printed");

            // Ключевое слово catch используется для определения блока обработки исключений
            // В скобках указывается тип обрабатываемого исключения
        } catch (CustomException ex) {       // Обработка пользовательского исключения типа CustomException
            System.out.println("Custom exception happened");
        } catch (NullPointerException ex) {  // Обработка встроенного исключения типа NullPointerException
            System.out.println("Null pointer was referenced");
        } catch (Exception ex) { // Обработчик всех возможных исключений
            System.out.println("Some other error situation happened");
        } catch (Error ex) { // Родитель всех ошибок, предок Throwable
            System.out.println("Some other error situation happened");
        } catch (Throwable ex) { // Родитель всех ошибок и исключений
            System.out.println("All other situation happened");
            // Ключевое слово finally используется для определения завершающего блока
            // Этот код будет выполнен в любом случае даже при возникновении исключительной ситуации
        } finally {
            System.out.println("We are in the finally block");
        }
    }

    // Метод, который может сгенерировать исключение типа CustomException
    // throws CustomException обязывает код, который вызывает данный метод обрабатывать данное исключение
    // то есть заключать в виде try-catch блок.
    // Если вызывающий код это не сделает, то это вызовет ошибку компиляции.
    // Через запятую может содержать список исключений
    private static void throwException(String str) throws CustomException {
        if (str == "throw")
            throw new CustomException("throwException");

        System.out.println("throwException is called");
    }

    // Метод, который генерирует стандартное исключение NullPointerException
    private static void accessNullPointer(String str) {
        System.out.println("accessNullPointer" + str.length());
    }
}
