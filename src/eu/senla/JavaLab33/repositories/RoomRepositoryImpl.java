package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.RoomDataStorage;
import eu.senla.JavaLab33.api.repositories.RoomRepository;
import eu.senla.JavaLab33.memodatastorage.RoomDataStorageImpl;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomRepositoryImpl extends AbstractRepositoryImpl<Room> implements RoomRepository {

    @Autowired
    private RoomDataStorage roomDataStorage;


    @Override
    public List<Room> getFreeRooms(){
        return abstractDataStorage.getEntities()
                .stream()
                .filter(room -> room.getStatus() == RoomStatus.AVAILABLE)
                .collect(Collectors.toList());
    }
}
