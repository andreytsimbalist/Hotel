package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.RoomDataStorage;
import eu.senla.JavaLab33.api.repositories.RoomRepository;
import eu.senla.JavaLab33.memodatastorage.RoomDataStorageImpl;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;

import java.util.List;
import java.util.stream.Collectors;

public class RoomRepositoryImpl extends AbstractRepositoryImpl<Room> implements RoomRepository {

    private static RoomRepository instance;

    private static RoomDataStorage roomDataStorage;

    public RoomRepositoryImpl() {
        super(RoomDataStorageImpl.getInstance());
        roomDataStorage = (RoomDataStorage) abstractDataStorage;
    }

    public static RoomRepository getInstance() {
        if(instance == null) {
            instance = new RoomRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<Room> getFreeRooms() {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(room -> room.getStatus() == RoomStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
