package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.services.FacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;

@Controller
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    public List<Facility> getAllFacilities() {
        return facilityService.getAll();
    }

    public void displayFacilityInfo(long id) {
        facilityService.displayInfo(id);
    }

    public void changeFacilityPrice(long id, double price) {
        facilityService.changePrice(id, price);
    }

    public List<Facility> getFacilitiesSortedByKey(Comparator<Facility> comparator){
        return facilityService.sortByKey(comparator);
    }

    public long createFacility(String name, double price) {
        return facilityService.create(new Facility(name, price));
    }

    public Facility getFacilityById(long id) throws NoRecordException {
        return facilityService.get(id);
    }

}
