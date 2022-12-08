package entities;


import java.io.Serializable;


public record Comment(String texts, User postedBy) implements Serializable {
    /**
     * Create a comment to a Post, with only text.
     * The comment can be commented (nest) as well
     * The comment will only contain the content and the
     * information of the use who posted it
     *
     * @param texts    The content of this comment.
     * @param postedBy The user who posts this comment
     */
    public Comment {
    }


}
