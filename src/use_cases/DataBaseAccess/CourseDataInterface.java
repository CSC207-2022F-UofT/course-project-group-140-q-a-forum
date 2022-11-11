package use_cases.DataBaseAccess;
import src.entities.Course;
import java.util.ArrayList;


public interface CourseDataInterface extends DataInterface {
    ArrayList<Course> getData();

    void addCourse(Course course);

    void deleteCourse(String courseCode);
}
