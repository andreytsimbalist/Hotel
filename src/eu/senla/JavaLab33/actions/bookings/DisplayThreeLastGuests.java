package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.GuestController;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.utils.ConsoleUtil;

import java.util.Collections;
import java.util.List;

public class DisplayThreeLastGuests implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        BookingController bookingController = BookingController.getInstance();
        GuestController guestController = GuestController.getInstance();

        roomController.getAllRooms()
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для вывода информации: ");
        long id = ConsoleUtil.getScanner().nextLong();

        List<Booking> bookings = bookingController.getAllBookings();
        Collections.reverse(bookings);

        byte count = 3;

        for (int i = bookings.size() - 1; i >= 0; i--) {
            Booking booking = bookings.get(i);
            if (booking.getRoom().getId() == id) {

                System.out.print("Дата регистрации: " + booking.getRegistrationDate());
                System.out.print("Дата выселения: " + booking.getCheckOutDate());

                for (Guest guest : booking.getGuests()) {
                    if (count != 0) {
                        guestController.displayGuestInfo(guest.getId());
                        count--;
                    } else {
                        return;
                    }
                }
            }
        }

    }

}
