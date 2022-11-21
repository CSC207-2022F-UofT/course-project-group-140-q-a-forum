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

    @Override
    public void addUser(User user) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.addData(info);
    }

    @Override
    public boolean userExists(Map<String, String> user) {
        String username = user.get("username");
        String email = user.get("email");
        return dataHandler.lookupUserfromName(username) == null
                & dataHandler.lookupUserfromEmail(email) == null;
    }

    @Override
    public void deleteUser(String username) {
        User user = dataHandler.lookupUserfromName(username);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 1);
        info.put("data", user);
        dataHandler.deleteData(info);
    }

    @Override
    public void resetUsername(Map<String, String> user, String newUsername) {
        User user_entity = dataHandler.lookupUserfromName(user.get("email"));
        user_entity.setUsername(newUsername);
    }

    @Override
    public void resetPassword(Map<String, String> user, String newPassword) {
        User user_entity = dataHandler.lookupUserfromName(user.get("email"));
        user_entity.setPassword(newPassword);
    }

    @Override
    public void resetEmail(Map<String, String> user, String newEmail) {
        // WE CANNOT RESET EMAIL
    }

    @Override
    public Course getCourse(String courseCode) {
        return dataHandler.lookupCourse(courseCode);
    }

    @Override
    public void addCourse(Course course) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    @Override
    public void deleteCourse(String courseCode) {
        Course course = dataHandler.lookupCourse(courseCode);
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", course);
        dataHandler.addData(info);
    }

    @Override
    public boolean courseExists(String courseCode) {
        return dataHandler.lookupCourse(courseCode) != null;
    }


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

    @Override
    public void removeReport(Report report) {
        HashMap<String, Object> info = new HashMap<>();
        info.put("key", 2);
        info.put("data", report);
        dataHandler.deleteData(info);
    }

}
