package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.model.enums.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable long id) throws NoRecordException {
        return roomService.get(id);
    }

    @GetMapping("/bystatus{roomStatus}")
    public List<Room> getRoomsByStatus(@PathVariable RoomStatus roomStatus) {
        return roomService.getRoomsByStatus(roomStatus);
    }

    @PutMapping("/changestatus")
    public void changeRoomStatus(@RequestParam long id, @RequestParam RoomStatus roomStatus) {
        roomService.changeStatus(id, roomStatus);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAll();
    }

    @PutMapping("/changeprice")
    public void changeRoomPrice(@RequestParam long id, @RequestParam double price) {
        roomService.changePrice(id, price);
    }

    @PostMapping("/create")
    public long createRoom(@RequestBody Room room) {
        return roomService.create(room);
    }

    @GetMapping("/bycapacity{capacity}")
    public List<Room> getRoomsByCapacity(@PathVariable int capacity) {
        return roomService.getRoomsByCapacity(capacity);
    }

    @GetMapping("/sortedby{sortComparator}")
    public List<Room> getRoomsSortedByKey(@PathVariable SortComparator sortComparator) {
        return roomService.sortByKey(sortComparator);
    }

    @GetMapping("/freesortedby{sortComparator}")
    public List<Room> getFreeRoomsSortedByKey(@PathVariable SortComparator sortComparator) {
        return roomService.sortFreeByKey(sortComparator);
    }

    @GetMapping("/number")
    public int getNumberOfFreeRooms() {
        return roomService.numberOfFreeRooms();
    }

}
