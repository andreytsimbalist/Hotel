package eu.senla.JavaLab33.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Facility extends BaseEntity {

    private String name;

    private double price;

    private Date dateAdded;

    public Facility(String name, double price) {
        this.name = name;
        this.price = price;
        dateAdded = new Date();
    }

    @Override
    public String toString() {
        return "Facility ID: " + getId() +
                "\n\tName: " + name +
                "\n\tPrice: " + price +
                "\n\tDate: " + dateAdded + "\n";
    }
}