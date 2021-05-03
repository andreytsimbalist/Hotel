package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.BookingService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.services.BookingServiceImpl;

import java.util.Comparator;
import java.util.List;

public class BookingController {

    private final BookingService bookingService;

    private static BookingController instance;

    private BookingController() {
        this.bookingService = BookingServiceImpl.getInstance();
    }

    public static BookingController getInstance() {
        if (instance == null) {
            instance = new BookingController();
        }
        return instance;
    }

    public long createBooking(Booking booking) {
        return bookingService.create(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }

    public void displayBookingInfo(long id) {
        bookingService.displayInfo(id);
    }

    public Booking getBookingById(long id) throws NoRecordException {
        return bookingService.get(id);
    }

    public List<Booking> getBookingsSortedByKey(Comparator<Booking> comparator) {
        return bookingService.sortByKey(comparator);
    }

    public List<Facility> getFacilitySortedByKey(long id, Comparator<Facility> comparator) throws NoRecordException {
        return bookingService.facilitySortedByKey(id, comparator);
    }

}
