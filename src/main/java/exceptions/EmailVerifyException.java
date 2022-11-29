package exceptions;

public class EmailVerifyException extends RuntimeException{



    public EmailVerifyException(String type) { super("Wrong " + type + " verify code");}


}
