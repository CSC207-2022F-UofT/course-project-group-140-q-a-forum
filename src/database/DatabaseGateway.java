package database;

import entities.*;
import use_cases.DataBaseAccess.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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


    /**
     * Add a user<User> as a info <HashMap> into the dataHandler<HashMap>.
     * @param User user
     */
    @Override
    public void addUser(User user) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.addData(info);
    }
    /**
     * Check if the user already existed in database by username<String>.
     * @param String userName
     */
    @Override
    public boolean userExists(String userName) {
        return dataHandler.lookupUserfromName(userName) == null;
    }

    @Override
    /**
     * Search a user by userName<String>.
     * delete the user<User> as a info <HashMap> from the dataHandler<HashMap>.
     * @param String username
     */
    public void deleteUser(String username) {
        User user = dataHandler.lookupUserfromName(username);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.deleteData(info);
    }
    /**
     * Get user<User> information by user's email, and change user's username by newUsername<String>.
     * @param User user, String newUsername
     */
    @Override
    public void resetUsername(User user, String newUsername) {
        User user_entity = dataHandler.lookupUserfromName(user.getEmail());
        user_entity.setUsername(newUsername);
    }
    /**
     * Get user<User> information by user's email, and change user's password by newPassword<String>.
     * @param String userName, String newPassword
     */
    @Override
    public void resetPassword(String userName, String newPassword) {
        User user_entity = dataHandler.lookupUserfromName(userName);
        user_entity.setPassword(newPassword);
    }
    /**
     * Get course by  courseCode<String>.
     * @param String courseCode
     */
    @Override
    public Course getCourse(String courseCode) {
        return dataHandler.lookupCourse(courseCode);
    }


    /**
     * Get post by  postTopic<String>, return the courseM<Course>
     * @param String courseCode, String postTopic
     */
    @Override
    public Post getPost(String courseCode, String postTopic) {
        Course course = getCourse(courseCode);
        return course.lookupPostFromTopic(postTopic);
    }

    /**
     * Check if a post already existed in a course.
     * @param String courseCode, String postTopic
     */
    @Override

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
    /**
     * Get user by  userName<String>, return the user<User>
     * @param String userName
     */
    @Override
    public User getUser(String userName) {return dataHandler.lookupUserfromName(userName);}

    /**
     * Add a course<Course> as a info <HashMap> into the dataHandler<course>.
     * @param Course course
     */
    @Override
    public void addCourse(Course course) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    /**
     * Search a course by courseCode<String>.
     * delete the course as a info <HashMap> from the dataHandler<HashMap>.
     * @param String courseCode
     */
    @Override
    public void deleteCourse(String courseCode) {
        Course course = dataHandler.lookupCourse(courseCode);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }
    /**
     * Check if a course already existed in database.
     * @param String courseCode
     */
    @Override
    public boolean courseExists(String courseCode) {
        return dataHandler.lookupCourse(courseCode) != null;
    }


    /**
     * Add a report<Report> as a info <HashMap> into the dataHandler<course>.
     * @param Report report
     */
    @Override
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

    /**
     * Search a report by report<Report>.
     * delete the report as a info <HashMap> from the dataHandler<HashMap>.
     * @param Report report
     */
    @Override
    public void removeReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", report);
        dataHandler.deleteData(info);
    }

}
