package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.repositories.FacilityRepositoryImpl;

public class FacilityServiceImpl extends AbstractServiceImpl<Facility> implements FacilityService {

    private static FacilityService instance;

    private static FacilityRepository facilityRepository;

    public FacilityServiceImpl() {
        super(FacilityRepositoryImpl.getInstance());
        facilityRepository = (FacilityRepository) abstractRepository;
    }

    public static FacilityService getInstance() {
        if (instance == null) {
            instance = new FacilityServiceImpl();
        }
        return instance;
    }

    @Override
    public void changePrice(long id, double price) {
        abstractRepository.get(id).ifPresent(facility -> facility.setPrice(price));
    }

}
