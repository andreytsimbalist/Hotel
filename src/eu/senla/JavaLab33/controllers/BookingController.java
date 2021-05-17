package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.BookingService;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private GuestService guestService;

    @PostMapping("/create")
    public long createBooking(@RequestBody Booking booking) {
        booking.getFacilities().forEach(facility -> facility.setId(facilityService.indexOf(facility)));
        booking.getGuests().forEach(guest -> guest.setId(guestService.indexOf(guest)));
        return bookingService.create(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable long id) throws NoRecordException {
        return bookingService.get(id);
    }

    @GetMapping("/sort")
    public List<Booking> getBookingsSortedByKey(@RequestParam SortKey key) {
        return bookingService.sortByKey(key);
    }

    @GetMapping("/{id}/facilities/sort")
    public List<Facility> getFacilitySortedByKey(@PathVariable long id,
                                                 @RequestParam SortKey key) throws NoRecordException {
        return bookingService.facilitySortedByKey(id, key);
    }

}