package eu.senla.JavaLab33.utils;


import java.util.Random;

public class GenerationUtil {

    private static final Random random = new Random();

    public static Random getRandom() {
        return random;
    }

    public static double generatePrice(int min, int max) {
        return Math.ceil(random.nextDouble() * (max - min) + min);
    }

}
