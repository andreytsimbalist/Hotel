package eu.senla.JavaLab33.entities;

import lombok.Data;

@Data
public class Service {
    String name;
    double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
