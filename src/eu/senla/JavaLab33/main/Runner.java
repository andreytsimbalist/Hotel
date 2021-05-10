package eu.senla.JavaLab33.main;

import eu.senla.JavaLab33.initializers.FacilityDataInitializer;
import eu.senla.JavaLab33.api.initializers.Initializer;
import eu.senla.JavaLab33.initializers.RoomDataInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan("eu.senla.JavaLab33")
public class Runner {

    public static void main(String[] args) {

        SpringApplication.run(Runner.class,args);
        Tests test = new Tests();
        test.test1();
        test.test2();
    }

}
