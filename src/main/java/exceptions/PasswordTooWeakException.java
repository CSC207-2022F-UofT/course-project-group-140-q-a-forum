package exceptions;

public class PasswordTooWeakException extends RuntimeException{
    public PasswordTooWeakException() {
        super("The password is too weak!");
    }
}
