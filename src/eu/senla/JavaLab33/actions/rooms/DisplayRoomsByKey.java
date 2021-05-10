package eu.senla.JavaLab33.actions.rooms;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class DisplayRoomsByKey implements Action {

    @Autowired
    RoomController roomController;
    @Override
    public void execute() throws Exception {



        System.out.print("\nСписок номеров, отсортированный по:"+
                "\n1. Цене\n2. Вместимости\n3. Количеству звезд\nВаш выбор: ");
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
