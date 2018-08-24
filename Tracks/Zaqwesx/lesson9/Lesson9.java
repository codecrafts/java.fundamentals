//Задача. Обработчик HTML-документа.
//На вход: HTML-документ - текстовый файл с разметкой в HTML-формате. Пример файлов приаттачен в данном уроке.
//На выход: Текстовый файл с результатом.
//
//Разметка в HTML-документе производится с помощью тегов. Теги - это английские символы внутри треугольных скобочек,
//например <img src="1.jpeg"></img>
//Считать, что в HTML нет встроенного javascript и css кода, только HTML теги и обычный текст.
//
//Требования к реализации:
//Реализация должна быть в ООП стиле. Покрыта тестами.
//Должна быть организована обработка исключений (отсутствие файла, ошибка при создании файла и прочее).
//Также должна быть создано свое исключение на то, если файл не HTML-файл. (ошибка парсинга)

//Нужно убрать все теги и оставить только неразмеченный текст.
//Для представленного примера выходный файл должен быть со следующим содержанием:
//Заголовок
//Новый заголовок
//Первый абзац
//Второй абзац
//Google it

import java.nio.charset.Charset;
import java.util.List;

public class Lesson9 {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\SourceText.html";
        String resultFilePath = "C:\\Users\\stan\\GitHub\\java.fundamentals\\Tracks\\Zaqwesx\\lesson9\\ResultText";
        List<String> sourceText = FileManipulations.getFileStrings(sourceFilePath, Charset.defaultCharset());
        List<String> resultText;

        resultText = FileManipulations.removeTagsFromList(sourceText);
        FileManipulations.writeStringsToFile(resultFilePath, resultText);
    }
}
