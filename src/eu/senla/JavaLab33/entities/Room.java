package eu.senla.JavaLab33.entities;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Room {
    public enum Statuses {
        AVAILABLE,
        REPAIRED,
        SERVED
    }

    private Guest guest;

    private ArrayList<Service> services;

    private Statuses status;

    private int number;

    private double price;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
        services = new ArrayList<>();
        status = Statuses.AVAILABLE;
        guest = new Guest();
    }
}
