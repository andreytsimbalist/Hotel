package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.exceptions.WrongChoice;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class DisplayFreeRoomsByKey implements Action {


    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();

        System.out.println("""
                Список свободных номеров, отсортированный по:
                1. Цене
                2. Вместимости
                3. Количеству звезд
                Ваш выбор:\s""");
        byte choice = ConsoleUtil.getScanner().nextByte();

        switch (choice){
            case 1:
                roomController.getFreeRoomsSortedByStars()
                        .forEach(room -> roomController.displayRoomInfo(room.getId()));
                break;
            case 2:
                roomController.getFreeRoomsSortedByPrice()
                        .forEach(room -> roomController.displayRoomInfo(room.getId()));
                break;
            case 3:
                roomController.getFreeRoomsSortedByCapacity()
                        .forEach(room -> roomController.displayRoomInfo(room.getId()));
                break;
            default:
                throw new WrongChoice();
        }

        System.out.println();

    }

}
