package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.BookingController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingDataInitializer implements Initializer {

    @Autowired
    private BookingController bookingController;

    @Override
    public void init() {


    }
}
