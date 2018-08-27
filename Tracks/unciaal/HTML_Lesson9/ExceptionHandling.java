import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionHandling extends Exception {
    private String errorCode = "Unknown_Exception";

    public ExceptionHandling(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }


    public String getErrorCode(){
        return this.errorCode;
    }
    public static void processErrorCodes(ExceptionHandling e) throws ExceptionHandling {
        // здесь мы ищем указанный при выбросе исключения код ошибки и сообщаем пользователю что произошло
        switch(e.getErrorCode()){
            case "BAD_FILE_TYPE":
                System.out.println("Неподходящий тип файла");
                throw e;
            case "FILE_NOT_FOUND_EXCEPTION":
                System.out.println("Файл не найден");
                break;
            case "CAN_NOT_CREATE_FILE":
                System.out.println("Ошибка при создании файла");
                break;
            default:
                System.out.println("Произошла неизвестная ошибка " + e.getMessage());
                e.printStackTrace();
        }
    }
}



