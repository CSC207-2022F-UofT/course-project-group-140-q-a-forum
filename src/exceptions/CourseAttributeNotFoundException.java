package exceptions;

public class CourseAttributeNotFoundException extends RuntimeException{
    public CourseAttributeNotFoundException(String attribute) {
        // General exception
        super("The " + attribute +  " of a course cannot be modified ");
    }
}
