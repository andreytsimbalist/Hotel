package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.services.HotelService;

public class Tests {
    public static void addRooms() {
        for (int i = 0; i < 10; i++) {
            HotelService.addRoom();
        }
    }

    public static void addServicesToHotel() {
        if (HotelService.tryAddService("Ambulance")) {
            System.out.println("Service |Ambulance| added!");
        } else {
            System.out.println("Service |Ambulance| already exist!");
        }
        if (HotelService.tryAddService("Breakfast in bed")) {
            System.out.println("Service |Breakfast in bed| added!");
        } else {
            System.out.println("Service |Breakfast in bed| already exist!");
        }
        if (HotelService.tryAddService("Ambulance")) {
            System.out.println("Service |Ambulance| added!");
        } else {
            System.out.println("Service |Ambulance| already exist!");
        }
        if (HotelService.tryAddService("Jacuzzi")) {
            System.out.println("Service |Jacuzzi| added!");
        } else {
            System.out.println("Service |Jacuzzi| already exist!");
        }
    }

    public static void addServicesToRoom() {

    }

    public static void accommodateInRoom() {

    }

    public static void checkOutTheRoom() {

    }

    public static void changeNumberStatus() {

    }

    public static void changeRoomPrice() {

    }

    public static void changePriceOfService() {
        if (HotelService.tryChangePriceOfService("Ambulance", 314.14)) {
            System.out.println("Price has changed!");
        } else {
            System.out.println("There is no such service!");
        }
    }
}
