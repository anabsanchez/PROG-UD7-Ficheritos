package net.salesianos.activity4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TableManager {
    
    private final String FILE_PATH;

    public TableManager(String filePath) {
        this.FILE_PATH = filePath;
    }

    public void writeToFile(ArrayList<Table> tables) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(tables);
        } catch (IOException ioe) {
            throw new IOException("Error: Problema de I/O. " + ioe.getMessage());
        }
    }

    public ArrayList<Table> readFromFile() throws IOException, ClassNotFoundException {
        ArrayList<Table> tables = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList) {
                for (Object o : (List<?>) obj) {
                    if (o instanceof Table) {
                        tables.add((Table) o);
                    }
                }
            }
        } catch (EOFException e) {
            // Fin del fichero
        }

        return tables;
    }
}
