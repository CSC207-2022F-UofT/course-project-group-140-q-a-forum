package exceptions;

public class EmptyEntryException extends RuntimeException {
    public EmptyEntryException(String type) {
        super("Empty entry of " + type + " found.");
    }
}