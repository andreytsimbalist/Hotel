package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.dto.BookingDto;
import eu.senla.JavaLab33.dto.FacilityDto;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Booking;
import eu.senla.JavaLab33.model.enums.SortKey;

import java.util.List;

public interface BookingService{

    BookingDto create(Booking booking);

    BookingDto getById(Long id) throws NoRecordException;

    List<BookingDto> getAll();

    List<FacilityDto> facilitySortedByKey(Long id, SortKey sortKey) throws NoRecordException;

    List<BookingDto> sortByKey(SortKey sortKey);
}
