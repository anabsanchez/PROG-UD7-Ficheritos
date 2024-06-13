package net.salesianos.activity3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
      String filePath1 = "src/net/salesianos/activity1/files/output/file.txt";
      String filePath2 = "src/net/salesianos/activity2/files/file.txt";
      String fileResult = "src/net/salesianos/activity3/files";
      
      String content1 = readFromFile(filePath1);
      String content2 = readFromFile(filePath2);
      
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
}
