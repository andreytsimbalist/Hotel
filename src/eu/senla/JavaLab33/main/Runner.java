package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.actions.ActionExecutor;
import eu.senla.JavaLab33.actions.rooms.AccommodateInRoom;
import eu.senla.JavaLab33.controllers.RoomController;
import eu.senla.JavaLab33.initializers.FacilityDataInitializer;
import eu.senla.JavaLab33.initializers.Initializer;
import eu.senla.JavaLab33.initializers.RoomDataInitializer;
import eu.senla.JavaLab33.utils.GenerationUtil;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Initializer> initializers = Arrays.asList(
                new RoomDataInitializer(),
                new FacilityDataInitializer()
        );

        initializers.forEach(Initializer::init);



        ActionExecutor.execute(new AccommodateInRoom());

    }

}
