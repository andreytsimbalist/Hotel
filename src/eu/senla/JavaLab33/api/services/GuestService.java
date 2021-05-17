package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Guest;

public interface GuestService extends AbstractService<Guest> {

    long indexOf(Guest entity) throws NoRecordException;

}
