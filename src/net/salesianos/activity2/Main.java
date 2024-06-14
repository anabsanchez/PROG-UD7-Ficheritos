package net.salesianos.activity2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    private static final String FILE_PATH = "src/net/salesianos/activity2/files/activity2.txt";

    public static void main(String[] args) {

        showText(FILE_PATH);
    }

    private static void showText(String filePath) {

        byte[] textBytes = readFileBytes(filePath);

        for (int i = 0; i < textBytes.length - 1; i++) {
            System.out.print((char) textBytes[i] + "_" + textBytes[i] + ", ");
        }

        if (textBytes.length > 0) {
            System.out.println((char) textBytes[textBytes.length - 1] + "" + textBytes[textBytes.length - 1]);
        }
    }

    private static byte[] readFileBytes(String filePath) {

        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) { // lee byte a byte
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes); // lee el contenido y lo guarda en bytes
            return bytes;
        } catch (IOException ioe) {
            System.out.println("Error: Problema de I/O.");
        }

        return null;
    }

}