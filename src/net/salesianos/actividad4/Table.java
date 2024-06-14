package net.salesianos.actividad4;

public class Table {
    
    private static int count = 0;

    private int id;
    private String color;
    private int numberOfLegs;

    public Table(String color, int numberOfLegs) {
        this.id = ++count;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    @Override
    public String toString() {
        return "Mesa " + id + "\n - Color: " + color + "\n - Número de patas: " + numberOfLegs;
    }
}
