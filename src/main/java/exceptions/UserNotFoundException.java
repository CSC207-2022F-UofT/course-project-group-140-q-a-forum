package exceptions;

public class UserNotFoundException extends RuntimeException{
    public  UserNotFoundException(String type) {
        super("No such " + type + " exists, please check your spell or Register First !");
    }
}
