package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

public class Course implements Serializable {

    private String name;
    private String courseCode;
    private String description;

    private List<String> instructors;
    private String semester;

    private ArrayList<Post> posts;

    private HashMap<String, Post> topic2Post;

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
     * @param instructors a list of instructors
     */

    public Course(String name, String code, String description, String semester, List<String> instructors){
        this.name = name;
        this.courseCode = code;
        this.description = description;
        this.semester = semester;
        this.instructors = instructors;
        this.posts = new ArrayList<>();
        this.topic2Post = new HashMap<>();
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

    public String getSemester() {
        return this.semester;
    }

    public List<String> getInstructor() {
        return this.instructors;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayList<String> getPostTitles(){
        Set<String> keySet = topic2Post.keySet();
        ArrayList<String> listOfKeys
                = new ArrayList<>(keySet);
        return listOfKeys;
    }

    /**
     * Modify the content of a course.
     * @param part Which attribute of the course to be modified to.
     * @param changTo The content to be changed to.
     * @return If the modification is successful.
     */
    public boolean modifyCourseContent(String part, String changTo){
        switch(part){
            case "name":
                this.name = changTo;
                return true;
            case "courseCode":
                this.courseCode = changTo;
                return true;
            case "description":
                this.description = changTo;
                return true;
            case "semester":
                this.semester = changTo;
                return true;
            default:
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

    /**
     * Add a post to the post list of this course.
     * @param post The post to be added in.
     * @return If the post is successfully added.
     */
    public boolean addPost(Post post){
        if (this.posts.contains(post)){
            return false;
        }else{
            this.posts.add(post);
            this.topic2Post.put(post.getTopic(), post);
            return true;
        }
    }

    /**
     * Remove a post from the post list of this course.
     * @param post The post to be removed.
     * @return If the post is successfully removed.
     */
    public boolean removePost(Post post){
        if (this.posts.contains(post)){
            this.posts.remove(post);
            this.topic2Post.remove(post.getTopic(), post);
            return true;
        }else{
            return false;
        }
    }

    public Post lookupPostFromTopic(String topic){
        return topic2Post.getOrDefault(topic, null);
    }
}