package entities;

import java.util.ArrayList;
import java.util.Date;

public class Course {

    private String name;
    private String courseCode;
    private String description;

    private ArrayList<String> instructors;
    private Date[] semester;
    private ArrayList<User> students;

    /**
     *
     */

    public Course(){

    }

    /**
     * @param name
     * @param code
     * @param description
     * @param semester
     * @param instructors
     */

    public Course(String name, String code, String description, Date[] semester, ArrayList<String> instructors){
        /**
         * Create a course wih coursename, coursecode, description, semster teaching
         * and instructor.
         * all of the information are immutable, unless being fixed by a administrator.
         */
        this.name = name;
        this.courseCode = code;
        this.description = description;
        this.semester = semester;
        this.instructors = instructors;
        this.students = new ArrayList<>();
    }

    /**
     * Getter methods
     */
    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.courseCode;
    }

    public String getDescription() {
        return this.description;
    }

    public Date[] getSemester() {
        return this.semester;
    }

    public ArrayList<String> getInstructor() {
        return this.instructors;
    }

    /**
     * Setter methods
     */

    public void addStudent(User student){
        this.students.add(student);
    }

    public void removeStudent(User student){
        if(this.students.indexOf(student) != -1){
            this.students.remove(student);
        }
        // TODO: If the user is not in the course, generate an error message!
    }
}