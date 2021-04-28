package eu.senla.JavaLab33.services;

import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.api.services.FacilityService;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.repositories.FacilityRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FacilityServiceImpl implements FacilityService {

    private FacilityRepository facilityRepository;
    private static FacilityService instance;

    private FacilityServiceImpl() {
        this.facilityRepository = FacilityRepositoryImpl.getInstance();
    }

    public static FacilityService getInstance() {
        if(instance == null) {
            instance = new FacilityServiceImpl();
        }
        return instance;
    }

    @Override
    public long create(Facility facility) {
        return facilityRepository.create(facility);
    }

    @Override
    public void delete(long id) throws NoRecordException {
        facilityRepository.delete(id);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.update(facility);
    }

    @Override
    public Facility get(long id) throws NoRecordException {
        return facilityRepository.get(id).orElseThrow(NoRecordException::new);
    }

    @Override
    public List<Facility> getAll() {
        return facilityRepository.getAll();
    }

    @Override
    public void displayInfo(long id) {
        facilityRepository.get(id).ifPresent(System.out::println);
    }

    @Override
    public void changePrice(long id, double price) {
        facilityRepository.get(id).ifPresent(facility -> facility.setPrice(price));
    }

    @Override
    public List<Facility> sortByPrice() {
        return facilityRepository.getAll()
                .stream()
                .sorted(Comparator.comparing(Facility::getPrice))
                .collect(Collectors.toList());
    }
}
