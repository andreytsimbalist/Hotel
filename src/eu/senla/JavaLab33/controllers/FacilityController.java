package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.services.FacilityServiceImpl;

import java.util.List;

public class FacilityController {

    private final FacilityService facilityService;

    private static FacilityController instance;

    private FacilityController() {
        this.facilityService = FacilityServiceImpl.getInstance();
    }

    public static FacilityController getInstance() {
        if (instance == null) {
            instance = new FacilityController();
        }
        return instance;
    }

    public List<Facility> getAllFacilities() {
        return facilityService.getAll();
    }

    public void displayFacilityInfo(long id) {
        facilityService.displayInfo(id);
    }

    public void changeFacilityPrice(long id, double price) {
        facilityService.changePrice(id, price);
    }

    public long createFacility(String name, double price) {
        return facilityService.create(new Facility(name, price));
    }

    public Facility getFacilityById(long id) throws NoRecordException {
        return facilityService.get(id);
    }

}
