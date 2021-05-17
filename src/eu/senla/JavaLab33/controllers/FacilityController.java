package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping("/all")
    public List<Facility> getAllFacilities() {
        return facilityService.getAll();
    }

    @PutMapping("/facility{id}newPrice{price}")
    public void changeFacilityPrice(@PathVariable long id, @PathVariable double price) {
        facilityService.changePrice(id, price);
    }

    @GetMapping("/sortedby{sortComparator}")
    public List<Facility> getFacilitiesSortedByKey(@PathVariable SortComparator sortComparator) {
        return facilityService.sortByKey(sortComparator);
    }

    @PostMapping("/create")
    public long createFacility(@RequestBody Facility facility) {
        try {
            return facilityService.indexOf(facility);
        } catch(NoRecordException noRecordException) {
            return facilityService.create(facility);
        }
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable long id) throws NoRecordException {
        return facilityService.get(id);
    }

}
