package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class AccommodateInRoom implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        roomController.getRoomsByStatus(RoomStatus.AVAILABLE)
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для заселения: ");
        long id = ConsoleUtil.getScanner().nextLong();
        System.out.println();

        roomController.changeRoomStatus(id, RoomStatus.SERVED);
        System.out.println("Заселение прошло успешно.\n");
    }
}
