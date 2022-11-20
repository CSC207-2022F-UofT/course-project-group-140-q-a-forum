package exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String code) {
        super("The courses " + code + " has not been registered.");
    }
}
