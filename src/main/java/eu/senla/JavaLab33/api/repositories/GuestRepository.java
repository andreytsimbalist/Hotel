package eu.senla.JavaLab33.api.repositories;

import eu.senla.JavaLab33.model.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
