package eu.senla.JavaLab33.controllers;

import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/facilities")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping("/all")
    public List<Facility> getAllFacilities() {
        return facilityService.getAll();
    }

    @PutMapping
    public void changeFacilityInfo(@RequestBody Facility facility) {
        facilityService.changeInfo(facility);
    }

    @GetMapping("/sort")
    public List<Facility> getFacilitiesSortedByKey(@RequestParam SortKey key) {
        return facilityService.sortByKey(key);
    }

    @PostMapping("/create")
    public long createFacility(@RequestBody Facility facility) {
        return facilityService.indexOf(facility);
    }

    @GetMapping("/{id}")
    public Facility getFacilityById(@PathVariable long id) throws NoRecordException {
        return facilityService.get(id);
    }

}
