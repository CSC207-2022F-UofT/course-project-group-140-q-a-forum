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
     * @param texts The text in the comment
     * @param postedBy The postedBy that indicate the author name
     *
     */
    public Comment(String texts, User postedBy){

        this.postedBy = postedBy;
        this.texts = texts;
        this.comments = new ArrayList<>();
    }


    /**
     * Extract the text included in the comment
     * @return a string text included in the comment
     */
    public String getTexts() {
        return texts;
    }

    /**
     * Extract all the comments in the method
     * @return a list of comments
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }

    /**
     * Get the user that post the comment
     * @return posted by which user
     */
    public User getPostedBy() {
        return postedBy;
    }


    /**
     * set the texts of the comment
     * @param texts that the information the user wants to leave
     */
    public void setTexts(String texts) {
        this.texts = texts;
    }

    /**
     * set the name of the user who posted the comment
     * @param postedBy that the name of the user
     */
    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    /**
     * Adding on more comment to the original comment.
     * @param comment is the supplemental on th original comment
     */
    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    /**
     * Removing the comment from the past comment
     * @param comment is the string that needs to be removed
     */
    public void removeComment(Comment comment){
        this.comments.remove(comment);
    }

}
