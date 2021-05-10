package eu.senla.JavaLab33.repositories;

import eu.senla.JavaLab33.api.data.FacilityDataStorage;
import eu.senla.JavaLab33.api.repositories.FacilityRepository;
import eu.senla.JavaLab33.memodatastorage.FacilityDataStorageImpl;
import eu.senla.JavaLab33.model.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacilityRepositoryImpl extends AbstractRepositoryImpl<Facility> implements FacilityRepository {


    @Autowired
    private FacilityDataStorage facilityDataStorage;



}