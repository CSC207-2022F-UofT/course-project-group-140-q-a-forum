package entities;

import java.awt.*;
import java.util.ArrayList;

public class Post {
    private String topic;
    private String texts;
    private ArrayList<Comment> comments;

    private User postedBy;

    private Course course;

    public Post(){

    }


    /**
     * Create a new post.
     * @param topic The topic of the post.
     * @param texts The content of the post.
     * @param postedBy The user that posts this post.
     * @param course The course that this post belongs to.
     */
    public Post(String topic, String texts, User postedBy, Course course){
        this.topic = topic;
        this.texts = texts;
        this.postedBy = postedBy;
        this.course = course;
        this.comments = new ArrayList<Comment>();
    }


    public ArrayList<Comment> getComments() {
        return comments;
    }

    public String getTexts() {
        return texts;
    }

    public String getTopic() {
        return topic;
    }

    public Course getCourse() {return course;}

    public User getPostedBy() {
        return postedBy;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public void modifyPost(String topic, String texts){
        this.topic = topic;
        this.texts = texts;
    }



}