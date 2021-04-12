package eu.senla.JavaLab33.entities;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Hotel {
    ArrayList<Room> rooms;
    ArrayList<Service> availableServices;

    public Hotel() {
        rooms = new ArrayList<>();
        availableServices = new ArrayList<>();
    }
}
