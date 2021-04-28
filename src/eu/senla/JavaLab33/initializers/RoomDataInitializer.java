package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.memodatastorage.DataStorage;
import eu.senla.JavaLab33.utils.GenerationUtil;

import java.util.ArrayList;

public class RoomDataInitializer implements Initializer {

    @Override
    public void init() {
        DataStorage.setRoomIdSequence(0L);
        DataStorage.setRooms(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            RoomController.getInstance().createRoom(
                    GenerationUtil.generatePrice(1, 10),
                    GenerationUtil.getRandom().nextInt(5) + 1,
                    GenerationUtil.getRandom().nextInt(5) + 1);
        }

    }
}
