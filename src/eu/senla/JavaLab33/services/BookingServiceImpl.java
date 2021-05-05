package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.BookingRepository;
import eu.senla.JavaLab33.api.services.BookingService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.repositories.BookingRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl extends AbstractServiceImpl<Booking> implements BookingService {

    private static BookingService instance;

    private static BookingRepository bookingRepository;

    public BookingServiceImpl() {
        super(BookingRepositoryImpl.getInstance());
        bookingRepository = (BookingRepository) abstractRepository;
    }

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Facility> facilitySortedByKey(long id, Comparator<Facility> comparator) throws NoRecordException {
        Booking booking;
        if (bookingRepository.get(id).isPresent()) {
            booking = bookingRepository.get(id).get();
        } else {
            throw new NoRecordException();
        }
        return booking.getFacilities()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
