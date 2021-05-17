package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityServiceImpl extends AbstractServiceImpl<Facility> implements FacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public void changeInfo(Facility facility) {
        abstractRepository.update(facility);
    }

    @Override
    public List<Facility> sortByKey(SortKey sortKey) {
        switch (sortKey) {
            case PRICE:
                return facilityRepository.getAll()
                        .stream()
                        .sorted(Comparator.comparing(Facility::getPrice))
                        .collect(Collectors.toList());
            default:
                return null;
        }
    }

    @Override
    public long indexOf(Facility entity) {
        for (Facility facility : facilityRepository.getAll()) {
            if (facility.getPrice() == entity.getPrice() &&
                    facility.getName().equals(entity.getName())) {
                return facility.getId();
            }
        }
        return facilityRepository.create(entity);
    }

}
