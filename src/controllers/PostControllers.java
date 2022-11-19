package controllers;
import use_cases.LoginUseCaseInteractor;
import use_cases.PostUseCaseInteractor;

import java.util.HashMap;

public class PostControllers {
    final LoginUseCaseInteractor loginUseCaseInteractor;

    public PostControllers(LoginUseCaseInteractor loginUseCaseInteractor){
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * pass all post data from UI.
     * Get the return of CreatePost and justify if get False, return "meaningless post".
     * else, return "successfully post".
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public String passDataCreatePost(HashMap<String,Object> post){
        boolean state = PostUseCaseInteractor.createPost(post);
        if (state){
            return "successfully post";
        }
        else {
            return "meaningless post";
        }
    }

    /**
     * pass all post data from UI.
     * Get the return of EditPost and justify if get False, return "meaningless post".
     * else, return "successfully post"
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public String passDataEditPost (HashMap<String, String> post) {
        int state = PostUseCaseInteractor.editPost(post);
        if (state == 0) {
            return "post already existed";
        } else if (state == 1) {
            return "meaningless post";
        }
    return "successfully post";
    }
}
