package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.BookingService;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.model.enums.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private GuestService guestService;

    @PostMapping("/create")
    public long createBooking(@RequestBody Booking booking) {
        for (Facility facility : booking.getFacilities()) {
            try {
                facility.setId(facilityService.indexOf(facility));
            } catch (NoRecordException noRecordException) {
                facilityService.create(facility);
            }
        }
        for (Guest guest : booking.getGuests()) {
            try {
                guest.setId(guestService.indexOf(guest));
            } catch (NoRecordException noRecordException) {
                guestService.create(guest);
            }
        }
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

    @GetMapping("/sortedby{sortComparator}")
    public List<Booking> getBookingsSortedByKey(@PathVariable SortComparator sortComparator) {
        return bookingService.sortByKey(sortComparator);
    }

    @GetMapping("/booking{id}sortedby{sortComparator}")
    public List<Facility> getFacilitySortedByKey(@PathVariable long id,
                                                 @PathVariable SortComparator sortComparator) throws NoRecordException {
        return bookingService.facilitySortedByKey(id, sortComparator);
    }

}