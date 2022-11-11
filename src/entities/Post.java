package entities;

import java.awt.*;
import java.util.ArrayList;

public class Post {
    private String topic;
    private String texts;
    private ArrayList<Image> images;
    private ArrayList<Comment> comments;

    private User postedBy;

    public Post(){

    }

    /**
     * @param topic
     * @param texts
     */

    public Post(String topic, String texts, User postedBy){
        /**
         * Create a comment, with text, topic, and without images.
         * The comment can be commented (nest) as well
         * The comment will only contain the content and the
         * information of the use who posted it
         */
        this.topic = topic;
        this.texts = texts;
        this.postedBy = postedBy;
        this.images = null;
    }

    /**
     * @param topic
     * @param texts
     * @param images
     */

    public Post(String topic, String texts, ArrayList<Image> images, User postedBy){
        /**
         * Create a comment, with text, topic, and images.
         * The comment can be commented (nest) as well
         * The comment will only contain the content and the
         * information of the use who posted it
         */
        this.topic = topic;
        this.texts = texts;
        this.images = images;
        this.postedBy = postedBy;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public String getTexts() {
        return texts;
    }

    public String getTopic() {
        return topic;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}