package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisplayNumberOfFreeRooms implements Action {
    @Autowired
    RoomController roomController;

    @Override
    public void execute() throws Exception {

        System.out.println("Общее число свободных номеров: "
                + roomController.getNumberOfFreeRooms() + "\n");

    }

}
