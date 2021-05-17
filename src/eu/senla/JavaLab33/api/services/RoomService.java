package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.model.enums.SortComparator;

import java.util.List;

public interface RoomService extends AbstractService<Room>{

    void changeStatus(long id, RoomStatus roomStatus);

    List<Room> getRoomsByStatus(RoomStatus roomStatus);

    List<Room> getRoomsByCapacity(int capacity);

    void changePrice(long id, double price);

    List<Room> sortFreeByKey(SortComparator sortComparator);

    List<Room> sortByKey(SortComparator sortComparator);

    int numberOfFreeRooms();

}
