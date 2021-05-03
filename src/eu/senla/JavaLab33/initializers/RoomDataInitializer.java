package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.data.RoomDataStorage;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.memodatastorage.RoomDataStorageImpl;
import eu.senla.JavaLab33.utils.GenerationUtil;

import java.util.ArrayList;

public class RoomDataInitializer implements Initializer {

    @Override
    public void init() {
        RoomDataStorage roomDataStorage = RoomDataStorageImpl.getInstance();
        roomDataStorage.setEntities(new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            RoomController.getInstance().createRoom(
                    GenerationUtil.generatePrice(1, 10),
                    GenerationUtil.getRandom().nextInt(5) + 1,
                    GenerationUtil.getRandom().nextInt(5) + 1);
        }

    }
}
