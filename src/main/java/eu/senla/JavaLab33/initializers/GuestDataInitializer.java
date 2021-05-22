package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.GuestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestDataInitializer implements Initializer {

    @Autowired
    private GuestController guestController;

    @Override
    public void init() {


    }
}