package controllers;
import entities.Comment;
import entities.Post;
import entities.User;
import exceptions.DuplicationException;
import exceptions.EmptyEntryException;
import exceptions.NotFoundException;
import use_cases.PostUseCaseInteractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PostController {

    private final PostUseCaseInteractor postUseCaseInteractor;
    public PostController(PostUseCaseInteractor postUseCaseInteractor){
        this.postUseCaseInteractor = postUseCaseInteractor;
    }

    /**
     * Create a post with given information.
     * @param post information will be stored at the HashMap
     * @return  An integer representing the success or why cannot create this post
     * 1: Successfully created;
     * -1: There is an empty entry;
     * -2: There is a post with the same title.
     */
    public int createPost(HashMap<String,Object> post){
        try{
            postUseCaseInteractor.createPost(post);
        }
        catch (EmptyEntryException e) {
            return -1;
        }catch (DuplicationException e){
            return -2;
        }
        return 1;
    }

    /**
     * pass all post data from UI.
     * Get the return of EditPost and justify if get False, return "meaningless post".
     * else, return "successfully post"
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public int editPost(HashMap<String, Object> post) {
        try{
            postUseCaseInteractor.editPost(post);
        }
        catch(NotFoundException e){
            return -1;
        }
        return 0;
    }

    public int removePost(HashMap<String, Object> post, String courseCode){
        try{
            postUseCaseInteractor.removePost(post);
        }
        catch(EmptyEntryException e){
            return -1;
        }
        return 0;
    }

    /**
     * Get all comments of the post with given post topic in the course with the given course code.
     * @param courseCode The course code of the course that this post is of.
     * @param postTopic The topic of the course.
     * @return If there is not such post, then return null; else, return an arraylist of comments.
     */
    public List<Comment> getAllCommentFromPost(String courseCode, String postTopic){
        return postUseCaseInteractor.getAllCommentFromPost(courseCode, postTopic);
    }

    /**
     * Get all comment from a comment.
     * @param comment The comment whose comments are to be returned.
     * @return An arraylist of comments.
     */
    public List<Comment> getAllCommentFromComment(Comment comment){
        return postUseCaseInteractor.getAllCommentFromComment(comment);
    }

    /**
     * Make a post that is posted by the given user under the given post
     * with the given content.
     * @param post The post under which the comment will be posted.
     * @param user The user who posts this comment;
     * @param content The content of the post.
     * @return An integer representing the success of making a post or
     * the reason of the failure.
     * 1: Success;
     * -1: The content is empty.
     */
    public int makeComment(Post post, User user, String content){
        try{postUseCaseInteractor.makeCommentFromPost(post, user, content);}
        catch(EmptyEntryException e){return -1;}
        return 1;
    }

    /**
     * Like a post
     * @param post The post to be liked
     * @param user The user that likes this post.
     * @return An integer representing whether successfully liked a post.
     * 1: Successfully liked a post;
     * -1: The user has already liked this post.
     */
    public int likePost(Post post, User user){
        try{postUseCaseInteractor.likePost(post, user);}
        catch(DuplicationException e){return -1;}
        return 1;
    }

    /**
     * Dislike a post
     * @param post The post to be disliked
     * @param user The user that dislikes this post.
     * @return An integer representing whether successfully liked a post.
     * 1: Successfully disliked a post;
     * -1: The user has already disliked this post.
     */
    public int dislikePost(Post post, User user){
        try{postUseCaseInteractor.dislikePost(post, user);}
        catch(DuplicationException e){return -1;}
        return 1;
    }

}