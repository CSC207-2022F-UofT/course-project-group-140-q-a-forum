package use_cases;
import entities.Course;
import entities.Post;
import use_cases.DataBaseAccess.CourseDataInterface;
import exceptions.*;


import java.io.IOException;
import java.util.*;

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
     */
    public void registerACourse(Map<String, String> courseInfo){

        // Check if the course exists in Database.
        if (courseDataInterface.courseExists(courseInfo.get("Course Code"))){
            throw new DuplicationException("Course");
        }

        for (String part: courseInfo.keySet()){
            if (courseInfo.get(part).equals("")){
                throw new EmptyEntryException(courseInfo.get(part));
            }
        }
        ArrayList<String> instructors = extractInstructor(courseInfo.get("Instructors"));

        // Register a new course.
        Course course = new Course(courseInfo.get("Name"),
                courseInfo.get("Course Code"),
                courseInfo.get("Description"),
                courseInfo.get("Semester"),
                instructors);
        courseDataInterface.addCourse(course);
        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
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
     * @param course Course to be removed
     */
    public void removeACourse(Course course){
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(course.getCode())){
            throw new NotFoundException("The course "+ course.getCode());
        }

        courseDataInterface.deleteCourse(course);
    }

    /**
     * This method modifies an existing course in the database.
     * @param course The course
     * @param info Which attribute of this course needs to be changed and what it needed to
     *             be changed two, marked by "where" and "what.
     */
    public void modifyCourseContent(Course course, HashMap<String, String> info){
        String part = info.get("where");
        String newPart = info.get("what");
        // if the given course does not exist in the database, return false.
        if (!courseDataInterface.courseExists(course.getCode())){
            throw new NotFoundException("The course "+ course.getCode());
        }

        boolean success = course.modifyCourseContent(part, newPart);
        if (!success) {
            throw new WrongInfoException(part);
        }


        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    /**
     * Add an instructor to a given course. Returns true if successfully added, returns false otherwise.
     * @param course The course
     * @param instructor the instructor to be added to the course
     */
    public void addInstructor(Course course, String instructor){
        if (!course.addInstructor(instructor)){
            throw new DuplicationException("instructor");
        }

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Remove an instructor from a given course. Returns true if successfully removed, returns false otherwise.
     * @param course The course to  remove.
     * @param instructor the instructor to be added to the course
     */
    public void removeInstructor(Course course, String instructor){
        if (!course.removeInstructor(instructor)){
            throw new NotFoundException("Instructor in " + course.getCode());
        }

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Remove the given post from the course with the given course code.
     * @param post The post to be removed.
     */
    public void removePost(Post post){
        Course course = post.getCourse();

        if (!course.removePost(post)){
            throw new NotFoundException("Post");
        }

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * A method that returns all the courses in the current database.
     * @return An arraylist consists of all the courses in the database.
     */
    public ArrayList<Course> getAllCourses(){
        return courseDataInterface.getAllCourses();
    }

    /**
     * Get the names of all courses that are currently in database.
     * @return An arraylist containing the names of the courses.
     */
    public ArrayList<String> getAllCoursesName(){
        ArrayList<Course> courses = courseDataInterface.getAllCourses();
        ArrayList<String> coursesName = new ArrayList<>();
        for (Course course : courses) {
            coursesName.add(course.getName());
        }
        return coursesName;
    }

    /**
     * Get all posts of the course with the given course code.
     * @param course The course code
     * @return An arraylist of posts that are under this course.
     */
    public ArrayList<Post> getAllPosts(Course course){
        return course.getPosts();
    }

    /**
     * Get all titles of posts under the course with the given course code.
     * @param course The course
     * @return An arraylist of strings that represent the titles of the posts.
     */
    public ArrayList<String> getAllPostTitles(Course course){
        if (!courseDataInterface.courseExists(course.getCode())){
            throw new NotFoundException("The course "+ course.getCode());
        }

        Post[] posts = course.getPosts().toArray(new Post[0]);
        ArrayList<String> postName = new ArrayList<>();
        for(Post post: posts){
            postName.add(post.getTopic());
        }
        return postName;
    }
}

