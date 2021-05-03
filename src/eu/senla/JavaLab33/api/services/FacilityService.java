package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.model.Facility;

public interface FacilityService extends AbstractService<Facility>{

    void changePrice(long id, double price);

}
