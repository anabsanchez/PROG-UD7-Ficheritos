package net.salesianos.activity3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    String filePath1 = "src/net/salesianos/activity1/files/output/file.txt";
    String filePath2 = "src/net/salesianos/activity2/files/file.txt";
    String fileResult = "src/net/salesianos/activity3/files/fileResult.txt";
    String content1 = readFromFile(filePath1);
    String content2 = readFromFile(filePath2);
    String mergedContent = "- Contenido del Fichero Uno: " + content1 + "\n" +
                "- Contenido del Fichero Dos: " + content2 + "\n" +
                "Mensaje de firma: Proyecto completado :D \n Hecho por: ANCLA :p";
    appendToFile(fileResult, mergedContent);
    System.out.println("Ficheros exitosamente fusionados en: " + fileResult);
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
  private static void appendToFile(String path, String content){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
      writer.write(content);
      writer.newLine();
    } catch (IOException e) {
      System.out.println("Error: Problema de I/O al escribir en el archivo.");
    }
  }
}
