package exceptions;

public class DifferentPasswordException extends Exception{
    public DifferentPasswordException() {
        super("Different password from the first entry!");
    }
}

