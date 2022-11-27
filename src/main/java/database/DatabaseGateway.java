package database;

import entities.*;
import use_cases.DataBaseAccess.*;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseGateway implements CourseDataInterface, UserDataInterface, ReportDataInterface{

    final RuntimeDataHandler dataHandler;

    public DatabaseGateway() {
        this.dataHandler = new RuntimeDataHandler();
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return dataHandler.getData(1);
    }
    @Override
    public ArrayList<Course> getAllCourses() {
        return dataHandler.getData(2);
    }

    @Override
    public ArrayList<Report> getAllReport() {
        return dataHandler.getData(3);
    }

    @Override

    /**
     * Add a user<User> as a info <HashMap> into the dataHandler<HashMap>.
     * @param user
     */
    public void addUser(User user) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.addData(info);
    }

    @Override
    /**
     * Check if the user already existed in database by username<String>.
     * @param userName
     */
    public boolean userExists(String userName) {
        return dataHandler.lookupUserfromName(userName) == null;
    }

    @Override
    /**
     * Search a user by userName<String>.
     * delete the user<User> as a info <HashMap> from the dataHandler<HashMap>.
     * @param user
     */
    public void deleteUser(String username) {
        User user = dataHandler.lookupUserfromName(username);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.deleteData(info);
    }

    @Override
    /**
     * Get user<User> information by user's email, and change user's username by newUsername<String>.
     * @param user, newUsername
     */
    public void resetUsername(User user, String newUsername) {
        User user_entity = dataHandler.lookupUserfromName(user.getEmail());
        user_entity.setUsername(newUsername);
    }

    @Override
    /**
     * Get user<User> information by user's email, and change user's password by newPassword<String>.
     * @param user, newPassword
     */
    public void resetPassword(String userName, String newPassword) {
        User user_entity = dataHandler.lookupUserfromName(userName);
        user_entity.setPassword(newPassword);
    }

    @Override
    /**
     * Get course by  courseCode<String>.
     * @param courseCode
     */
    public Course getCourse(String courseCode) {
        return dataHandler.lookupCourse(courseCode);
    }

    @Override
    /**
     * Get post by  postTopic<String>, return the courseM<Course>
     * @param postTopic
     */
    public Post getPost(String courseCode, String postTopic) {
        Course course = getCourse(courseCode);
        return course.lookupPostFromTopic(postTopic);
    }

    @Override
    /**
     * Check if a post already existed in a course.
     * @param courseCode, postTopic
     * return bool
     */
    public boolean postExists(String courseCode, String postTopic) {
        Course course = getCourse(courseCode);
        ArrayList<Post> posts = course.getPosts();
        for(Post post: posts){
            if (post.getTopic().equals(postTopic)){
                return true;
            };
        }
        return false;
    }

    @Override
    /**
     * Get user by  userName<String>, return the user<User>
     * @param userName
     */
    public User getUser(String userName) {return dataHandler.lookupUserfromName(userName);}

    @Override
    /**
     * Add a course<Course> as a info <HashMap> into the dataHandler<course>.
     * @param course
     */
    public void addCourse(Course course) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    @Override
    /**
     * Search a course by courseCode<String>.
     * delete the course as a info <HashMap> from the dataHandler<HashMap>.
     * @param course
     */
    public void deleteCourse(String courseCode) {
        Course course = dataHandler.lookupCourse(courseCode);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    @Override
    /**
     * Check if a course already existed in database.
     * @param courseCode
     * return bool
     */
    public boolean courseExists(String courseCode) {
        return dataHandler.lookupCourse(courseCode) != null;
    }


    @Override
    /**
     * Add a report<Report> as a info <HashMap> into the dataHandler<course>.
     * @param report
     */
    public void addReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 3);
        info.put("data", report);
        dataHandler.addData(info);
    }

    @Override
    public ArrayList<Report> getAllReportFromType(int type) {
        return dataHandler.getAllReportFromType(type);
    }

    @Override
    /**
     * Search a report by report<Report>.
     * delete the report as a info <HashMap> from the dataHandler<HashMap>.
     * @param report
     */
    public void removeReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", report);
        dataHandler.deleteData(info);
    }

}
