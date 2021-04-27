package eu.senla.JavaLab33.exceptions;

public class NoRecordException extends Exception {

    public NoRecordException() {
        super("No Record by your criteria exists in Data Storage.\n");
    }
}
