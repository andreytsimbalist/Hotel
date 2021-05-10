package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.services.GuestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestService guestService;

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
