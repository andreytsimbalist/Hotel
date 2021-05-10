package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.initializers.BookingDataInitializer;
import eu.senla.JavaLab33.initializers.FacilityDataInitializer;
import eu.senla.JavaLab33.initializers.GuestDataInitializer;
import eu.senla.JavaLab33.initializers.RoomDataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private FacilityDataInitializer facilityDataInitializer;
    @Autowired
    private RoomDataInitializer roomDataInitializer;
    @Autowired
    private GuestDataInitializer guestDataInitializer;
    @Autowired
    private BookingDataInitializer bookingDataInitializer;
    @Bean
    public void init(){
        List<Initializer> initializers = Arrays.asList(
                roomDataInitializer,
                facilityDataInitializer,
                guestDataInitializer,
                bookingDataInitializer
        );

        initializers.forEach(Initializer::init);
    }

}
