package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.utils.GenerationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomDataInitializer implements Initializer {
   
    @Autowired
    private RoomController roomController;

    @Override
    public void init() {

        for (int i = 0; i < 10; i++) {
            roomController.createRoom(new Room(
                    GenerationUtil.generatePrice(1, 10),
                    GenerationUtil.getRandom().nextInt(5) + 1,
                    GenerationUtil.getRandom().nextInt(5) + 1));
        }

    }
}