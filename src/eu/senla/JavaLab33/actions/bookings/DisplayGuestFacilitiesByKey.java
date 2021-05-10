package eu.senla.JavaLab33.actions.bookings;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.BookingController;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class DisplayGuestFacilitiesByKey implements Action {

    @Autowired
    FacilityController facilityController;
    @Autowired
    BookingController bookingController;

    @Override
    public void execute() throws Exception {


        bookingController.getAllBookings()
                .forEach(booking -> bookingController.displayBookingInfo(booking.getId()));

        System.out.print("ID заказа для отображения информации: ");
        long id = ConsoleUtil.getScanner().nextLong();
        System.out.print("\nСписок услуг постояльца, отсортированный по:\n1. Цене\n2. Дате\nВаш выбор: ");
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
