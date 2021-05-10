package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.repositories.GuestRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl extends AbstractServiceImpl<Guest> implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

}
