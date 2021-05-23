package eu.senla.JavaLab33.api.services;

import eu.senla.JavaLab33.dto.RoomDto;
import eu.senla.JavaLab33.exceptions.NoRecordException;
import eu.senla.JavaLab33.model.Room;
import eu.senla.JavaLab33.model.enums.FilterKey;
import eu.senla.JavaLab33.model.enums.RoomStatus;
import eu.senla.JavaLab33.model.enums.SortKey;

import java.util.List;

public interface RoomService {

    RoomDto create(Room entity);

    RoomDto getById(Long id) throws NoRecordException;

    List<RoomDto> getAll();

    void changeInfo(Room room);

    List<RoomDto> getRoomsFilterByKey(FilterKey filterKey, Integer capacity, RoomStatus roomStatus);

    List<RoomDto> sortFreeByKey(SortKey sortKey);

    List<RoomDto> sortByKey(SortKey sortKey);

    Integer numberOfFreeRooms();

}
