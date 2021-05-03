package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.utils.ConsoleUtil;

import java.util.Comparator;

public class DisplayRoomsByKey implements Action {

    @Override
    public void execute() throws Exception {

        RoomController roomController = RoomController.getInstance();

        System.out.print("""
                Список номеров, отсортированный по:
                1. Цене
                2. Вместимости
                3. Количеству звезд
                Ваш выбор:\s""");
        byte choice = ConsoleUtil.getScanner().nextByte();
        System.out.println();
        switch (choice){
            case 1:
                roomController.getRoomsSortedByKey(Comparator.comparing(Room::getPrice))
                        .forEach(room -> roomController.displayRoomInfo(room.getId()));
                break;
            case 2:
                roomController.getRoomsSortedByKey(Comparator.comparing(Room::getCapacity))
                        .forEach(room -> roomController.displayRoomInfo(room.getId()));
                break;
            case 3:
                roomController.getRoomsSortedByKey(Comparator.comparing(Room::getStars))
                        .forEach(room -> roomController.displayRoomInfo(room.getId()));
                break;
            default:
                throw new WrongChoiceException();
        }

    }

}
