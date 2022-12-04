package exceptions;

public class WrongInfoException extends RuntimeException {
    public WrongInfoException(String type) {
        super("Wrong " + type + " !");
    }
}