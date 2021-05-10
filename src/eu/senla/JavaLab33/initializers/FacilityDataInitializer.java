package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.data.FacilityDataStorage;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.memodatastorage.FacilityDataStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class FacilityDataInitializer implements Initializer {

    @Autowired
    private  FacilityController facilityController;
    @Autowired
    private FacilityDataStorage facilityDataStorage;

    @Override
    public void init() {

        facilityController.createFacility("Abatoria", 250);
        facilityController.createFacility("Sauna", 178);
        facilityController.createFacility("Coffee", 31);
        facilityController.createFacility("Niko", 23);
        facilityController.createFacility("Chill", 46);
        facilityController.createFacility("Heat", 46);
        facilityController.createFacility("Drink", 58);
        facilityController.createFacility("Safe", 61);
        facilityController.createFacility("Massage", 95);
    }
}
