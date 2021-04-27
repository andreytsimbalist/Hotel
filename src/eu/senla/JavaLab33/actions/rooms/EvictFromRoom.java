package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class EvictFromRoom implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        roomController.getRoomsByStatus(RoomStatus.SERVED)
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для выселения: ");
        long id = ConsoleUtil.getScanner().nextLong();
        System.out.println();

        roomController.changeRoomStatus(id, RoomStatus.AVAILABLE);
        System.out.println("Выселение успешно выполнено.\n");

    }

}
