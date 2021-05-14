package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    public Room getRoom(long id) throws NoRecordException {
        return roomService.get(id);
    }

    public List<Room> getRoomsByStatus(RoomStatus roomStatus) {
        return roomService.getRoomsByStatus(roomStatus);
    }

    public void displayRoomInfo(long id) {
        roomService.displayInfo(id);
    }

    public void changeRoomStatus(long id, RoomStatus roomStatus) {
        roomService.changeStatus(id, roomStatus);
    }

    public List<Room> getAllRooms() {
        return roomService.getAll();
    }

    public void changeRoomPrice(long id, double price) {
        roomService.changePrice(id, price);
    }

    public long createRoom(double price, int capacity, int stars) {
        return roomService.create(new Room(price, capacity, stars));
    }

    public List<Room> getRoomsByCapacity(int capacity) {
        return roomService.getRoomsByCapacity(capacity);
    }

    public List<Room> getRoomsSortedByKey(Comparator<Room> comparator) {
        return roomService.sortByKey(comparator);
    }

    public List<Room> getFreeRoomsSortedByKey(Comparator<Room> comparator) {
        return roomService.sortFreeByKey(comparator);
    }

    public int getNumberOfFreeRooms() {
        return roomService.numberOfFreeRooms();
    }

}
