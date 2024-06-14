package net.salesianos.activity2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String filePath = "src/net/salesianos/files/activity2.txt";
        showText(filePath);
    }

    private static void showText(String filePath) {

        byte[] textBytes = readFileBytes(filePath);

        for (int i = 0; i < textBytes.length - 1; i++) {
            System.out.print((char) textBytes[i] + "_" + textBytes[i] + ", ");
        }

        if (textBytes.length > 0) {
            System.out.println((char) textBytes[textBytes.length - 1] + "_" + textBytes[textBytes.length - 1]);
        }
    }

    private static byte[] readFileBytes(String filePath) {

        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        } catch (IOException ioe) {
            System.out.println("Error: Problema de I/O.");
        }

        return null;
    }
}