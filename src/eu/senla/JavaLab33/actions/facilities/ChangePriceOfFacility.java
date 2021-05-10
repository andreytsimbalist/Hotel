package eu.senla.JavaLab33.actions.facilities;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.utils.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChangePriceOfFacility implements Action {
    @Autowired
    FacilityController facilityController;

    @Override
    public void execute() throws Exception {

        facilityController.getAllFacilities()
                .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));

        System.out.print("ID услуги для изменения цены: ");
        long id = ConsoleUtil.getScanner().nextLong();

        System.out.print("Новая цена услуги: ");
        double price = ConsoleUtil.getScanner().nextDouble();

        facilityController.changeFacilityPrice(id, price);
        System.out.println("\nЦена изменена.\n");

    }

}
