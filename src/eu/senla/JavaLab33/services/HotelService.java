package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.context.Context;
import eu.senla.JavaLab33.entities.*;

import java.util.ArrayList;

public class HotelService {
    public static void addRoom() {
        ArrayList<Room> rooms = Context.getHotel().getRooms();
        rooms.add(new Room(rooms.size() + 1, Math.ceil(Context.getRandom().nextDouble() * 10000) / 100.0));
    }

    public static boolean tryAddService(String name) {
        ArrayList<Service> services = Context.getHotel().getAvailableServices();
        for (Service service : services) {
            if (service.getName().equals(name)) {
                return false;
            }
        }
        services.add(new Service(name, Context.getRandom().nextDouble() * 10));
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
                room.getGuests().add(guest);
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
                room.getGuests().clear();

                return true;
            }
        }
        return false;
    }

    public static void changeRoomStatus(Room.Statuses status, Room room) {
        if (room.getStatus() == Room.Statuses.SERVED) {
            Room newRoom = new Room(Context.getHotel().getRooms().size() + 1, room.getPrice());
            newRoom.setGuests(room.getGuests());
            newRoom.setStatus(Room.Statuses.SERVED);
            Context.getHotel().getRooms().add(newRoom);
            room.setGuests(new ArrayList<>());
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