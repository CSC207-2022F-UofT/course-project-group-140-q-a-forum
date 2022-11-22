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

    /**
     * Returns all users in the database.
     * @return An arraylist that contains all users in the current database.
     */
    @Override
    public ArrayList<User> getAllUsers() {
        return dataHandler.getData(1);
    }

    /**
     * Return all courses in the database.
     * @return An arraylist that contains all courses in the current database.
     */
    @Override
    public ArrayList<Course> getAllCourses() {
        return dataHandler.getData(2);
    }

    /**
     * Return all courses in the database.
     * @return An arraylist that contains all courses in the current database.
     */
    @Override
    public ArrayList<Report> getAllReport() {
        return dataHandler.getData(3);
    }

    /**
     * Add a user to the current database.
     * @param user The user to be added.
     */
    @Override
    public void addUser(User user) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.addData(info);
    }

    /**
     * Check whether a user exists in the database.
     * @param userName relevant information of the user to check existence.
     * @return A boolean value representing whether the user exists.
     */
    @Override
    public boolean userExists(String userName) {
        return dataHandler.lookupUserfromName(userName) == null;
    }

    /**
     * Delete the user with the given username.
     * @param username the name of user to be deleted.
     */
    @Override
    public void deleteUser(String username) {
        User user = dataHandler.lookupUserfromName(username);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.deleteData(info);
    }

    /**
     * Reset the username of the given user.
     * @param user The user whoe name is about to be reset.
     * @param newUsername The new username user wants to change.
     */
    @Override
    public void resetUsername(User user, String newUsername) {
        User user_entity = dataHandler.lookupUserfromName(user.getEmail());
        user_entity.setUsername(newUsername);
    }

    /**
     * Reset the password of the user with given username.
     * @param userName The name of user whose password is about to be changed.
     * @param newPassword the new password to be changed to.
     */
    @Override
    public void resetPassword(String userName, String newPassword) {
        User user_entity = dataHandler.lookupUserfromName(userName);
        user_entity.setPassword(newPassword);
    }

//    @Override
//    public void resetEmail(Map<String, String> user, String newEmail) {
//        // WE CANNOT RESET EMAIL
//    }

    /**
     * Get a course with the given course code.
     * @param courseCode The course code of the course.
     * @return A course in the current database with the given course code.
     */
    @Override
    public Course getCourse(String courseCode) {
        return dataHandler.lookupCourse(courseCode);
    }

    /**
     * Get a user with the given username.
     * @param userName The username of the user.
     * @return A user in the current database with the given username.
     */
    @Override
    public User getUser(String userName) {return dataHandler.lookupUserfromName(userName);}

    /**
     * Add a course to the current database.
     * @param course The course to be added.
     */
    @Override
    public void addCourse(Course course) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    /**
     * Delete a course in the current database.
     * @param courseCode The course code of the course to be deleted.
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
     * Check if a course exists in the database
     * @param courseCode relevant information of the course to check existence.
     * @return True if the course exists, false if the course does not exist.
     */
    @Override
    public boolean courseExists(String courseCode) {
        return dataHandler.lookupCourse(courseCode) != null;
    }

    /**
     * Add a report to the database.
     * @param report The report to be added.
     */
    @Override
    public void addReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 3);
        info.put("data", report);
        dataHandler.addData(info);
    }

    /**
     * Get all the reports with the given type.
     * @param type An integer indicating the type of report.
     *             1: User;
     *             2: Course;
     *             3: Post
     * @return An arraylist consists of all the reports with the given type.
     */
    @Override
    public ArrayList<Report> getAllReportFromType(int type) {
        return dataHandler.getAllReportFromType(type);
    }

    /**
     * Remove a report in the database.
     * @param report The report to be removed.
     */
    @Override
    public void removeReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", report);
        dataHandler.deleteData(info);
    }

}
