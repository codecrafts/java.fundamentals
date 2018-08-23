public class ExceptionHandling {
    public void catchException() {
        try {
            System.out.println("This will be not printed");

            // Ключевое слово catch используется для определения блока обработки исключений
            // В скобках указывается тип обрабатываемого исключения

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
}
