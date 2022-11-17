package use_cases;
import entities.Course;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;
import java.util.Date;


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
     * @return if successfully registered this student
     */
    public boolean registerACourse(Map<String, Object> courseInfo){

        // Check if the course exists in Database.
        if (courseDataInterface.courseExists(courseInfo)){return false;}

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
     * @return if successfully removed this course
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
     * @return if successfully modified this course
     */
    public boolean modifyCourseContent(Map<String, Object> courseInfo, String part, String newPart){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseInfo)){return false;}

        courseDataInterface.modifyCourseContent(courseInfo, part, newPart);
        return true;
    }

    /**
     * Add a student to a given course. Returns true if successfully added, returns false otherwise.
     * @param course the course to be added the student to
     * @param student the student to be added to the course
     * @return if successfully added this student into this course
     */
    public boolean addStudent(Course course, User student){
        return course.addStudent(student);
    }

    /**
     * Remove a student from a given course. Returns true if successfully removed, returns false otherwise.
     * @param course the course to be added the student to
     * @param student the student to be added to the course
     * @return if successfully removed this student from this course
     */
    public boolean removeStudent(Course course, User student){
        return course.removeStudent(student);
    }

    /**
     * Add an instructor to a given course. Returns true if successfully added, returns false otherwise.
     * @param course the course to be added the instructor to
     * @param instructor the instructor to be added to the course
     * @return if successfully added this instructor into this course
     */
    public boolean addInstructor(Course course, String instructor){
        return course.addInstructor(instructor);
    }

    /**
     * Remove an instructor from a given course. Returns true if successfully removed, returns false otherwise.
     * @param course the course to be added the instructor to
     * @param instructor the instructor to be added to the course
     * @return if successfully removed this instructor from this course
     */
    public boolean removeInstructor(Course course, String instructor){
        return course.removeInstructor(instructor);
    }
}

