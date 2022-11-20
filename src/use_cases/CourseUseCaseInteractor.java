package use_cases;
import entities.Course;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;
import exceptions.*;
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
    public void registerACourse(Map<String, String> courseInfo){

        // Check if the course exists in Database.
        if (courseDataInterface.courseExists((String)
                courseInfo.get("Course Code"))){
            throw new CourseNotFoundException(courseInfo.get("Course Code"));
        }
        ArrayList instructors = extractInstructor(courseInfo.get("Instructors"));

        // Register a new course.
        Course course = new Course(courseInfo.get("Name"),
                courseInfo.get("Course Code"),
                courseInfo.get("Description"),
                courseInfo.get("Semester"),
                instructors);
        courseDataInterface.addCourse(course);
    }

    /**
     * Extract the name of the instructors in a given string.
     * @param original A string containing the name of the instructors,
     *                 separated by commas.
     * @return An array list of strings, each element is a string represented
     * the name of an instructor.
     */
    private ArrayList<String> extractInstructor(String original){
        ArrayList<String> instructors = new ArrayList<String>();

        for(String instructor: original.split(",")){
            instructors.add(instructor.strip());
        }

        return instructors;
    }

    /**
     * This removes a course from the current Database.
     * It first checks if the course exists, and removes it if so;
     * otherwise, it returns false.
     * @param courseInfo Relevant information of this course.
     * @return if successfully removed this course
     */
    public void removeACourse(Map<String, String> courseInfo){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseInfo.get("Course Code"))){
            throw new CourseNotFoundException(courseInfo.get("Course Code"));
        }

        courseDataInterface.deleteCourse(courseInfo.get("Course Code"));
    }

    /**
     * This method modifies an existing course in the database.
     * @param courseInfo Relevant information of this course.
     * @param part Which attribute of this course needs to be changed.
     * @param newPart What it needs to be changed to.
     * @return if successfully modified this course
     */
    public void modifyCourseContent(Map<String, String> courseInfo, String part, String newPart){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseInfo.get("Course Code"))){
            throw new CourseNotFoundException(courseInfo.get("Course Code"));
        }

        courseDataInterface.modifyCourseContent(courseInfo.get("Course Code"), part, newPart);
    }

    /**
     * Add an instructor to a given course. Returns true if successfully added, returns false otherwise.
     * @param course the course to be added the instructor to
     * @param instructor the instructor to be added to the course
     * @return if successfully added this instructor into this course
     */
    public void addInstructor(Course course, String instructor){
        if (course.addInstructor(instructor)){

        }
        else{
            throw new CourseInfoNotFoundException("instructor", course.getCode());
        }
    }

    /**
     * Remove an instructor from a given course. Returns true if successfully removed, returns false otherwise.
     * @param course the course to be added the instructor to
     * @param instructor the instructor to be added to the course
     * @return if successfully removed this instructor from this course
     */
    public void removeInstructor(Course course, String instructor){
        if (course.removeInstructor(instructor)){

        }
        else{
            throw new CourseInfoNotFoundException("instructor", course.getCode());
        }
    }
}

