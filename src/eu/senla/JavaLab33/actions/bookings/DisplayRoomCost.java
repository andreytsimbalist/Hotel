package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class DisplayRoomCost implements Action {

    @Override
    public void execute() throws Exception {

        BookingController bookingController = BookingController.getInstance();

        for (Booking booking : bookingController.getAllBookings()) {
            bookingController.displayBookingInfo(booking.getId());
        }

        System.out.print("ID вашего заказа: ");
        long id = ConsoleUtil.getScanner().nextLong();

        int cost = 0;

        Booking booking = bookingController.getBookingById(id);
        cost += booking.getRoom().getPrice();
        for (Facility facility : booking.getFacilities()) {
            cost += facility.getPrice();
        }
        System.out.print("Цена за номер: " + cost);

    }

}
