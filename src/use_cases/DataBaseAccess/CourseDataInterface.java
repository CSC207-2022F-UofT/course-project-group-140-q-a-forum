package use_cases.DataBaseAccess;
import entities.Course;
import java.util.ArrayList;
import java.util.Map;


public interface CourseDataInterface extends DataInterface {
    ArrayList<Course> getData();


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
     * @param courseInfo relevant information of the course to check existence.
     * @return if this course exists in the current database
     */
    boolean courseExists(Map<String, Object> courseInfo);

    /**
     * modifies content of an existing course.
     * @param courseInfo relevant information needed to check for course content.
     * @param part the part of the course needed to be modified.
     * @param newPart the content of the part that needs to be modified to.
     */
    void modifyCourseContent(Map<String, Object> courseInfo, String part, String newPart);
}
