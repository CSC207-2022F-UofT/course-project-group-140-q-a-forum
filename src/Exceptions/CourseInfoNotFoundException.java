package exceptions;

public class CourseInfoNotFoundException extends RuntimeException{
    public CourseInfoNotFoundException(String err_type, String code) {
        super("The " + err_type +  " has not been found in the course " + code);
    }
}
