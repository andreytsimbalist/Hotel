package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeRoomAvailable implements Action{

    @Autowired
    RoomController roomController;
    @Override
    public void execute() throws Exception {

        roomController.getAllRooms()
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для перевода в готовое состояние: ");
        long id = ConsoleUtil.getScanner().nextLong();

        roomController.changeRoomStatus(id, RoomStatus.AVAILABLE);
        System.out.println("\nНомер успешно добавлен в обслуживание.\n");

    }

}
