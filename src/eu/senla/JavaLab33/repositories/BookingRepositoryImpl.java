package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.BookingDataStorage;
import eu.senla.JavaLab33.api.repositories.BookingRepository;
import eu.senla.JavaLab33.memodatastorage.BookingDataStorageImpl;
import eu.senla.JavaLab33.model.Booking;

public class BookingRepositoryImpl extends AbstractRepositoryImpl<Booking> implements BookingRepository {

    private static BookingRepository instance;

    private static BookingDataStorage bookingDataStorage;

    public BookingRepositoryImpl() {
        abstractDataStorage = BookingDataStorageImpl.getInstance();
        bookingDataStorage = (BookingDataStorage) abstractDataStorage;
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepositoryImpl();
        }
        return instance;
    }

}
