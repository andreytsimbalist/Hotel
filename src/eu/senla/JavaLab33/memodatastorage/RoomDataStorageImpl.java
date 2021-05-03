package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.RoomDataStorage;
import eu.senla.JavaLab33.model.Room;

public class RoomDataStorageImpl extends AbstractDataStorageImpl<Room> implements RoomDataStorage {

    private static RoomDataStorage instance;

    public static RoomDataStorage getInstance() {
        if (instance == null) {
            instance = new RoomDataStorageImpl();
        }
        return instance;
    }
}
