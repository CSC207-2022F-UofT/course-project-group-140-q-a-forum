package controllers;

import entities.Course;
import entities.Post;
import exceptions.*;

import use_cases.CourseUseCaseInteractor;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseController {
    private final CourseUseCaseInteractor courseInteractor;

    public CourseController(CourseUseCaseInteractor courseInteractor) {
        this.courseInteractor = courseInteractor;
    }

    /**
     * Register a course.
     * @param courseInfo This is a Map that contains necessary information
     *                   needed to register a course. The keys must be
     *                   "Name", "Course Code", "Description", "Semester",
     *                   and "Instructors".
     * @return An integer indicating if successfully registered.
     * 1: Successfully registered.
     * -1: There is already a course with the same course code.
     * -2: There is an empty entry.
     */
    public int registerCourse(HashMap<String, String> courseInfo){
        try{courseInteractor.registerACourse(courseInfo);}
        catch(DuplicationException e){
            // Call some presenter
            return -1;
        }catch(EmptyEntryException e){
            //Call some presenter
            return -2;
        }
        return 1;
    }

    /**
     * Delete a course.
     * @param isAdmin Whether the user taking action is an admin.
     * @param courseCode The course to be deleted.
     * @return An integer indicating whether the course has been
     * deleted successfully.
     * 0: The current user is not an admin and has no right to delete a course;
     * 1: The course has been deleted successfully.
     */
    public int removeCourse(boolean isAdmin, String courseCode){
        if (!isAdmin){
            //Call presenter
            return 0;
        }

        courseInteractor.removeACourse(courseCode);
        return 1;
    }

    /**
     * Modify a course.
     * @param isAdmin Whether the user is an admin.
     * @param courseCode The course code of the course needs to be modified.
     * @param part The part of the course to be modified.
     * @param changeTo The content of the part to be changed to.
     * @return An integer representing the state of modifying this course.
     * 1: Successfully modified;
     * 0: The user is not an admin so cannot modify this course;
     * -1: The course with this course code is not found;
     * -2: The input part does not correspond to an attribute of the course that can
     * be modified.
     */
    public int modifyCourse(boolean isAdmin, String courseCode,
                            String part, String changeTo){
        if (!isAdmin){
            //Call presenter
            return 0;
        }

        try{courseInteractor.modifyCourseContent(courseCode, part, changeTo);}
        catch(CourseNotFoundException e){
            //Call presenter
            return -1;
        }catch(CourseAttributeNotModifiableException e){
            //Call presenter
            return -2;
        }
        return 1;
    }

    /**
     * Add an instructor to the course.
     * @param courseCode The course code of the course.
     * @param instructor The name of the instructor.
     * @return An integer representing the result of the method.
     * 1: Successfully added;
     * -1: The instructor is already in this course.
     */
    public int addInstructor(String courseCode, String instructor){
        try{courseInteractor.addInstructor(courseCode, instructor);}
        catch(DuplicationException e){
            //Call presenter
            return -1;
        }

        return 1;
    }

    /**
     * Remove an instructor from the course.
     * @param isAdmin If the user is an admin.
     * @param courseCode The course code of the course.
     * @param instructor The name of the instructor.
     * @return An integer representing the result of the method.
     * 1: Successfully removed;
     * 0: The user is not an admin so cannot remove this post;
     * -1: The instructor is not found in this course.
     */
    public int removeInstructor(boolean isAdmin, String courseCode, String instructor){
        if (!isAdmin){
            //Call presenter
            return 0;
        }
        try{courseInteractor.removeInstructor(courseCode, instructor);}
        catch(CourseInfoNotFoundException e){
            //Call presenter
            return -1;
        }

        return 1;
    }

    /**
     * Remove a post from the course with given course code.
     * @param isAdmin If the user is an admin.
     * @param courseCode The course code of the course.
     * @param post the post wanted to be deleted.
     * @return An integer representing the state of the post.
     * 1: Successfully removed;
     * 0: The user is not an admin so cannot remove this post;
     * -1: The course with given course code is not found;
     */
    public int removePost(boolean isAdmin, String courseCode, Post post){
        if (!isAdmin){
            //Call presenter
            return 0;
        }

        try{courseInteractor.removePost(courseCode, post);}
        catch(CourseInfoNotFoundException e){
            return -1;
        }
        return 1;
    }

    /**
     * Return all the courses.
     * @return An arraylist consists of all the courses.
     */
    public ArrayList<Course> getAllCourses(){
        return courseInteractor.getAllCourses();
    }

    /**
     * Get all posts of the course with given course code
     * @param courseCode The course code of the given course
     * @return If the course is not found, then return an empty ArrayList, otherwise, return an array list
     * of the posts of the given course.
     */
    public ArrayList<Post> getAllPosts(String courseCode){
        try{return courseInteractor.getAllPosts(courseCode);}
        catch(CourseNotFoundException e){
            //call presenter
            return new ArrayList<>();
        }
    }
}
