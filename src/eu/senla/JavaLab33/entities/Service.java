package eu.senla.JavaLab33.entities;

import lombok.Data;

@Data
public class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
