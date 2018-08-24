package lesson9;

public class CustomException extends Exception {
        public CustomException() {}

        public CustomException(String message) {
            super(message);
        }
}
