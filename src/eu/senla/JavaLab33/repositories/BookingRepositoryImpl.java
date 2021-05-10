package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.BookingDataStorage;
import eu.senla.JavaLab33.api.repositories.BookingRepository;
import eu.senla.JavaLab33.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepositoryImpl extends AbstractRepositoryImpl<Booking> implements BookingRepository {

    @Autowired
    private BookingDataStorage bookingDataStorage;

}
