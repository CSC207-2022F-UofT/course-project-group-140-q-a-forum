package use_cases.DataBaseAccess;
import entities.Course;
import java.util.ArrayList;


public interface CourseDataInterface extends DataInterface {
    ArrayList<Course> getData();


    /**
     * add a course in DataBase
     * @param course/
     */
    void addCourse(Course course);


    /**
     * delete a course in DataBase
     * @param course/
     */
    void deleteCourse(String courseCode);
}
