package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.initializers.FacilityDataInitializer;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.initializers.RoomDataInitializer;

import java.util.Arrays;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Initializer> initializers = Arrays.asList(
                new RoomDataInitializer(),
                new FacilityDataInitializer()
        );

        initializers.forEach(Initializer::init);

        Tests test = new Tests();
        test.test1();
        test.test2();
    }

}
