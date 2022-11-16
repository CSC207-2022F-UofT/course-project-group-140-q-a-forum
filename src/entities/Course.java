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
     * Create a course wih course name, course code, description, semester teaching
     * and instructor.
     * All the information are immutable, unless being fixed by an administrator.
     * @param name the name of the course
     * @param code the course code of the course
     * @param description a description of the course
     * @param semester the start and end date of the course
     * @param instructors an array list of instructors
     */

    public Course(String name, String code, String description, Date[] semester, ArrayList<String> instructors){
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
     * the method for adding a student to a course. If the student is already in the course, returns false;
     * otherwise they are added to the course and returns true.
     * @param student the student to be added
     * @return if successfully added this student to this course
     */
    public boolean addStudent(User student){
        if (this.students.contains(student)){
            return false;
        }else{
            this.students.add(student);
            return true;
        }
    }

    /**
     * the method for removing a student to a course. If the student is not in the course, returns false;
     * otherwise they are removed from this course and returns true.
     * @param student the student to be removed
     * @return if successfully removed this student from this course
     */
    public boolean removeStudent(User student){
        if (this.students.contains(student)){
            this.students.remove(student);
            return true;
        }else{
            return false;
        }
    }

    /**
     * the method for adding an instructor to a course. If the instructor is already in the course, returns false;
     * otherwise they are added to the course and returns true.
     * @param instructor the instructor to be added
     * @return if successfully added this instructor into this course
     */
    public boolean addInstructor(String instructor){
        if (this.instructors.contains(instructor)){
            return false;
        }else{
            this.instructors.add(instructor);
            return true;
        }
    }

    /**
     * the method for removing an instructor to a course. If the instructor is not in the course, returns false;
     * otherwise they are removed from this course and returns true.
     * @param instructor the instructor to be removed
     * @return if successfully removed this instructor from this course
     */
    public boolean removeInstructor(String instructor){
        if (this.instructors.contains(instructor)){
            this.instructors.remove(instructor);
            return true;
        }else{
            return false;
        }
    }
}