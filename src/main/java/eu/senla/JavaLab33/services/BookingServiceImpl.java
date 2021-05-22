package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.BookingRepository;
import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.api.services.BookingService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl extends AbstractServiceImpl<Booking> implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Facility> facilitySortedByKey(Long id, SortKey sortKey) throws NoRecordException {
        Booking booking;
        Comparator<Facility> comparator = null;
        if (bookingRepository.findById(id).isPresent()) {
            booking = bookingRepository.findById(id).get();
        } else {
            throw new NoRecordException();
        }
        switch (sortKey) {
            case PRICE:
                comparator = Comparator.comparing(Facility::getPrice);
                break;
            case DATE:
                comparator = Comparator.comparing(Facility::getDateAdded);
                break;
            default:
                return null;
        }
        return booking.getFacilities()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> sortByKey(SortKey sortKey) {
        switch (sortKey) {
            case ALPHABET:
                List<Guest> guests = ((List<Guest>) guestRepository.findAll())
                        .stream()
                        .sorted(Comparator.comparing(Guest::getSecondName))
                        .collect(Collectors.toList());
                List<Booking> bookings = new ArrayList<>();
                for (Guest guest : guests) {
                    bookingRepository.findAll()
                            .forEach(booking -> {
                                if (booking.getGuests().contains(guest))
                                    bookings.add(booking);
                            });
                }
                return bookings;
            case CHECKOUTDATE:
                return ((List<Booking>) bookingRepository.findAll())
                        .stream()
                        .sorted(Comparator.comparing(Booking::getCheckOutDate))
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }
}
