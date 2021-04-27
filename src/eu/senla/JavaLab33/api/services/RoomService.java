package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;

import java.util.List;

public interface RoomService extends AbstractService<Room>{

    void displayInfo(long id) throws NoRecordException;

    void changeStatus(long id, RoomStatus roomStatus);

    RoomStatus getStatus(long id) throws NoRecordException;

    List<Room> getRoomsByStatus(RoomStatus roomStatus);

    void changePrice(long id, double price);

    List<Room> sortByPrice();

    List<Room> sortByCapacity();

    List<Room> sortByStars();

    List<Room> sortFreeByPrice();

    List<Room> sortFreeByCapacity();

    List<Room> sortFreeByStars();

    int numberOfFreeRooms();

}
