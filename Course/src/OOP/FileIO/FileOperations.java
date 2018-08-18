package ru.codecrafts;

import java.nio.file.Files;
import java.nio.charset.Charset;
import java.io.IOException;
import java.nio.file.Paths;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.List;

// Есть много способов работать с файлами в Java, но наиболее простой и актуальный - это с помощью класса Files
// https://developer.android.com/reference/java/nio/file/Files
// https://docs.oracle.com/javase/10/docs/api/java/nio/file/Files.html

// Для работы с текстовыми файлами вам понадобятся также классы
// BufferReader - для чтения текстового файла, при этом буферизуя прочитанные символы
// https://docs.oracle.com/javase/10/docs/api/java/io/BufferedReader.html
// https://developer.android.com/reference/java/io/BufferedReader
// BufferWriter - для записи текстового файла, при этом минимизируя количество обращений к файлу.
// https://developer.android.com/reference/java/io/BufferedWriter
// https://docs.oracle.com/javase/10/docs/api/java/io/BufferedWriter.html


public class FileOperations {
    public static void main(String[] args) {
        try {
            System.out.println("Reading file..");
            List<String> lines = getFileStrings("D:\\example.txt", Charset.defaultCharset());
            System.out.println("Lines read: " + lines.size());
            System.out.println("Writing file..");
            writeStringsToFile("D:\\new-examples.txt", lines);
        }
        catch (IOException exc) {
            System.out.println("IOException is thrown " + exc.toString());
        }
    }

    // Метод считывает файл как одну строчку в заданной кодировке
    static String getFileAsString(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path)); // Считать все байты из файла
        return new String(encoded, encoding);                 // Создать строчку
    }

    // Метод считывает файл как набор строчек
    static List<String> getFileStrings(String path, Charset encoding) throws IOException {
        return Files.readAllLines(Paths.get(path), encoding);
    }

    // Метод записывает строчку в заданный файл
    static void writeStringsToFile(String path, List<String> strings) throws  IOException {
        FileWriter fileReader = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);
        for (String str : strings) {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
