package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class ChangePriceOfRoom implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();
        roomController.getAllRooms()
                .forEach(room -> roomController.displayRoomInfo(room.getId()));

        System.out.print("ID номера для изменения цены: ");
        long id = ConsoleUtil.getScanner().nextLong();

        System.out.print("Новая цена номера: ");
        double price = ConsoleUtil.getScanner().nextDouble();

        roomController.changeRoomPrice(id, price);
        System.out.println("\nЦена изменена.\n");
    }

}
