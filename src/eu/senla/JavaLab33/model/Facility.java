package eu.senla.JavaLab33.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Facility extends BaseEntity {

    private String name;

    private double price;

    public Facility(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Facility ID: " + getId() + "\n\tName: " + name + "\n\tPrice: " + price;
    }
}