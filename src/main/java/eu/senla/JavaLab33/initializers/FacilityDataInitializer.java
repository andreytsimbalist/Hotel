package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.model.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacilityDataInitializer implements Initializer {

    @Autowired
    private  FacilityController facilityController;

    @Override
    public void init() {

        facilityController.createFacility(new Facility("Abattoir", 250));
        facilityController.createFacility(new Facility("Sauna", 178));
        facilityController.createFacility(new Facility("Coffee", 31));
        facilityController.createFacility(new Facility("Niko", 23));
        facilityController.createFacility(new Facility("Chill", 46));
        facilityController.createFacility(new Facility("Heat", 46));
        facilityController.createFacility(new Facility("Drink", 58));
        facilityController.createFacility(new Facility("Safe", 61));
        facilityController.createFacility(new Facility("Massage", 95));
    }
}
