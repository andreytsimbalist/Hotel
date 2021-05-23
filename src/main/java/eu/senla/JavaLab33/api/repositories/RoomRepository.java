package eu.senla.JavaLab33.api.repositories;

import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> getRoomsByStatusEquals(RoomStatus status);

}
