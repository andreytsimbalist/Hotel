package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.FilterKey;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable long id) throws NoRecordException {
        return roomService.get(id);
    }

    @PutMapping
    public void changeRoomInfo(@RequestBody Room room) {
        roomService.changeInfo(room);
    }

    @GetMapping("/all")
    public List<Room> getAllRooms() {
        return roomService.getAll();
    }

    @PostMapping("/create")
    public long createRoom(@RequestBody Room room) {
        return roomService.create(room);
    }

    @GetMapping("/filter")
    public List<Room> getRoomsFilterByKey(@RequestParam FilterKey key, @RequestParam int capacity,
                                          @RequestParam RoomStatus roomStatus) {
        return roomService.getRoomsFilterByKey(key, capacity, roomStatus);
    }

    @GetMapping("/sort")
    public List<Room> getRoomsSortedByKey(@RequestParam SortKey key) {
        return roomService.sortByKey(key);
    }

    @GetMapping("/free/sort")
    public List<Room> getFreeRoomsSortedByKey(@RequestParam SortKey key) {
        return roomService.sortFreeByKey(key);
    }

    @GetMapping("/number")
    public int getNumberOfFreeRooms() {
        return roomService.numberOfFreeRooms();
    }

}