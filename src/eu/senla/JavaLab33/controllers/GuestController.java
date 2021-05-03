package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.services.GuestServiceImpl;

import java.util.Comparator;
import java.util.List;

public class GuestController {

    private final GuestService guestService;

    private static GuestController instance;

    private GuestController() {
        this.guestService = GuestServiceImpl.getInstance();
    }

    public static GuestController getInstance() {
        if (instance == null) {
            instance = new GuestController();
        }
        return instance;
    }

    public Guest getById(long id) throws NoRecordException {
        return guestService.get(id);
    }

    public long createGuest(String firstName, String secondName, String phone) {
        return guestService.create(new Guest(firstName, secondName, phone));
    }

    public List<Guest> getAllGuests() {
        return guestService.getAll();
    }

    public void displayGuestInfo(long id) {
        guestService.displayInfo(id);
    }

    public List<Guest> getGuestsSortedByKey(Comparator<Guest> comparator) {
        return guestService.sortByKey(comparator);
    }

}
