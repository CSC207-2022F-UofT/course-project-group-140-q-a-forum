package database;


import entities.Course;
import entities.Report;
import entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RuntimeDataHandler<T> implements DataHandlerInterface<T> {
    private List<User> users;
    private List<Course> courses;
    private List<Report> reports;
    private Map<String, User> name2User;
    private Map<String, User> email2User;
    private final Map<String, Course> code2Course;
    private final Map<String, ArrayList<Report>> type2Report;

    public RuntimeDataHandler(){
        users = new ArrayList<>();
        courses = new ArrayList<>();
        reports = new ArrayList<>();
        name2User = new HashMap<>();
        email2User = new HashMap<>();
        code2Course = new HashMap<>();
        type2Report = new HashMap<>();
    }

    /**
     * The method accepts a hashmap from an integer-valued key to a data and replace the original arraylist with the
     * new one
     * It is not responsible of exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of an
     *             arraylist}
     */
    @Override
    public void setData(Map<Integer, T> info) {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        Object value = info.get(1);
        users = (ArrayList<User>) value;

        name2User = new HashMap<>();
        email2User = new HashMap<>();
        for (User user : (ArrayList<User>) value) {
            String username = user.getUsername();
            String email = user.getEmail();
            name2User.put(username, user);
            email2User.put(email, user);
        }

        value = info.get(2);
        courses = (ArrayList<Course>) value;
        for (Course course : (ArrayList<Course>) value) {
            String code = course.getCode();
            code2Course.put(code, course);
        }


        value = info.get(3);
        reports = (ArrayList<Report>) value;
        for (Report report : (ArrayList<Report>) value) {
            String reportType = report.getReportType();
            if (! type2Report.containsKey(reportType)){
                type2Report.put(reportType, new ArrayList<Report>());
            }
            else{
                type2Report.get(reportType).add(report);
            }
        }

    }

    public void updateUsername(String oldUsername, String newUsername){
        User user = name2User.get(oldUsername);
        name2User.remove(oldUsername);
        name2User.put(newUsername, user);
    }

    /**
     * The method accepts a hashmap from a integer-valued key to a data and append it to the ararylist
     * It is not responsible of exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of an
     *             single course/user/report type object}
     */

    @Override
    public void addData(Map<String, T> info) {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        int key = (int) info.get("key");
        Object value = info.get("data");
        switch (key) {
            case 1 -> {
                User user = (User) value;
                users.add(user);
                // Put into a dictionary for faster search and access
                String username = user.getUsername();
                String email = user.getEmail();
                name2User.put(username, user);
                email2User.put(email, user);
            }
            case 2 -> {
                Course course = (Course) value;
                courses.add(course);
                // Put into a dictionary for faster search and access
                String code = course.getCode();
                code2Course.put(code, course);
            }
            case 3 -> {
                Report report = (Report) value;
                reports.add(report);
                // Put into a dictionary for faster search and access
                String reportType = report.getReportType();
                if (!type2Report.containsKey(reportType)) {
                    type2Report.put(reportType, new ArrayList<Report>());
                } else {
                    type2Report.get(reportType).add(report);
                }
            }
            default -> throw new RuntimeException();
        }
    }

    /**
     * The method accepts a hashmap from an integer-valued key to a data, and delete it from the list
     * It is not responsible of exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of a
     *             single course/user/report type object}
     */

    @Override
    public void deleteData(Map<String, T> info) {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        int key = (int) info.get("key");
        Object value = info.get("data");
        switch (key){
            case 1:
                User user = (User) value;
                users.remove(user);
                name2User.remove(user.getUsername());
                email2User.remove(user.getEmail());
            case 2:
                Course course = (Course) value;
                courses.remove(course);
                code2Course.remove(course.getCode());
            case 3:
                Report report = (Report) value;
                reports.remove(report);
                type2Report.remove(report.getReportType());
            default:
                throw new RuntimeException();
        }
    }

    /*
     * build a map contains User, Course, Report
     * return the map
     */
    @Override

    public Map<Integer, List> getData() {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        HashMap<Integer, List> map = new HashMap<Integer, List>();
        map.put(1, users);
        map.put(2, courses);
        map.put(3, reports);
        return map;
    }


    /**
     * @param key get data by corrsponding key
     * @return users when key == 1, course when key==2, reports when key==3
     */
    @Override
    public List getData(int key) {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        return switch (key) {
            case 1 -> users;
            case 2 -> courses;
            case 3 -> reports;
            default -> throw new RuntimeException();
        };
    }

    /**
     * Find user by username
     * @param username the name of user
     * @return if user is found return User user, otherwise null
     */
    public User lookupUserfromName(String username) {
        return name2User.getOrDefault(username, null);
    }

    /**
     * Find email by email
     * @param email the email that needs to check
     * @return if email is found return String email, otherwise null
     */
    public User lookupUserfromEmail(String email) {
        return email2User.getOrDefault(email, null);
    }


    /**
     * Find course by code
     * @param code the code of course
     * @return if course is found return Course, otherwise null
     */
    public Course lookupCourse(String code) {
        return code2Course.getOrDefault(code, null);
    }

    public ArrayList<Report> getAllReportFromType(String key){
        return type2Report.get(key);
    }

}