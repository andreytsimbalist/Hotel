package eu.senla.JavaLab33.api.repositories;

import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;

import java.util.List;

public interface RoomRepository extends AbstractRepository<Room> {

    List<Room> getRoomsByStatusEquals(RoomStatus status);

}
