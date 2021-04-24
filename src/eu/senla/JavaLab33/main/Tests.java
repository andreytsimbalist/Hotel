package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.context.Context;
import eu.senla.JavaLab33.entities.Guest;
import eu.senla.JavaLab33.entities.Room;
import eu.senla.JavaLab33.entities.Service;
import eu.senla.JavaLab33.entities.Statuses;
import eu.senla.JavaLab33.services.HotelService;
import eu.senla.JavaLab33.services.RoomService;

public class Tests {
    public static void addRooms() {
        for (int i = 0; i < 10; i++) {
            HotelService.addRoom(new Room(Context.getHotel().getRooms().size() + 1,
                    Math.ceil(Context.getRandom().nextDouble() * 10000) / 100.0));
        }
    }

    public static void addServicesToHotel() {
        if (HotelService.tryAddService(new Service("Ambulance",
                Context.getRandom().nextDouble() * 10))) {
            System.out.println("Service |Ambulance| added!");
        } else {
            System.out.println("Service |Ambulance| already exist!");
        }
        if (HotelService.tryAddService(new Service("Breakfast in bed",
                Context.getRandom().nextDouble() * 10))) {
            System.out.println("Service |Breakfast in bed| added!");
        } else {
            System.out.println("Service |Breakfast in bed| already exist!");
        }
        if (HotelService.tryAddService(new Service("Ambulance",
                Context.getRandom().nextDouble() * 10))) {
            System.out.println("Service |Ambulance| added!");
        } else {
            System.out.println("Service |Ambulance| already exist!");
        }
        if (HotelService.tryAddService(new Service("Jacuzzi",
                Context.getRandom().nextDouble() * 10))) {
            System.out.println("Service |Jacuzzi| added!");
        } else {
            System.out.println("Service |Jacuzzi| already exist!");
        }
    }

    public static void addServicesToRoom() {
        if (RoomService.tryAddService("Ambulance", 4)) {
            System.out.println("Service |Ambulance| added!");
        } else {
            System.out.println("Service |Ambulance| already exist, there's no such service or " +
                    "Guest haven't enough money!");
        }
        if (RoomService.tryAddService("Breakfast in bed", 4)) {
            System.out.println("Service |Breakfast in bed| added!");
        } else {
            System.out.println("Service |Breakfast in bed| already exist, there's no such service or " +
                    "Guest haven't enough money!");
        }
        if (RoomService.tryAddService("Ambulance", 4)) {
            System.out.println("Service |Ambulance| added!");
        } else {
            System.out.println("Service |Ambulance| already exist, there's no such service or " +
                    "Guest haven't enough money!");
        }
        if (RoomService.tryAddService("Jacuzzi", 5)) {
            System.out.println("Service |Jacuzzi| added!");
        } else {
            System.out.println("Service |Jacuzzi| already exist, there's no such service or " +
                    "Guest haven't enough money!");
        }
    }

    public static void accommodateInRoom() {
        if (HotelService.tryAccommodateGuest(new Guest("DAVE", "MORRISSON",
                "KD0", 1))) {
            System.out.println("Welcome to the Hotel!");
        } else {
            System.out.println("You don't have enough money to live in this hotel or there's no" +
                    " available rooms in hotel");
        }
        if (HotelService.tryAccommodateGuest(new Guest("Mello", "Jul",
                "dk12", 227))) {
            System.out.println("Welcome to the Hotel!");
        } else {
            System.out.println("You don't have enough money to live in this hotel or there's no" +
                    " available rooms in hotel");
        }
        if (HotelService.tryAccommodateGuest(new Guest("Jane", "Trickle",
                "Em23", 73))) {
            System.out.println("Welcome to the Hotel!");
        } else {
            System.out.println("You don't have enough money to live in this hotel or there's no" +
                    " available rooms in hotel");
        }
        if (HotelService.tryAccommodateGuest(new Guest("Srapky", "Cistern",
                "Ntr211", 1))) {
            System.out.println("Welcome to the Hotel!");
        } else {
            System.out.println("You don't have enough money to live in this hotel or there's no" +
                    " available rooms in hotel");
        }
        if (HotelService.tryAccommodateGuest(new Guest("Artyshka", "Salenteva",
                "Lsa", 21))) {
            System.out.println("Welcome to the Hotel!");
        } else {
            System.out.println("You don't have enough money to live in this hotel or there's no" +
                    " available rooms in hotel");
        }
    }

    public static void checkOutTheRoom() {
        if (HotelService.tryCheckOutRoom(2)) {
            System.out.println("CheckOuting is successful");
        } else {
            System.out.println("There's a problem");
        }
        if (HotelService.tryCheckOutRoom(3)) {
            System.out.println("CheckOuting is successful");
        } else {
            System.out.println("There's a problem");
        }
        if (HotelService.tryCheckOutRoom(7)) {
            System.out.println("CheckOuting is successful");
        } else {
            System.out.println("There's a problem");
        }
    }

    public static void changeRoomStatus() {
        int size = Context.getHotel().getRooms().size();
        for (int i = 0; i < size; i++) {
            HotelService.changeRoomStatus(Statuses.REPAIRED, Context.getHotel().getRooms().get(i));
        }
    }

    public static void changeRoomPrice() {
        if (HotelService.tryChangeRoomPrice(3, 500)) {
            System.out.println("Room price is successfully changed");
        } else {
            System.out.println("There's a problem");
        }
        if (HotelService.tryChangeRoomPrice(6, 320)) {
            System.out.println("Room price is successfully changed");
        } else {
            System.out.println("There's a problem");
        }
        if (HotelService.tryChangeRoomPrice(8, 200)) {
            System.out.println("Room price is successfully changed");
        } else {
            System.out.println("There's a problem");
        }
        if (HotelService.tryChangeRoomPrice(1, 150)) {
            System.out.println("Room price is successfully changed");
        } else {
            System.out.println("There's a problem");
        }
        if (HotelService.tryChangeRoomPrice(9, 50)) {
            System.out.println("Room price is successfully changed");
        } else {
            System.out.println("There's a problem");
        }
    }

    public static void changePriceOfService() {
        if (HotelService.tryChangePriceOfService("Ambulance", 314.14)) {
            System.out.println("Price has changed!");
        } else {
            System.out.println("There is no such service!");
        }
        if (HotelService.tryChangePriceOfService("Abdullah", 314.14)) {
            System.out.println("Price has changed!");
        } else {
            System.out.println("There is no such service!");
        }
        if (HotelService.tryChangePriceOfService("Breakfast in bed", 314.14)) {
            System.out.println("Price has changed!");
        } else {
            System.out.println("There is no such service!");
        }
    }
}
