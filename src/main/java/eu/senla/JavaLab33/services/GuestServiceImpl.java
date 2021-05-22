package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl extends AbstractServiceImpl<Guest> implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public Long create(Guest entity) {
        for (Guest guest : guestRepository.findAll()) {
            if (guest.getPhone().equals(entity.getPhone()) &&
                    guest.getFirstName().equals(entity.getFirstName()) &&
                    guest.getSecondName().equals(entity.getSecondName())) {
                return guest.getId();
            }
        }
        return guestRepository.save(entity).getId();
    }

}
