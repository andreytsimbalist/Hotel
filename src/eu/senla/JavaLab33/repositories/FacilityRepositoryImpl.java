package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.FacilityDataStorage;
import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.memodatastorage.FacilityDataStorageImpl;
import eu.senla.JavaLab33.model.Facility;

public class FacilityRepositoryImpl extends AbstractRepositoryImpl<Facility> implements FacilityRepository {

    private static FacilityRepository instance;

    private static FacilityDataStorage facilityDataStorage;

    public FacilityRepositoryImpl() {
        super(FacilityDataStorageImpl.getInstance());
        facilityDataStorage = (FacilityDataStorage) abstractDataStorage;
    }

    public static FacilityRepository getInstance() {
        if (instance == null) {
            instance = new FacilityRepositoryImpl();
        }
        return instance;
    }

}