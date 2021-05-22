package eu.senla.JavaLab33.exceptions;

public class WrongChoiceException extends Exception {

    public WrongChoiceException() {
        super("There is no such item.\n");
    }

}
