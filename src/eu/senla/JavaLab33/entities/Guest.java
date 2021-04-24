package eu.senla.JavaLab33.entities;

import lombok.Data;

@Data
public class Guest {
    private String name;
    private String surname;
    private String passport;
    private double money;

    otsosi mne chlen

    public Guest() {

    }

    public Guest(String name, String surname, String passport, double money) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
        this.money = money;
    }
}
