package entities;

import java.util.ArrayList;
import java.util.Date;

public class Course {

    private String Name;
    private String CourseCode;
    private String Description;
    private String Instructor;
    private Date[] Semester;
    private ArrayList<User> Students;

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
     * @param Instructor
     */

    public Course(String name, String code, String description, Date[] semester,String Instructor){
        this.Name = name;
        this.CourseCode = code;
        this.Description = description;
        this.Semester = semester;
        this.Instructor = Instructor;
        this.Students = new ArrayList<>();
    }

    /**
     * Getter methods
     */
    public String getName() {
        return Name;
    }

    public String getCode() {
        return CourseCode;
    }

    public String getDescription() {
        return Description;
    }

    public Date[] getSemester() {
        return Semester;
    }

    public String getInstructor() {
        return Instructor;
    }

    /**
     * Setter methods
     */

    public void addStudent(User student){
        Students.add(student);
    }

    public void removeStudent(User student){
        if(Students.indexOf(student) != -1){
            Students.remove(student);
        }
        // TODO: If the user is not in the course, generate an error message!
    }
}