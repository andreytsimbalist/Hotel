package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.actions.ActionExecutor;
import eu.senla.JavaLab33.actions.bookings.AccommodateInRoom;
import eu.senla.JavaLab33.actions.facilities.AddFacility;
import eu.senla.JavaLab33.actions.facilities.ChangePriceOfFacility;
import eu.senla.JavaLab33.actions.facilities.DisplayFacilitiesByKey;
import eu.senla.JavaLab33.actions.rooms.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Tests {

    @Autowired
    private AddRoom addRoom;
    @Autowired
    private ChangePriceOfRoom changePriceOfRoom;
    @Autowired
    private ChangePriceOfFacility changePriceOfFacility;
    @Autowired
    private RenovateRoom renovateRoom;
    @Autowired
    private AccommodateInRoom accommodateInRoom;
    @Autowired
    private EvictFromRoom evictFromRoom;
    @Autowired
    private MakeRoomAvailable makeRoomAvailable;
    @Autowired
    private DisplayFacilitiesByKey displayFacilitiesByKey;
    @Autowired
    private AddFacility addFacility;

    @Bean
    public void test() {
        ActionExecutor.execute(addRoom);
        ActionExecutor.execute(changePriceOfRoom);
        ActionExecutor.execute(renovateRoom);
        ActionExecutor.execute(accommodateInRoom);
        ActionExecutor.execute(evictFromRoom);
        ActionExecutor.execute(makeRoomAvailable);
        ActionExecutor.execute(displayFacilitiesByKey);
        ActionExecutor.execute(addFacility);
        ActionExecutor.execute(changePriceOfFacility);
    }

}
