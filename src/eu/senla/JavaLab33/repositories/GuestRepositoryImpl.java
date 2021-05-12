package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.GuestDataStorage;
import eu.senla.JavaLab33.api.repositories.GuestRepository;
import eu.senla.JavaLab33.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestRepositoryImpl extends AbstractRepositoryImpl<Guest> implements GuestRepository {

    @Autowired
    private GuestDataStorage guestDataStorage;

}
