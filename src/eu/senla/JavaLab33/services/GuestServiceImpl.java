package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.api.services.GuestService;
import eu.senla.JavaLab33.model.Guest;
import eu.senla.JavaLab33.repositories.GuestRepositoryImpl;

public class GuestServiceImpl extends AbstractServiceImpl<Guest> implements GuestService {

    private static GuestService instance;

    private static GuestRepository guestRepository;

    public GuestServiceImpl() {
        super(GuestRepositoryImpl.getInstance());
        guestRepository = (GuestRepository) abstractRepository;
    }

    public static GuestService getInstance() {
        if(instance == null) {
            instance = new GuestServiceImpl();
        }
        return instance;
    }

}
