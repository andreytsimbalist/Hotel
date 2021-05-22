package eu.senla.JavaLab33.exceptions;

public class NoRoomException extends Exception{

    public NoRoomException() {
        super("There is no such room.\n");
    }

}
