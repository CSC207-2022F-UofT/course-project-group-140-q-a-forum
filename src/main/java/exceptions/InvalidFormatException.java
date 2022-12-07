package exceptions;

public class InvalidFormatException extends RuntimeException {
    public InvalidFormatException(String type) {
        super("The " + type + " is not formatted correctly.");
    }
}