package database;

import entities.*;
import use_cases.DataBaseAccess.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseGateway implements CourseDataInterface, UserDataInterface, ReportDataInterface{

    final RuntimeDataHandler dataHandler;
    final DatabaseDataHandler databaseHandler;

    public DatabaseGateway(RuntimeDataHandler<Object> dataHandler, DatabaseDataHandler databaseHandler) {
        this.dataHandler = dataHandler;
        this.databaseHandler = databaseHandler;
    }

    @Override
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>) dataHandler.getData(1);
    }
    @Override
    public ArrayList<Course> getAllCourses() {
        return (ArrayList<Course>) dataHandler.getData(2);
    }

    @Override
    public ArrayList<Report> getAllReport() {
        return (ArrayList<Report>) dataHandler.getData(3);
    }


    /**
     * Add a user as a info into the dataHandler.
     * @param user  the user who needs to add
     */
    @Override
    public void addUser(User user) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.addData(info);
    }
    /**
     * Check if the user already existed in database by username.
     * @param userName  the name of user
     */
    @Override
    public boolean userExists(String userName) {
        return dataHandler.lookupUserfromName(userName) != null;
    }

    @Override
    public boolean emailExists(String email) {
        return dataHandler.lookupUserfromEmail(email) != null;
    }

    @Override
    /**
     * Search a user by userName<.
     * delete the user as an info  from the dataHandler.
     * @param user  the user
     */
    public void deleteUser(User user) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.deleteData(info);
    }
    /**
     * Get user information by user's email, and change user's username by newUsername.
     * @param user  the user who needs to reset
     * @param newUsername the updated name of user
     */
    @Override
    public void resetUsername(User user, String newUsername) {
        User userEntity = dataHandler.lookupUserfromEmail(user.getEmail());
        dataHandler.updateUsername(userEntity.getUsername(), newUsername);
        userEntity.setUsername(newUsername);
    }
    /**
     * Get user information by user's email, and change user's password by newPassword.
     * @param user the user
     * @param newPassword  the new password that needs to set
     */
    @Override
    public void resetPassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }
    /**
     * Get course by courseCode.
     * @param courseCode  the code of course
     */
    @Override
    public Course getCourse(String courseCode) {
        return dataHandler.lookupCourse(courseCode);
    }


    /**
     * Get post by  postTopic
     * @param course  the course
     * @param postTopic  the topic of post
     * @return course the course found
     */
    @Override
    public Post getPost(Course course, String postTopic) {
        return course.lookupPostFromTopic(postTopic);
    }

    /**
     * Check if a post already existed in a course.
     * @param course  the course
     * @param postTopic  the topic of post
     * @return bool
     */
    @Override
    public boolean postExists(Course course, String postTopic) {
        ArrayList<Post> posts = course.getPosts();
        for(Post post: posts){
            if (post.getTopic().equals(postTopic)){
                return true;
            };
        }
        return false;
    }
    /**
     * Get user by  userName, return the user
     * @param userName the name of user
     */
    @Override
    public User getUser(String userName) {return dataHandler.lookupUserfromName(userName);}

    /**
     * Add a course as a info into the dataHandler.
     * @param course  the course that needs to add
     */
    @Override
    public void addCourse(Course course) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    /**
     * Search a course by courseCode.
     * delete the course as a info from the dataHandler.
     * @param course The course to be deleted.
     */
    @Override
    public void deleteCourse(Course course) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }
    /**
     * Check if a course already existed in database.
     * @param courseCode  the code of course
     */
    @Override
    public boolean courseExists(String courseCode) {
        return dataHandler.lookupCourse(courseCode) != null;
    }


    /**
     * Add a report as a info into the dataHandle.
     * @param report the report that needs to add
     */
    @Override
    public void addReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 3);
        info.put("data", report);
        dataHandler.addData(info);
    }

    @Override
    public ArrayList<Report> getAllReportFromType(String type) {
        return dataHandler.getAllReportFromType(type);
    }

    /**
     * Search a report by report.
     * delete the report as an info from the dataHandler.
     * @param report the report that needs to remove
     */
    @Override
    public void removeReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 3);
        info.put("data", report);
        dataHandler.deleteData(info);
    }

    public void saveToFile() throws IOException {
        databaseHandler.saveToFile(dataHandler.getData());
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        dataHandler.setData((HashMap<Integer, List>) databaseHandler.readFromFile());
    }

}