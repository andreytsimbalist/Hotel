package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.memodatastorage.DataStorage;
import eu.senla.JavaLab33.api.repositories.RoomRepository;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomRepositoryImpl implements RoomRepository {

    private static RoomRepository instance;

    public static RoomRepository getInstance() {
        if(instance == null) {
            instance = new RoomRepositoryImpl();
        }
        return instance;
    }

    @Override
    public long create(Room room) {
        return DataStorage.createRoom(room).getId();
    }

    @Override
    public void delete(long id) throws NoRecordException {
        Room roomToDelete = DataStorage.getRooms()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(NoRecordException::new);

        DataStorage.getRooms().remove(roomToDelete);
    }

    @Override
    public void update(Room room) {
        int index = DataStorage.getRooms().indexOf(room);
        DataStorage.getRooms().set(index, room);
    }

    @Override
    public Optional<Room> get(long id) {
        return DataStorage.getRooms()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public List<Room> getAll() {
        return DataStorage.getRooms();
    }

    @Override
    public List<Room> getFreeRooms() {
        return DataStorage.getRooms()
                .stream()
                .filter(room -> room.getStatus() == RoomStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
