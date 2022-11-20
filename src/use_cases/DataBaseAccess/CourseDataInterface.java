package use_cases.DataBaseAccess;
import entities.Course;
import java.util.ArrayList;
import java.util.Map;


public interface CourseDataInterface extends DataInterface {
    ArrayList<Course> getData();

    Course getCourse(String courseCode);

    /**
     * add a course in DataBase
     * @param course The course to be added.
     */
    void addCourse(Course course);


    /**
     * delete a course in DataBase
     * @param courseCode The course code of the course to be deleted.
     */
    void deleteCourse(String courseCode);

    /**
     * checks if a course exists in the current database.
     * @param courseCode relevant information of the course to check existence.
     * @return if this course exists in the current database
     */
    boolean courseExists(String courseCode);

}
