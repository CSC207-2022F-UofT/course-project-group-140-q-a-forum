package exceptions;

public class PasswordDoesNotMatchException extends RuntimeException{
    public PasswordDoesNotMatchException() {
        super("The password you entered do not match!");
    }
}
