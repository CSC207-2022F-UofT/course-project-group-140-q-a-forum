package exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String type) {
        super("Wrong " + type + " !");
    }
}