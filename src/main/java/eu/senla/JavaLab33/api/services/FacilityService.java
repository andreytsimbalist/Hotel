package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.dto.FacilityDto;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.enums.SortKey;

import java.util.List;

public interface FacilityService{

    FacilityDto create(Facility entity);

    FacilityDto getById(Long id) throws NoRecordException;

    List<FacilityDto> getAll();

    void changeInfo(Facility facility);

    List<FacilityDto> sortByKey(SortKey sortKey);

}
