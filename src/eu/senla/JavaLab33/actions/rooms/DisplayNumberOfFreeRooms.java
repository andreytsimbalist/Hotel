package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;

public class DisplayNumberOfFreeRooms implements Action {

    @Override
    public void execute() throws Exception {

        System.out.println("Общее число свободных номеров: "
                + RoomController.getInstance().getNumberOfFreeRooms() + "\n");

    }

}
