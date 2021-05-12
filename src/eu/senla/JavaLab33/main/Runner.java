package eu.senla.JavaLab33.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("eu.senla.JavaLab33")
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class,args);
    }

}
