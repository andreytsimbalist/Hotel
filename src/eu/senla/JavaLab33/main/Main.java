package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.initializers.MainInitializer;
import eu.senla.JavaLab33.services.HotelService;

public class Main {

    public static void main(String[] args) {
        MainInitializer.init();
        Tests.addRooms();
        HotelService.displayInfo();
        Tests.addServicesToHotel();
        HotelService.displayInfo();
    }
}
