package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.dto.GuestDto;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Guest;

import java.util.List;

public interface GuestService{

    GuestDto create(Guest entity);

    List<GuestDto> getAll();

    GuestDto getById(Long id) throws NoRecordException;

}
