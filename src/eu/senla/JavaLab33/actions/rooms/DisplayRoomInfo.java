package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class DisplayRoomInfo implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        roomController.getAllRooms()
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для отображения информации: ");
        long id = ConsoleUtil.getScanner().nextLong();

        roomController.displayRoomInfo(id);

    }

}
