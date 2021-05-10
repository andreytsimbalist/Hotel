package eu.senla.JavaLab33.initializers;

import eu.senla.JavaLab33.api.data.GuestDataStorage;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.controllers.GuestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GuestDataInitializer implements Initializer {

    @Autowired
   private GuestDataStorage guestDataStorage;

    @Autowired
    private GuestController guestController;

    @Override
    public void init() {


    }
}