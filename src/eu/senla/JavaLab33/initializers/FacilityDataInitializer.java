package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.memodatastorage.DataStorage;

import java.util.ArrayList;

public class FacilityDataInitializer implements Initializer {

    @Override
    public void init() {
        DataStorage.setFacilityIdSequence(0L);
        DataStorage.setFacilities(new ArrayList<>());
    }
}
