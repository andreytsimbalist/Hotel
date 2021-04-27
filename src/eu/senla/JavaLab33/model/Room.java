package eu.senla.JavaLab33.model;

import eu.senla.JavaLab33.model.enums.RoomStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Room extends BaseEntity {

    private int stars;

    private RoomStatus status;

    private int capacity;

    private double price;

    private ArrayList<Facility> facilities;

    public Room(double price, int capacity, int stars) {
        status = RoomStatus.AVAILABLE;
        facilities = new ArrayList<>();
        this.price = price;
        this.capacity = capacity;
        this.stars = stars;
    }

    private String facilitiesToString() {
        StringBuilder facilitiesLine = new StringBuilder();
        for (Facility facility : facilities) {
            facilitiesLine.append(facility.toString());
        }
        return facilitiesLine.toString();
    }

    @Override
    public String toString() {
        return "Room ID: " + getId() + "\n\tStatus: " + status + "\n\tPrice: " + price + "\nFacilities:\n" +
                facilitiesToString();
    }

}
