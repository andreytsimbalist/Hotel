package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.actions.ActionExecutor;
import eu.senla.JavaLab33.actions.bookings.AccommodateInRoom;
import eu.senla.JavaLab33.actions.rooms.EvictFromRoom;
import eu.senla.JavaLab33.actions.facilities.AddFacility;
import eu.senla.JavaLab33.actions.facilities.ChangePriceOfFacility;
import eu.senla.JavaLab33.actions.facilities.DisplayFacilitiesByKey;
import eu.senla.JavaLab33.actions.rooms.AddRoom;
import eu.senla.JavaLab33.actions.rooms.ChangePriceOfRoom;
import eu.senla.JavaLab33.actions.rooms.MakeRoomAvailable;
import eu.senla.JavaLab33.actions.rooms.RenovateRoom;

public class Tests {

    public void test1() {
        ActionExecutor.execute((new AddRoom()));
        ActionExecutor.execute((new ChangePriceOfRoom()));
        ActionExecutor.execute((new RenovateRoom()));
        ActionExecutor.execute((new AccommodateInRoom()));
        ActionExecutor.execute((new EvictFromRoom()));
        ActionExecutor.execute((new MakeRoomAvailable()));
    }
    public void test2() {
        ActionExecutor.execute((new DisplayFacilitiesByKey()));
        ActionExecutor.execute((new AddFacility()));
        ActionExecutor.execute((new ChangePriceOfFacility()));
    }

}
