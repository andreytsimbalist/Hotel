package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.BookingDataStorage;
import eu.senla.JavaLab33.model.Booking;

public class BookingDataStorageImpl extends AbstractDataStorageImpl<Booking> implements BookingDataStorage {

    private static BookingDataStorage instance;

    public static BookingDataStorage getInstance() {
        if (instance == null) {
            instance = new BookingDataStorageImpl();
        }
        return instance;
    }

}
