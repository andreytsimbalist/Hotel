package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.memodatastorage.DataStorage;
import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;

import java.util.List;
import java.util.Optional;

public class FacilityRepositoryImpl implements FacilityRepository {

    private static FacilityRepository instance;

    public static FacilityRepository getInstance() {
        if (instance == null) {
            instance = new FacilityRepositoryImpl();
        }
        return instance;
    }

    @Override
    public long create(Facility facility) {
        return DataStorage.createFacility(facility).getId();
    }

    @Override
    public void delete(long id) throws NoRecordException {
        Facility facilityToDelete = DataStorage.getFacilities()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(NoRecordException::new);

        DataStorage.getFacilities().remove(facilityToDelete);
    }

    @Override
    public void update(Facility facility) {
        int index = DataStorage.getFacilities().indexOf(facility);
        DataStorage.getFacilities().set(index, facility);
    }

    @Override
    public Optional<Facility> get(long id) {
        return DataStorage.getFacilities()
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public List<Facility> getAll() {
        return DataStorage.getFacilities();
    }

}