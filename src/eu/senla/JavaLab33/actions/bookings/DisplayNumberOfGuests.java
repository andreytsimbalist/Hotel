package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.enums.RoomStatus;

import java.util.Date;

public class DisplayNumberOfGuests implements Action {

    @Override
    public void execute() throws Exception {

        BookingController bookingController = BookingController.getInstance();

        int count = 0;
        Date currentDate = new Date();

        for (Booking booking : bookingController.getAllBookings()) {
            if (booking.getRoom().getStatus() == RoomStatus.SERVED &&
                    booking.getCheckOutDate().getTime() > currentDate.getTime()) {

                count += booking.getGuests().size();
            }
        }

        System.out.println("Общее число постояльцев: " + count);

    }

}
