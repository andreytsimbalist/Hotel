package eu.senla.JavaLab33.memodatastorage;

import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.model.Room;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DataStorage {

    @Getter
    @Setter
    private static long roomIdSequence;

    @Getter
    @Setter
    private static long facilityIdSequence;

    @Getter
    @Setter
    private static List<Room> rooms;

    @Getter
    @Setter
    private static List<Facility> facilities;

    private static long generateRoomId() {
        return roomIdSequence++;
    }

    private static long generateFacilityId() {
        return facilityIdSequence++;
    }

    public static Room createRoom(Room room) {
        room.setId(generateRoomId());
        rooms.add(room);
        return room;
    }

    public static Facility createFacility(Facility facility) {
        facility.setId(generateFacilityId());
        facilities.add(facility);
        return facility;
    }

}
