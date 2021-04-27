package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class RenovateRoom implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        roomController.getAllRooms()
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для ремонта: ");
        long id = ConsoleUtil.getScanner().nextLong();
        System.out.println();

        roomController.changeRoomStatus(id, RoomStatus.REPAIRED);
        System.out.println("В номере успешно начался ремонт.\n");

    }

}
