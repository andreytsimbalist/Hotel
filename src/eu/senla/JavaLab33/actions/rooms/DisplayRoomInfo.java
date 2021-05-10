package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisplayRoomInfo implements Action {

    @Autowired
    RoomController roomController;
    @Override
    public void execute() throws Exception {


        roomController.getAllRooms()
                .forEach(room -> System.out.println(room.getId()));

        System.out.print("ID номера для отображения информации: ");
        long id = ConsoleUtil.getScanner().nextLong();

        roomController.displayRoomInfo(id);

    }

}
