package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;

import java.util.Comparator;
import java.util.List;

public interface BookingService extends AbstractService<Booking>{

    List<Facility> facilitySortedByKey(long id, Comparator<Facility> comparator) throws NoRecordException;

}
