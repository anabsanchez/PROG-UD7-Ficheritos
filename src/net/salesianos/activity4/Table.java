package net.salesianos.activity4;

import java.io.Serializable;

public class Table implements Serializable {
    
    // private static int count = 0;

    // private int id;
    private String color;
    private int numberOfLegs;

    public Table(String color, int numberOfLegs) {
        // this.id = ++count;
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
        return "Mesa " + "\n - Color: " + color + "\n - Número de patas: " + numberOfLegs;
    }
}
