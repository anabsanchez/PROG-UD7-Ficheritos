package net.salesianos.activity3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final String FILE_PATH_1 = "src/net/salesianos/files/activity1.txt";
    private static final String FILE_PATH_2 = "src/net/salesianos/files/activity2.txt";
    private static final String FILE_PATH_RESULT = "src/net/salesianos/files/activity3.txt";

    public static void main(String[] args) {

        String content1 = readFromFile(FILE_PATH_1);
        String content2 = readFromFile(FILE_PATH_2);

        String mergedContent = "- Contenido del Fichero Uno: " + content1 + "\n" +
                "- Contenido del Fichero Dos: " + content2 + "\n" +
                "Mensaje de firma: Proyecto completado :D \n Hecho por: ANCLA :p";

        appendToFile(FILE_PATH_RESULT, mergedContent);
        System.out.println("Ficheros exitosamente fusionados en: " + FILE_PATH_RESULT);
    }

    private static String readFromFile(String filePath) {

        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error: Problema de I/O.");
        }

        return content.toString();
    }

    private static void appendToFile(String path, String content) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error: Problema de I/O al escribir en el archivo.");
        }
    }
}
