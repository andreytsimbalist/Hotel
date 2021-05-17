package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortComparator;

import java.util.List;

public interface FacilityService extends AbstractService<Facility>{

    void changePrice(long id, double price);

    List<Facility> sortByKey(SortComparator sortComparator);

    long indexOf(Facility entity) throws NoRecordException;

}
