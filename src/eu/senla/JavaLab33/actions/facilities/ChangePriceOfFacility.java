package eu.senla.JavaLab33.actions.facilities;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class ChangePriceOfFacility implements Action {

    @Override
    public void execute() throws Exception {

        FacilityController facilityController = FacilityController.getInstance();
        facilityController.getAllFacilities()
                .forEach(facility -> facilityController.displayFacilityInfo(facility.getId()));

        System.out.print("ID услуги для изменения цены: ");
        long id = ConsoleUtil.getScanner().nextLong();

        System.out.print("Новая цена услуги: ");
        double price = ConsoleUtil.getScanner().nextDouble();
        System.out.println();

        facilityController.changeFacilityPrice(id, price);
        System.out.println("Цена изменена.\n");

    }

}
