package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.FilterKey;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.model.enums.SortKey;

import java.util.List;

public interface RoomService extends AbstractService<Room>{

    void changeInfo(Room room);

    List<Room> getRoomsFilterByKey(FilterKey filterKey, int capacity, RoomStatus roomStatus);

    List<Room> sortFreeByKey(SortKey sortKey);

    List<Room> sortByKey(SortKey sortKey);

    int numberOfFreeRooms();

}
