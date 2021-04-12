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

    ArrayList<Guest> guests;

    ArrayList<Service> services;

    Statuses status;

    int number;

    double price;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
        services = new ArrayList<>();
        status = Statuses.AVAILABLE;
        guests = new ArrayList<>();
    }
}
