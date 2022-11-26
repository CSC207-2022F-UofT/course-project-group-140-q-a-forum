package entities;

import java.awt.*;
import java.util.ArrayList;

public class Comment {
    private User postedBy;
    private String texts;
//    private ArrayList<Image> images;
    private ArrayList<Comment> comments;

    public Comment(String texts, User postedBy){
        /**
         * Create a comment to a Post, with only text.
         * The comment can be commented (nest) as well
         * The comment will only contain the content and the
         * information of the use who posted it
         */
        this.postedBy = postedBy;
        this.texts = texts;
//        this.images = null;
        this.comments = new ArrayList<>();
    }

    /**
     * Create a comment to a Post, with  text and images.
     * The comment can be commented (nest) as well
     * The comment will only contain the content and the
     * information of the use who posted it
     */
    public Comment(String texts, ArrayList<Image> images, User postedBy){
        this.postedBy = postedBy;
        this.texts = texts;
//        this.images = images;
        this.comments = new ArrayList<>();
    }

    public String getTexts() {
        return texts;
    }

//    public ArrayList<Image> getImages() {
//        return images;
//    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public User getPostedBy() {
        return postedBy;
    }


//    public void setImages(ArrayList<Image> images) {
//        this.images = images;
//    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

}
