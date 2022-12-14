package entities;


import java.io.Serializable;


public class Comment implements Serializable {
    private final User postedBy;
    private final String texts;

    public Comment(){
        postedBy = null;
        texts = null;
    }

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
    }

    public String getTexts() {
        return texts;
    }

    public User getPostedBy() {
        return postedBy;
    }


}