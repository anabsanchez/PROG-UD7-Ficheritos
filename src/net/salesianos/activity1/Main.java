package net.salesianos.activity1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String fileURL = "src/net/salesianos/activity1/files/activity1.txt";

        String text = getText();

        String formattedText = format(text);

        saveToFile(fileURL, formattedText);
    }

    private static String getText() {

        Scanner scanner = new Scanner(System.in);

        String text = "";
        boolean isActive = true;

        System.out.println("\nIntroduzca un texto de al menos 30 caracteres: ");

        while (isActive) {

            text = scanner.nextLine();

            int textLength = text.length();
            isActive = textLength < 30;

            if (isActive) {
                System.out.println("Texto no válido. Faltan " + (30 - textLength) + " caracteres.");
            }
        }

        scanner.close();
        return text;
    }

    private static String format(String text) {

        return text.toUpperCase().replace(' ', '_');
    }

    private static void saveToFile(String fileURL, String text) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileURL))) {
            writer.write(text);
            System.out.println("El texto se ha guardado correctamente en el fichero " + fileURL);
        } catch (IOException ioe) {
            System.out.println("Error: Problema de I/O.");
        }
    }
}
