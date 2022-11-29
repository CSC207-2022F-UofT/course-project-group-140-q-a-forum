package entities;

import java.awt.*;
import java.util.ArrayList;

public class Comment {
    private User postedBy;
    private String texts;
    private ArrayList<Comment> comments;
    /**
     * Create a comment to a Post, with only text.
     * The comment can be commented (nest) as well
     * The comment will only contain the content and the
     * information of the use who posted it
     * @param texts The content of this comment.
     * @param postedBy The user who posts this comment
     */
    public Comment(String texts, User postedBy){
        this.postedBy = postedBy;
        this.texts = texts;
        this.comments = new ArrayList<>();
    }

    public String getTexts() {
        return texts;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public User getPostedBy() {
        return postedBy;
    }

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
