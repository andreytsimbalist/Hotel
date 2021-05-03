package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class AddFacility implements Action {

    @Override
    public void execute() throws Exception {

        BookingController bookingController = BookingController.getInstance();
        FacilityController facilityController = FacilityController.getInstance();

        bookingController.getAllBookings()
                .forEach(booking -> bookingController.displayBookingInfo(booking.getId()));

        System.out.print("ID заказа для подключения услуги: ");
        long bookingId = ConsoleUtil.getScanner().nextLong();

        facilityController.getAllFacilities()
                .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));

        System.out.print("ID услуги для подключения: ");
        long facilityId = ConsoleUtil.getScanner().nextLong();

        bookingController.getBookingById(bookingId).getFacilities()
                .add(facilityController.getFacilityById(facilityId));

        System.out.println("Услуга успешно добавлена.\n");

    }

}
