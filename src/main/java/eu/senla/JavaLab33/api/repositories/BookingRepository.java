package eu.senla.JavaLab33.api.repositories;

import eu.senla.JavaLab33.model.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Long> {
}
