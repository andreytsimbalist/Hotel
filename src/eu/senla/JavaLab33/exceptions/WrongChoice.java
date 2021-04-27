package eu.senla.JavaLab33.exceptions;

public class WrongChoice extends Exception {

    public WrongChoice() {
        super("There is no such item.\n");
    }

}
