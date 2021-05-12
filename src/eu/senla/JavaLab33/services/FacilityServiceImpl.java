package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.model.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl extends AbstractServiceImpl<Facility> implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public void changePrice(long id, double price) {
        abstractRepository.get(id).ifPresent(facility -> facility.setPrice(price));
    }

}
