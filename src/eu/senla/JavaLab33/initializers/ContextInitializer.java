package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.context.Context;
import eu.senla.JavaLab33.entities.Hotel;

import java.util.Random;

public class ContextInitializer {
    public static void initContext() {
        Context.setRandom(new Random());
        Context.setHotel(new Hotel());
    }
}
