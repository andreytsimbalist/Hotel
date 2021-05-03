package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.api.data.FacilityDataStorage;
import eu.senla.JavaLab33.model.Facility;

public class FacilityDataStorageImpl extends AbstractDataStorageImpl<Facility> implements FacilityDataStorage {

    private static FacilityDataStorage instance;

    public static FacilityDataStorage getInstance() {
        if (instance == null) {
            instance = new FacilityDataStorageImpl();
        }
        return instance;
    }

}
