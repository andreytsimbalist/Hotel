package eu.senla.JavaLab33.services;


import eu.senla.JavaLab33.api.repositories.RoomRepository;
import eu.senla.JavaLab33.api.services.RoomService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.repositories.RoomRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private static RoomService instance;

    private RoomServiceImpl() {
        this.roomRepository = RoomRepositoryImpl.getInstance();
    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    @Override
    public long create(Room room) {
        return roomRepository.create(room);
    }

    @Override
    public void delete(long id) throws NoRecordException {
        roomRepository.delete(id);
    }

    @Override
    public void update(Room room) {
        roomRepository.update(room);
    }

    @Override
    public Room get(long id) throws NoRecordException {
        return roomRepository.get(id).orElseThrow(NoRecordException::new);
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.getAll();
    }



    @Override
    public void displayInfo(long id) {
        roomRepository.get(id).ifPresent(System.out::println);
    }

    @Override
    public void changeStatus(long id, RoomStatus roomStatus) {
        roomRepository.get(id).ifPresent(room -> room.setStatus(roomStatus));
    }

    @Override
    public RoomStatus getStatus(long id) throws NoRecordException {
        Optional<Room> room = roomRepository.get(id);
        return room.map(Room::getStatus).orElseThrow(NoRecordException::new);
    }

    @Override
    public List<Room> getRoomsByStatus(RoomStatus roomStatus) {
        return roomRepository.getAll()
                .stream()
                .filter(room -> room.getStatus() == roomStatus)
                .collect(Collectors.toList());
    }

    @Override
    public void changePrice(long id, double price) {
        roomRepository.get(id).ifPresent(room -> room.setPrice(price));
    }

    @Override
    public List<Room> sortByPrice() {
        return roomRepository.getAll()
                .stream()
                .sorted(Comparator.comparing(Room::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortByCapacity() {
        return roomRepository.getAll()
                .stream()
                .sorted(Comparator.comparing(Room::getCapacity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortByStars() {
        return roomRepository.getAll()
                .stream()
                .sorted(Comparator.comparing(Room::getStars))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortFreeByPrice() {
        return roomRepository.getFreeRooms()
                .stream()
                .sorted(Comparator.comparing(Room::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortFreeByCapacity() {
        return roomRepository.getFreeRooms()
                .stream()
                .sorted(Comparator.comparing(Room::getCapacity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Room> sortFreeByStars() {
        return roomRepository.getFreeRooms()
                .stream()
                .sorted(Comparator.comparing(Room::getStars))
                .collect(Collectors.toList());
    }

    @Override
    public int numberOfFreeRooms() {
        return roomRepository.getFreeRooms().size();
    }

}