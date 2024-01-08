package org.example.vttFilesToTxt;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1 уровень сложности: 1 Есть архив VttFiles.zip (см. в группе дискорд)
// с набором vtt-файлов (субтитры к аудиодорожкам).
// Из субтитров нужно собрать единый файл txt для последующего создания документа со скриптами аудиодорожек.
// В txt поместите только тексты из субтитров. Все лишние записи (время, WEBVTT) должны быть удалены.


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\Jeremi\\IdeaProjects\\Home_Work_14\\VttFiles";
        File directory = new File(path);
        File[] vttFiles = directory.listFiles();
        List<String> listVtt = new ArrayList<>();
        if (vttFiles != null) {
            for (File file: vttFiles) {
                try {
                    Scanner sc = new Scanner(file);
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        if (!line.contains("WEBVTT") && !line.contains("-->") && !line.isEmpty()) {
                        listVtt.add(line + "\n");
                        }
                     }
                    sc.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
        }

            }
        } else throw new RuntimeException("Files not found");

        writeToTxt(listVtt, new FileOutputStream("text.txt"));

    }
    public static void writeToTxt(List<String> list, OutputStream output) {
        for (String line : list) {
            try {
                output.write(line.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}