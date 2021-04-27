package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.memodatastorage.DataStorage;

import java.util.ArrayList;

public class RoomDataInitializer implements Initializer {

    @Override
    public void init() {
        DataStorage.setRoomIdSequence(0L);
        DataStorage.setRooms(new ArrayList<>());
    }
}
