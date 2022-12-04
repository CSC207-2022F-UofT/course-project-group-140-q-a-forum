package exceptions;

public class DifferentPasswordException extends Exception{
    public DifferentPasswordException(String type) {
        super("Different" + type +"from the first entry!");
    }
}

