package eu.senla.JavaLab33.actions.facilities;

import eu.senla.JavaLab33.actions.Action;
import eu.senla.JavaLab33.controllers.FacilityController;
import eu.senla.JavaLab33.utils.ConsoleUtil;

public class AddFacility implements Action {

    @Override
    public void execute() throws Exception {

        FacilityController facilityController = FacilityController.getInstance();

        System.out.println("Данные новой услуги.");
        System.out.print("Название: ");
        String name = ConsoleUtil.getScanner().next();
        System.out.print("Цена: ");
        double price = ConsoleUtil.getScanner().nextDouble();

        facilityController.createFacility(name, price);
        System.out.println("Услуга добавлена.\n");
    }

}
