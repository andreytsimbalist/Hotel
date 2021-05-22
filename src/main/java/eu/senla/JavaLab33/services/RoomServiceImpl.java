package eu.senla.JavaLab33.services;


import eu.senla.JavaLab33.api.repositories.RoomRepository;
import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.FilterKey;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl extends AbstractServiceImpl<Room> implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void changeInfo(Room room) {
        roomRepository.save(room);
    }

    @Override
    public List<Room> getRoomsFilterByKey(FilterKey filterKey, int capacity, RoomStatus roomStatus) {
        Predicate<Room> predicate = getFilter(filterKey, capacity, roomStatus);
        if (predicate == null) {
            return null;
        }
        return ((List<Room>) roomRepository.findAll())
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortFreeByKey(SortKey sortKey) {
        Comparator<Room> comparator = getComparator(sortKey);
        if (comparator == null) {
            return null;
        }
        return roomRepository.getRoomsByStatusEquals(RoomStatus.AVAILABLE)
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortByKey(SortKey sortKey) {
        Comparator<Room> comparator = getComparator(sortKey);
        if (comparator == null) {
            return null;
        }
        return ((List<Room>) roomRepository.findAll())
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    private Predicate<Room> getFilter(FilterKey filterKey, int capacity, RoomStatus roomStatus) {
        switch (filterKey) {
            case CAPACITY:
                return room -> room.getCapacity() >= capacity;
            case ROOMSTATUS:
                return room -> room.getStatus() == roomStatus;
            default:
                return null;
        }
    }

    private Comparator<Room> getComparator(SortKey sortKey) {
        switch (sortKey) {
            case PRICE:
                return Comparator.comparing(Room::getPrice);
            case CAPACITY:
                return Comparator.comparing(Room::getCapacity);
            case STARS:
                return Comparator.comparing(Room::getStars);
            default:
                return null;
        }
    }

    @Override
    public int numberOfFreeRooms() {
        return roomRepository.getRoomsByStatusEquals(RoomStatus.AVAILABLE).size();
    }

}