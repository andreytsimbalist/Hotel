package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.controllers.GuestController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.utils.ConsoleUtil;

import java.util.Comparator;

public class DisplayGuestFacilitiesByKey implements Action {

    @Override
    public void execute() throws Exception {
        GuestController guestController = GuestController.getInstance();
        FacilityController facilityController = FacilityController.getInstance();
        BookingController bookingController = BookingController.getInstance();

        bookingController.getAllBookings()
                .forEach(booking -> bookingController.displayBookingInfo(booking.getId()));

        System.out.print("ID заказа для отображения информации: ");
        long id = ConsoleUtil.getScanner().nextLong();

        System.out.print("""
                Список услуг постояльца, отсортированный по:
                1. Цене
                2. Дате
                Ваш выбор:\s""");
        byte choice = ConsoleUtil.getScanner().nextByte();
        System.out.println();
        switch (choice) {
            case 1:
                bookingController.getFacilitySortedByKey(id, Comparator.comparing(Facility::getPrice))
                        .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));
                break;
            case 2:
                bookingController.getFacilitySortedByKey(id, Comparator.comparing(Facility::getDateAdded))
                        .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));
                break;
            default:
                throw new WrongChoiceException();
        }

    }

}
