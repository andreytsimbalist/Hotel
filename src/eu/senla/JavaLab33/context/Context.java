package eu.senla.JavaLab33.context;

import eu.senla.JavaLab33.entities.Hotel;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Context {
    @Getter
    @Setter
    private static Random random;

    @Getter
    @Setter
    private static Hotel hotel;
}
