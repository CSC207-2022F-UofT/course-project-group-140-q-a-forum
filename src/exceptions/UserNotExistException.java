package exceptions;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String username) {
        super("The User " + username + " has not been registered.");
    }
}
