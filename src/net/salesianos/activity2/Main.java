import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    String filePath = "src/net/salesianos/activity2/files/file.txt";
    showText(filePath);
  }
  
  private static void showText(String filePath) {
    byte[] textBytes = readFileBytes(filePath);
    
  }

  private static byte[] readFileBytes(String filePath) {
    File file = new File(filePath);
    try (FileInputStream fis = new FileInputStream(file)) { //lee byte a byte
      byte[] bytes = new byte[(int) file.length()];
      fis.read(bytes); //lee el contenido y lo guarda en bytes
      return bytes;
    } catch (IOException ioe) {
      System.out.println("Error: Problema de I/O.");
    }
    return null;
  }

}