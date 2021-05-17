package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortComparator;
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
    public void changePrice(long id, double price) {
        abstractRepository.get(id).ifPresent(facility -> facility.setPrice(price));
    }

    @Override
    public List<Facility> sortByKey(SortComparator sortComparator) {
        switch (sortComparator) {
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
    public long indexOf(Facility entity) throws NoRecordException {
        for (Facility facility : facilityRepository.getAll()) {
            if (facility.getPrice() == entity.getPrice() &&
                    facility.getName().equals(entity.getName())) {
                return facility.getId();
            }
        }
        throw new NoRecordException();
    }

}
