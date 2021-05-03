package eu.senla.JavaLab33.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseEntity {

    private Date registrationDate;

    private Date checkOutDate;

    private Room room;

    private List<Guest> guests;

    private List<Facility> facilities;

    private String guestsToString() {
        StringBuilder result = new StringBuilder();
        for (Guest guest : guests) {
            result.append(guest.toString());
        }
        return result.toString();
    }

    private String facilitiesToString() {
        StringBuilder result = new StringBuilder();
        for (Facility facility : facilities) {
            result.append(facility.toString());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Booking ID: " + getId() +
                "\n\tRegistration date: " + registrationDate +
                "\n\tCheckout date: " + checkOutDate +
                room + guestsToString() + facilitiesToString() + "\n";
    }

}
