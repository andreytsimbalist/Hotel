package eu.senla.JavaLab33.dto;

import eu.senla.JavaLab33.model.Room;

import java.util.Date;
import java.util.List;

public class BookingDto {

    private Date registrationDate;
    private Date checkOutDate;
    private Room room;
    private List<GuestDto> guests;
    private List<FacilityDto> facilities;

}
