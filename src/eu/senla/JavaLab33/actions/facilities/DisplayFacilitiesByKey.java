package eu.senla.JavaLab33.actions.facilities;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class DisplayFacilitiesByKey implements Action {
    @Autowired
    FacilityController facilityController;

    @Override
    public void execute() throws Exception {
        System.out.print("\nСписок услуг, отсортированный по:\n1. Цене\nВаш выбор: ");
        byte choice = ConsoleUtil.getScanner().nextByte();
        System.out.println();
        switch (choice) {
            case 1:
                facilityController.getFacilitiesSortedByKey(Comparator.comparing(Facility::getPrice))
                        .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));
                break;
            default:
                throw new WrongChoiceException();
        }

    }

}
