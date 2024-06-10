package net.salesianos.activity1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        String fileURL = "src/files/output/file.txt";

        String text = getText();

        String formattedText = format(text);
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
}



