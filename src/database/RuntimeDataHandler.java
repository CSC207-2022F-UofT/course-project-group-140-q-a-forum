package database;

import entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class RuntimeDataHandler implements DataHandlerInterface {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Report> reports = new ArrayList<>();

    /**
     * The method accepts a hashmap from an integer-valued key to a data and replace the original arraylist with the
     * new one
     * It is not responsible of exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of an
     *             arraylist}
     */

    @Override
    public void setData(HashMap<Integer, Object> info) {
        /**
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
            case 2:
                courses = (ArrayList<Course>) value;
            case 3:
                reports = (ArrayList<Report>) value;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * The method accepts a hashmap from a integer-valued key to a data and append it to the ararylist
     * It is not responsible of exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of an
     *             single course/user/report type object}
     */

    @Override
    public void addData(HashMap<Integer, Object> info) {
        /**
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
                users.add((User) value);
            case 2:
                courses.add((Course) value);
            case 3:
                reports.add((Report) value);
            default:
                throw new RuntimeException();
        }
    }

    /**
     * The method accepts a hashmap from an integer-valued key to a data, and delete it from the list
     * It is not responsible of exception handling (i.e, data not in the arraylist)
     * @param info is a hashmap in the form: {"key": <type_of_data>, "data": <value_of_data>, in the form of a
     *             single course/user/report type object}
     */

    @Override
    public void deleteData(HashMap<Integer, Object> info) {
        /**
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
                users.remove((User) value);
            case 2:
                courses.remove((Course) value);
            case 3:
                reports.remove((Report) value);
            default:
                throw new RuntimeException();
        }
    }

    @Override
    public HashMap getData() {
        /**
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

    @Override
    public ArrayList getData(int key) {
        /**
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
}

