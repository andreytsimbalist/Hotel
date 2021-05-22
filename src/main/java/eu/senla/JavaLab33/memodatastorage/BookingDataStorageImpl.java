package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.BookingDataStorage;
import eu.senla.JavaLab33.model.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingDataStorageImpl extends AbstractDataStorageImpl<Booking> implements BookingDataStorage {

}
