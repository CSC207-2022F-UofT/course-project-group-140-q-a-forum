package entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {
    private String topic;
    private String texts;
    private List<Comment> comments;

    private User postedBy;

    private Course course;

    private int likeNumber;

    private List<String> likeUser;

    private List<String> dislikeUser;

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
        this.comments = new ArrayList<>();
        this.likeNumber = 0;
        this.likeUser = new ArrayList<>();
        this.dislikeUser = new ArrayList<>();
    }


    public List<Comment> getComments() {
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

    public int getLikeNumber(){
        return likeNumber;
    }

    public List<String> getLikeUser(){
        return this.likeUser;
    }

    public List<String> getDislikeUser(){
        return this.dislikeUser;
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

    public void like(String email){
        this.likeUser.add(email);
        boolean found = this.dislikeUser.remove(email);
        if (found){
            // If a person changes from dislike to like, then the like number should increment by 2
            this.likeNumber += 1;
        }
        this.likeNumber += 1;
    }

    public void dislike(String email){
        this.dislikeUser.add(email);
        boolean found = this.likeUser.remove(email);
        if (found){
            // If a person changes from like to dislike, then the like number should decrement by 2
            this.likeNumber -= 1;
        }
        this.likeNumber -= 1;
    }

}