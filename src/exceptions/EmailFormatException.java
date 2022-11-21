package exceptions;

public class EmailFormatException extends RuntimeException{
    public EmailFormatException(String type) {
        super(type + "cannot be an email format.");
    }
}
