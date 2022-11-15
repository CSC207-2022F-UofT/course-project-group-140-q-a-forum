package use_cases;
import entities.Course;
import use_cases.DataBaseAccess.CourseDataInterface;
import java.util.Date;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class CourseUseCaseInteractor {
    final CourseDataInterface courseDataInterface;

    public CourseUseCaseInteractor(CourseDataInterface courseDataInterface) {
        this.courseDataInterface = courseDataInterface;
    }

    /**
     * Register a course if this is not present in the current database.
     * Returns true if successfully registered, returns false otherwise.
     * @param courseInfo This is a Map that contains necessary information
     *                   needed to register a course. The keys must be
     *                   "Name", "Course Code", "Description", "Semester",
     *                   and "Instructors".
     * @return boo
     */
    public boolean registerACourse(Map<String, Object> courseInfo){

        // Check if the course exists in Database.
        boolean found = courseDataInterface.courseExists(courseInfo);

        if (found){return false;}

        // Register a new course.
        Course course = new Course((String) courseInfo.get("Name"),
                (String) courseInfo.get("Course Code"),
                (String) courseInfo.get("Description"),
                (Date[] )courseInfo.get("Semester"),
                (ArrayList<String>) courseInfo.get("Instructors"));
        courseDataInterface.addCourse(course);
        return true;
    }

    /**
     * This removes a course from the current Database.
     * It first checks if the course exists, and removes it if so;
     * otherwise, it returns false.
     * @param courseInfo Relevant information of this course.
     * @return boo
     */
    public boolean removeACourse(Map<String, Object> courseInfo){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseInfo)){return false;}

        courseDataInterface.deleteCourse((String) courseInfo.get("Course Code"));
        return true;
    }

    /**
     * This method modifies an existing course in the database.
     * @param courseInfo Relevant information of this course.
     * @param part Which attribute of this course needs to be changed.
     * @param newPart What it needs to be changed to.
     * @return boo
     */
    public boolean modifyCourseContent(Map<String, Object> courseInfo, String part, String newPart){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseInfo)){return false;}

        courseDataInterface.modifyCourseContent(courseInfo, part, newPart);
        return true;
    }
}

