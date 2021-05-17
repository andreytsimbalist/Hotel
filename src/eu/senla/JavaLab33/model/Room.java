package eu.senla.JavaLab33.model;

import eu.senla.JavaLab33.model.enums.RoomStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room extends BaseEntity {

    private int stars;
    private RoomStatus status;
    private int capacity;
    private double price;

    public Room(double price, int capacity, int stars) {
        status = RoomStatus.AVAILABLE;
        this.price = price;
        this.capacity = capacity;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Room ID: " + getId() +
                "\n\tStatus: " + status +
                "\n\tPrice: " + price +
                "\n\tCapacity: " + capacity +
                "\n\tStars: " + stars + "\n";
    }

}
