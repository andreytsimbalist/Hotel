package eu.senla.JavaLab33.actions.facilities;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.exceptions.WrongChoiceException;
import eu.senla.JavaLab33.model.Facility;
import eu.senla.JavaLab33.utils.ConsoleUtil;

import java.util.Comparator;

public class DisplayFacilitiesByKey implements Action  {

    @Override
    public void execute() throws Exception {
        FacilityController facilityController = FacilityController.getInstance();
        System.out.print("""
                Список услуг, отсортированный по:
                1. Цене
                Ваш выбор:\s""");
        byte choice = ConsoleUtil.getScanner().nextByte();
        System.out.println();
        switch (choice){
            case 1:
                facilityController.getFacilitiesSortedByKey(Comparator.comparing(Facility::getPrice))
                        .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));
                break;
            default:
                throw new WrongChoiceException();
        }

    }

}
