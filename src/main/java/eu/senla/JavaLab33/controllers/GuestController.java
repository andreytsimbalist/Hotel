package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("/{id}")
    public Guest getById(@PathVariable Long id) throws NoRecordException {
        return guestService.get(id);
    }

    @PostMapping
    public long createGuest(@RequestBody Guest guest) {
        return guestService.create(guest);
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.getAll();
    }

}
