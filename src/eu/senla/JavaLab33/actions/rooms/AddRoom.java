package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class AddRoom implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();

        System.out.println("Данные новой комнаты.");
        System.out.print("Цена номера: ");
        double price = ConsoleUtil.getScanner().nextDouble();

        System.out.print("Вместимость номера: ");
        int capacity = ConsoleUtil.getScanner().nextInt();

        System.out.print("Количество звезд номера: ");
        int stars = ConsoleUtil.getScanner().nextInt();

        roomController.createRoom(price, capacity, stars);
        System.out.println("Номер добавлен.\n");

    }

}
