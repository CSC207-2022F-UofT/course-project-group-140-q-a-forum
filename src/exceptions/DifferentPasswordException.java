package exceptions;

public class DifferentPasswordException extends RuntimeException{
    public DifferentPasswordException(String type) {
        super("Different" + type +"from the first entry!");
    }
}

