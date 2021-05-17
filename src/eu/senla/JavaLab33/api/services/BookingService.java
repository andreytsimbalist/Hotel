package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortComparator;

import java.util.List;

public interface BookingService extends AbstractService<Booking>{

    List<Facility> facilitySortedByKey(long id, SortComparator sortComparator) throws NoRecordException;

    List<Booking> sortByKey(SortComparator sortComparator);
}
