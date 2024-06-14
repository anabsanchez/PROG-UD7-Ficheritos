package net.salesianos.actividad4;

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

    public void writeToFile(List<Table> tables) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(tables);
        }
    }

    public List<Table> readFromFile() throws IOException, ClassNotFoundException {
        List<Table> tables = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                for (Object o : (List<?>) obj) {
                    if (o instanceof Table) {
                        tables.add((Table) o);
                    }
                }
            }
        }

        return tables;
    }
}
