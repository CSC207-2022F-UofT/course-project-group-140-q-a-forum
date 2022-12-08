package use_cases.DataBaseAccess;
import entities.Course;
import entities.Post;

import java.util.ArrayList;


public interface CourseDataInterface extends DataInterface {
    ArrayList<Course> getAllCourses();

    Course getCourse(String courseCode);

    /**
     * For later search functions.
     * Perform search to f etch the post from topic.
     * @param course The course to search the post
     * @param postTopic The post topipc
     * @return The post iteself
     */
    Post getPost(Course course, String postTopic);

    /**
     * add a course in DataBase
     * @param course The course to be added.
     */
    void addCourse(Course course);


    /**
     * delete a course in DataBase
     * @param course The course code of the course to be deleted.
     */
    void deleteCourse(Course course);

    /**
     * checks if a course exists in the current database.
     * @param courseCode relevant information of the course to check existence.
     * @return if this course exists in the current database
     */
    boolean courseExists(String courseCode);

    boolean postExists(Course course, String postTopic);


}
