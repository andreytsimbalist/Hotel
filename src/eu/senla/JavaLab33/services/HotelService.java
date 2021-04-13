package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.context.Context;
import eu.senla.JavaLab33.entities.*;

import java.util.ArrayList;

public class HotelService {

    public static void addRoom(Room room) {
        Context.getHotel().getRooms().add(room);
    }

    public static boolean tryAddService(Service service) {
        ArrayList<Service> services = Context.getHotel().getAvailableServices();
        for (Service availableService : services) {
            if (availableService.getName().equals(service.getName())) {
                return false;
            }
        }
        services.add(service);
        return true;
    }

    public static boolean tryChangePriceOfService(String name, double newPrice) {
        for (Service service : Context.getHotel().getAvailableServices()) {
            if (service.getName().equals(name)) {
                service.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    public static void displayInfo() {
        if (Context.getHotel().getRooms().size() != 0) {
            for (Room room : Context.getHotel().getRooms()) {
                System.out.println("Room number: " + room.getNumber() + "\nPrice: " + room.getPrice() +
                        "\nStatus: " + room.getStatus());
                if (room.getServices().size() != 0) {
                    System.out.println("Services:");
                    for (Service service : room.getServices()) {
                        System.out.println(service.getName());
                    }
                }
                System.out.println();
            }
        }
        if (Context.getHotel().getAvailableServices().size() != 0) {
            System.out.println("Available services:");
            for (Service service : Context.getHotel().getAvailableServices()) {
                System.out.println(service.getName());
            }
            System.out.println();
        }
    }

    public static boolean tryAccommodateGuest(Guest guest) {
        for (Room room : Context.getHotel().getRooms()) {
            if (room.getPrice() < guest.getMoney() && room.getStatus() == Room.Statuses.AVAILABLE) {
                room.setGuest(guest);
                guest.setMoney(guest.getMoney() - room.getPrice());
                room.setStatus(Room.Statuses.SERVED);
                return true;
            }
        }
        return false;
    }

    public static boolean tryCheckOutRoom(int number) {
        for (Room room : Context.getHotel().getRooms()) {
            if (room.getNumber() == number - 1 && room.getStatus() == Room.Statuses.SERVED) {
                room.setStatus(Room.Statuses.AVAILABLE);
                room.setGuest(new Guest());
                return true;
            }
        }
        return false;
    }

    public static void changeRoomStatus(Room.Statuses status, Room room) {
        if (room.getStatus() == Room.Statuses.SERVED) {
            Room newRoom = new Room(Context.getHotel().getRooms().size() + 1, room.getPrice());
            newRoom.setGuest(room.getGuest());
            newRoom.setStatus(Room.Statuses.SERVED);
            Context.getHotel().getRooms().add(newRoom);
            room.setGuest(new Guest());
        }
        room.setStatus(status);
    }

    public static boolean tryChangeRoomPrice(int number, double price) {
        for (Room room : Context.getHotel().getRooms()) {
            if (room.getNumber() == number) {
                room.setPrice(price);
                return true;
            }
        }
        return false;
    }

}