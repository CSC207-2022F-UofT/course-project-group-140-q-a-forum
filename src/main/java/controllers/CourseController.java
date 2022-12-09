package controllers;

import entities.Course;
import entities.Post;
import entities.User;
import exceptions.DuplicationException;
import exceptions.EmptyEntryException;
import exceptions.NotFoundException;
import exceptions.WrongInfoException;
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
     * @param user the user
     * @param course The course to be deleted.
     * @return An integer indicating whether the course has been
     * deleted successfully.
     * 0: The current user is not an admin and has no right to delete a course;
     * 1: The course has been deleted successfully.
     */
    public int removeCourse(User user, Course course){
        /*
         * For admin use
         */

        if (!user.isAdmin()){
            return 0;
        }

        courseInteractor.removeACourse(course);
        return 1;
    }

    /**
     * Modify a course.
     * @param user the user
     * @param course The course
     * @param info Which attribute of this course needs to be changed and what it needed to
     *             be changed two, marked by "where" and "what.
     * @return An integer representing the state of modifying this course.
     * 1: Successfully modified;
     * 0: The user is not an admin so cannot modify this course;
     * -1: The course with this course code is not found;
     * -2: The input part does not correspond to an attribute of the course that can
     * be modified.
     */
    public int modifyCourse(User user, Course course, HashMap<String, String> info){
        /*
         * For admin use
         */

        if (!user.isAdmin()){
            //Call presenter
            return 0;
        }

        try{
            courseInteractor.modifyCourseContent(course, info);
        }
        catch(NotFoundException e){
            //Call presenter
            return -1;
        }catch(WrongInfoException e){
            //Call presenter
            return -2;
        }
        return 1;
    }

    /**
     * Add an instructor to the course.
     * @param course The course
     * @param instructor The name of the instructor.
     * @return An integer representing the result of the method.
     * 1: Successfully added;
     * -1: The instructor is already in this course.
     */
    public int addInstructor(Course course, String instructor){
        /*
            For admin use
         */
        try{courseInteractor.addInstructor(course, instructor);}
        catch(DuplicationException e){
            //Call presenter
            return -1;
        }

        return 1;
    }

    /**
     * Remove an instructor from the course.
     * @param user the user
     * @param course The course.
     * @param instructor The name of the instructor.
     * @return An integer representing the result of the method.
     * 1: Successfully removed;
     * 0: The user is not an admin so cannot remove this post;
     * -1: The instructor is not found in this course.
     */
    public int removeInstructor(User user, Course course, String instructor){

        /*
         * For admin use
         */

        if (!user.isAdmin()){
            //Call presenter
            return 0;
        }
        try{courseInteractor.removeInstructor(course, instructor);}
        catch(NotFoundException e){
            //Call presenter
            return -1;
        }

        return 1;
    }

    /**
     * Remove a post from the course with given course code.
     * @param user the user
     * @param post the post wanted to be deleted.
     * @return An integer representing the state of the post.
     * 1: Successfully removed;
     * 0: The user is not an admin so cannot remove this post;
     * -1: The course with given course code is not found;
     */
    public int removePost(User user, Post post){
        /*
            For admin use
         */
        if (!user.isAdmin()){
            //Call presenter
            return 0;
        }

        try{courseInteractor.removePost(post);}
        catch(NotFoundException e){
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
     * @param course The course
     * @return If the course is not found, then return an empty ArrayList, otherwise, return an array list
     * of the posts of the given course.
     */
    public ArrayList<Post> getAllPosts(Course course){
        try{return courseInteractor.getAllPosts(course);}
        catch(NotFoundException e){
            //call presenter
            return new ArrayList<>();
        }
    }



    public ArrayList<String> getAllCoursesName(){
        return courseInteractor.getAllCoursesName();
    }

    public ArrayList<String> getAllPostTitles(Course course){
        return courseInteractor.getAllPostTitles(course);
    }
}