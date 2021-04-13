package eu.senla.JavaLab33.services;


import eu.senla.JavaLab33.context.Context;
import eu.senla.JavaLab33.entities.Room;
import eu.senla.JavaLab33.entities.Service;

import java.util.ArrayList;

public class RoomService {

    public static boolean tryAddService(String name, int number) {
        ArrayList<Service> services = Context.getHotel().getAvailableServices();
        for (Service service : services) {
            if (service.getName().equals(name)) {
                for (Room room : Context.getHotel().getRooms()) {
                    if (room.getNumber() == number && !room.getServices().contains(service)) {
                        if (room.getStatus() == Room.Statuses.SERVED) {
                            if (room.getGuest().getMoney() >= service.getPrice()) {
                                room.getGuest().setMoney(room.getGuest().getMoney() - service.getPrice());
                                room.getServices().add(service);
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            room.getServices().add(service);
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }
}


