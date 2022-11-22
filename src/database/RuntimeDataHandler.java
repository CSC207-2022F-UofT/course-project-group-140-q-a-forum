package database;

import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RuntimeDataHandler implements DataHandlerInterface {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Report> reports = new ArrayList<>();

    private HashMap<String, User> name2User = new HashMap<>();
    private HashMap<String, User> email2User = new HashMap<>();
    private HashMap<String, Course> code2Course = new HashMap<>();
    private HashMap<Integer, ArrayList<Report>> type2Report = new HashMap<>();

    /**
     * The method accepts a hashmap from an integer-valued key to a data and replace the original arraylist with the
     * new one
     * It is not responsible for exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of an
     *             arraylist}
     */
    @Override
    public void setData(HashMap<String, Object> info) {
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
                users = (ArrayList<User>) value;

                name2User = new HashMap<>();
                email2User = new HashMap<>();
                for (User user : (ArrayList<User>) value) {
                    String username = user.getUsername();
                    String email = user.getEmail();
                    name2User.put(username, user);
                    email2User.put(email, user);
                }
                break;
            case 2:
                courses = (ArrayList<Course>) value;
                for (Course course : (ArrayList<Course>) value) {
                    String code = course.getCode();
                    code2Course.put(code, course);
                }
                break;
            case 3:
                reports = (ArrayList<Report>) value;
                for (Report report : (ArrayList<Report>) value) {
                    int reportType = report.getReportType();
                    if (! type2Report.containsKey(reportType)){
                        type2Report.put(reportType, new ArrayList<Report>());
                    }
                    else{
                        type2Report.get(reportType).add(report);
                    }
                }
                break;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * The method accepts a hashmap from an integer-valued key to a data and append it to the arraylist
     * It is not responsible for exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of a
     *             single course/user/report type object}
     */
    @Override
    public void addData(HashMap<String, Object> info) {
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
                users.add(user);
                // Put into a dictionary for faster search and access
                String username = user.getUsername();
                String email = user.getEmail();
                name2User.put(username, user);
                email2User.put(email, user);
                break;
            case 2:
                Course course = (Course) value;
                courses.add(course);
                // Put into a dictionary for faster search and access
                String code = course.getCode();
                code2Course.put(code, course);
                break;
            case 3:
                Report report = (Report) value;
                reports.add(report);
                // Put into a dictionary for faster search and access
                int reportType = report.getReportType();
                if (! type2Report.containsKey(reportType)){
                    type2Report.put(reportType, new ArrayList<Report>());
                }
                else{
                    type2Report.get(reportType).add(report);
                }
                break;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * The method accepts a hashmap from an integer-valued key to a data, and delete it from the list
     * It is not responsible for exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of a
     *             single course/user/report type object}
     */
    @Override
    public void deleteData(HashMap<String, Object> info) {
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
                break;
            case 2:
                Course course = (Course) value;
                courses.remove(course);
                code2Course.remove(course.getCode());
                break;
            case 3:
                Report report = (Report) value;
                reports.remove(report);
                type2Report.remove(report.getReportType());
                break;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * Return all data of users, courses and reports.
     * @return A hashmap whose keys are integers representing the types of their values, whose values
     * are users, courses and reports.
     * 1: User;
     * 2: Course;
     * 3: Report.
     */
    @Override
    public HashMap getData() {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        HashMap<Integer, Object> map = new HashMap<Integer,Object>();
        map.put(1, users);
        map.put(2, courses);
        map.put(3, reports);
        return map;
    }

    /**
     * Return a specific type of data in the current database.
     * @param key An integer representing what type of data to be returned.
     *            1: User;
     *            2: Course;
     *            3: Report.
     * @return An arraylist consists of instances of the given type.
     */
    @Override
    public ArrayList getData(int key) {
        /*
         * Value of key indicates the following type of data
         * 1: User
         * 2: Course
         * 3: Report
         * All the other types of data (Post, Comment) are stored directly in its corresponding branching class
         * (i.e, Posts of a course are stored in Course. posts)
         */
        switch (key){
            case 1:
                return users;
            case 2:
                return courses;
            case 3:
                return reports;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * Get a user with the given username.
     * @param username The username of the user to be searched for.
     * @return The user with the given username.
     */
    public User lookupUserfromName(String username) {
        if (name2User.containsKey(username)){
            return name2User.get(username);
         }
        else{
            return null;
        }
    }

    /**
     * Get a user with the given email.
     * @param email The email of the user to be searched for.
     * @return The user with the given email.
     */
    public User lookupUserfromEmail(String email) {
        if (email2User.containsKey(email)){
            return email2User.get(email);
        }
        else{
            return null;
        }
    }

    /**
     * Get a course with the given course code.
     * @param code The course code of the course to be searched for.
     * @return The course with the given course code.
     */
    public Course lookupCourse(String code) {
        if (code2Course.containsKey(code)) {
            return code2Course.get(code);
        }
        else {
            return null;
        }
    }

    /**
     * Get an arraylist of reports with the given type.
     * @param key The type of reports to be returned to.
     *            1: User;
     *            2: Course;
     *            3: Report;
     * @return An arraylist of reports with the given type.
     */
    public ArrayList<Report> getAllReportFromType(int key){
        return type2Report.get(key);
    }

}