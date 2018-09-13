package lesson10;

public class noValidFileExeption extends Exception{
    public noValidFileExeption() {}

    public noValidFileExeption(String message) {
        super(message);
    }
}