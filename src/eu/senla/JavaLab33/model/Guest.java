package eu.senla.JavaLab33.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Guest extends BaseEntity {

    private String firstName;

    private String secondName;

    private String phone;

    public Guest(String firstName, String secondName, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Guest ID: " + getId() +
                "\n\tFirst name: " + firstName +
                "\n\tSecond name: " + secondName +
                "\n\tPhone: " + phone + "\n";
    }

}
