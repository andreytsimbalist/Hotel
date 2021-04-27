package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.services.RoomServiceImpl;
import lombok.SneakyThrows;

import java.util.List;

public class RoomController {

    private final RoomService roomService;

    private static RoomController instance;

    private RoomController() {
        this.roomService = RoomServiceImpl.getInstance();
    }

    public static RoomController getInstance() {
        if (instance == null) {
            instance = new RoomController();
        }
        return instance;
    }

    public List<Room> getRoomsByStatus(RoomStatus roomStatus) {
        return roomService.getRoomsByStatus(roomStatus);
    }

    @SneakyThrows
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

    public List<Room> getRoomsSortedByPrice() {
        return roomService.sortByPrice();
    }

    public List<Room> getRoomsSortedByCapacity() {
        return roomService.sortByCapacity();
    }

    public List<Room> getRoomsSortedByStars() {
        return roomService.sortByStars();
    }

    public List<Room> getFreeRoomsSortedByPrice() {
        return roomService.sortFreeByPrice();
    }

    public List<Room> getFreeRoomsSortedByCapacity() {
        return roomService.sortFreeByCapacity();
    }

    public List<Room> getFreeRoomsSortedByStars() {
        return roomService.sortFreeByStars();
    }

    public int getNumberOfFreeRooms() {
        return roomService.numberOfFreeRooms();
    }

}
