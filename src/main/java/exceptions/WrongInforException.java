package exceptions;

public class WrongInforException extends RuntimeException {
    public WrongInforException(String type) {
        super("Wrong " + type + " !");
    }
}