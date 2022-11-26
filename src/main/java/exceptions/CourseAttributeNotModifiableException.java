package exceptions;

public class CourseAttributeNotModifiableException extends RuntimeException{
    public CourseAttributeNotModifiableException(String attribute) {
        // General exception
        super("The " + attribute +  " of a course cannot be modified ");
    }
}
