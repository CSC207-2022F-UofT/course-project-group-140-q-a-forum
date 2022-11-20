package use_cases;
import entities.Course;
import entities.Post;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;
import exceptions.*;


import java.util.ArrayList;
import java.util.Arrays;
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
        if (courseDataInterface.courseExists(courseInfo.get("Course Code"))){
            throw new DuplicationException("Course");
        }
        ArrayList<String> instructors = extractInstructor(courseInfo.get("Instructors"));

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
        ArrayList<String> instructors = new ArrayList<>();

        for(String instructor: original.split(",")){
            instructors.add(instructor.strip());
        }

        return instructors;
    }

    /**
     * This removes a course from the current Database.
     * It first checks if the course exists, and removes it if so;
     * otherwise, it returns false.
     * @param courseCode Course code of the course to be removed.
     * @return if successfully removed this course
     */
    public void removeACourse(String courseCode){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseCode)){
            throw new CourseNotFoundException(courseCode);
        }

        courseDataInterface.deleteCourse(courseCode);
    }

    /**
     * This method modifies an existing course in the database.
     * @param courseCode Course Code of the course to be modified.
     * @param part Which attribute of this course needs to be changed.
     * @param newPart What it needs to be changed to.
     */
    public void modifyCourseContent(String courseCode, String part, String newPart){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(courseCode)){
            throw new CourseNotFoundException(courseCode);
        }

        Course course = courseDataInterface.getCourse(courseCode);
        String[] attributes = {"name", "courseCode", "description", "semester"};

        boolean found = false;
        for (String attribute: attributes){
            if (attribute.equals(part)) {
                found = true;
                break;
            }
        }

        if (found){
            boolean success = course.modifyCourseContent(part, newPart);
            if (!success){
                throw new CourseAttributeNotFoundException(part);
            }
        }
    }

    /**
     * Add an instructor to a given course. Returns true if successfully added, returns false otherwise.
     * @param courseCode The course code of theh course to be added to.
     * @param instructor the instructor to be added to the course
     */
    public void addInstructor(String courseCode, String instructor){
        Course course = courseDataInterface.getCourse(courseCode);
        if (!course.addInstructor(instructor)){
            throw new DuplicationException("instructor");
        }
    }

    /**
     * Remove an instructor from a given course. Returns true if successfully removed, returns false otherwise.
     * @param courseCode The course code of theh course to be added to.
     * @param instructor the instructor to be added to the course
     */
    public void removeInstructor(String courseCode, String instructor){
        Course course = courseDataInterface.getCourse(courseCode);
        if (course.removeInstructor(instructor)){
            throw new CourseInfoNotFoundException("instructor", course.getCode());
        }
    }

    /**
     * Add the given post to the course with the given course code.
     * @param courseCode The course to be added in.
     * @param post The post to be added.
     */
    public void addPost(String courseCode, Post post){
        Course course = courseDataInterface.getCourse(courseCode);

        if (!course.addPost(post)){
            throw new DuplicationException("Post");
        }
    }

    /**
     * Remove the given post from the course with the given course code.
     * @param courseCode The course to be removed from.
     * @param post The post to be removed.
     */
    public void removePost(String courseCode, Post post){
        Course course = courseDataInterface.getCourse(courseCode);

        if (!course.addPost(post)){
            throw new CourseInfoNotFoundException("Post", course.getCode());
        }
    }


}

