package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.actions.ActionExecutor;
import eu.senla.JavaLab33.actions.facilities.AddFacility;
import eu.senla.JavaLab33.actions.facilities.ChangePriceOfFacility;
import eu.senla.JavaLab33.actions.facilities.DisplayFacilitiesByKey;
import eu.senla.JavaLab33.actions.rooms.*;
import eu.senla.JavaLab33.initializers.RoomDataInitializer;

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
    public void test3() {

    }
    public void test4() {

    }
    public void test5() {

    }
    public void test6() {

    }
    public void test7() {

    }
    public void test8() {

    }
    public void test9() {

    }
    public void test10() {

    }
    public void test11() {

    }
    public void test12() {

    }
    public void test13() {

    }


}
