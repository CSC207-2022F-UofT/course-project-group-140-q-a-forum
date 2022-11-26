package controllers;
import entities.Comment;
import entities.Post;
import exceptions.EmptyEntryException;
import exceptions.EntryNotFoundException;
import use_cases.LoginUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.util.ArrayList;
import java.util.HashMap;

public class PostController {

    private final PostUseCaseInteractor postUseCaseInteractor;
    public PostController(PostUseCaseInteractor postUseCaseInteractor){
        this.postUseCaseInteractor = postUseCaseInteractor;
    }

    /**
     * pass all post data from UI.
     * Get the return of CreatePost and justify if get False, return "meaningless post".
     * else, return "successfully post".
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public int createPost(HashMap<String,Object> post){
        try{
            postUseCaseInteractor.createPost(post);
        }
        catch (EmptyEntryException e){
            return -1;
        }
        return 0;
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
        catch(EmptyEntryException e){
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

    public ArrayList<String> getAllPosts(HashMap<String, Object> info){
        String code = (String) info.get("code");
        return null;
    }

    /**
     * Get all comments of the post with given post topic in the course with the given course code.
     * @param courseCode The course code of the course that this post is of.
     * @param postTopic The topic of the course.
     * @return If there is not such post, then return null; else, return an arraylist of comments.
     */
    public ArrayList<Comment> getAllCommentFromPost(String courseCode, String postTopic){
        try{return postUseCaseInteractor.getAllCommentFromPost(courseCode, postTopic);}
        catch(EmptyEntryException e){
            return null;
        }
    }

    /**
     * Get all comment from a comment.
     * @param comment The comment whose comments are to be returned.
     * @return An arraylist of comments.
     */
    public ArrayList<Comment> getAllCommentFromComment(Comment comment){
        return postUseCaseInteractor.getAllCommentFromComment(comment);
    }


}
