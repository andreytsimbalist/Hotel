package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.data.BookingDataStorage;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.BookingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookingDataInitializer implements Initializer {

    @Autowired
    private BookingDataStorage bookingDataStorage;
    @Autowired
    private BookingController bookingController;

    @Override
    public void init() {


    }
}
