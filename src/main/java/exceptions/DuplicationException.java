package exceptions;

public class DuplicationException extends RuntimeException{
    public DuplicationException(String type) {
        super("Duplicate " + type + " found.");
    }
}
