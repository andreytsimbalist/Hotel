package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.GuestController;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Component
public class DisplayGuestsByKey implements Action {
    @Autowired
    BookingController bookingController;
    @Autowired
    GuestController guestController;
    @Autowired
    RoomController roomController;

    @Override
    public void execute() throws Exception {

        System.out.print("\nСписок постояльцев и их номеров, отсортированный по:"+
                "\n1. По алфавиту\n2. По дате освобождения\nВаш выбор: ");
        byte choice = ConsoleUtil.getScanner().nextByte();
        System.out.println();
        Date currentDate = new Date();
        switch (choice) {
            case 1:
                search(guestController.getGuestsSortedByKey(Comparator.comparing(Guest::getSecondName)),
                        currentDate,
                        bookingController.getAllBookings());
                break;
            case 2:
                search(guestController.getAllGuests(),
                        currentDate,
                        bookingController.getBookingsSortedByKey(Comparator.comparing(Booking::getCheckOutDate)));
                break;
            default:
                throw new WrongChoiceException();
        }

    }

    private void search(List<Guest> guests, Date currentDate, List<Booking> bookings) {
        for (Guest guest : guests) {
            for (Booking booking : bookings) {
                if (booking.getRoom().getStatus() == RoomStatus.SERVED &&
                        booking.getGuests().contains(guest) &&
                        booking.getCheckOutDate().getTime() > currentDate.getTime()) {

                    guestController.displayGuestInfo(guest.getId());
                    roomController.displayRoomInfo(booking.getRoom().getId());
                }
            }
        }
    }
}
