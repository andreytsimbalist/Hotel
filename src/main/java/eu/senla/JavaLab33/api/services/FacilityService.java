package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortKey;

import java.util.List;

public interface FacilityService extends AbstractService<Facility>{

    void changeInfo(Facility facility);

    List<Facility> sortByKey(SortKey sortKey);

    Long create(Facility entity);

}
