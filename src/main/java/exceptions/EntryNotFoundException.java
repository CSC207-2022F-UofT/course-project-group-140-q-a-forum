package exceptions;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(String entry) {
        super("The " + entry + " cannot be found!");
    }
}
