package exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String type) {
        super(type + " not found!");
    }
}
