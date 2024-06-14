package net.salesianos.activity4;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static final String FILE_PATH = "src/net/salesianos/activity4/files/activity4.bin";
    private static final TableManager MANAGER = new TableManager(FILE_PATH);
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String option = SCANNER.nextLine().trim().toLowerCase();

            switch (option) {
                case "1":
                    addTable();
                    break;
                case "2":
                    showAllTables();
                    break;
                case "q":
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
                Menú de opciones:
                1. Nueva mesa
                2. Mostrar todas las mesas almacenadas
                Q. Salir
                -> """);
    }

    private static void addTable() {
        System.out.print("Introduzca el color de la mesa: ");
        String color = SCANNER.nextLine();

        System.out.print("Introduzca el número de patas de la mesa: ");
        int numberOfLegs = Integer.parseInt(SCANNER.nextLine());

        Table table = new Table(color, numberOfLegs);

        try {
            List<Table> tables = MANAGER.readFromFile();
            tables.add(table);
            MANAGER.writeToFile(tables);
            System.out.println("Mesa guardada correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar la mesa: " + e.getMessage());
        }
    }

    private static void showAllTables() {
        try {
            List<Table> tables = MANAGER.readFromFile();
            if (tables.isEmpty()) {
                System.out.println("No hay mesas almacenadas.");
            } else {
                System.out.println("Listado de mesas almacenadas:");
                for (Table table : tables) {
                    System.out.println(table);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer las mesas: " + e.getMessage());
        }
    }
}
