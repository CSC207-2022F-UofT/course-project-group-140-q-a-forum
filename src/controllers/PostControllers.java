package controllers;
import use_cases.LoginUseCaseInteractor;

import java.util.HashMap;

public class PostControllers {
    final LoginUseCaseInteractor loginUseCaseInteractor;

    public PostControllers(LoginUseCaseInteractor loginUseCaseInteractor){
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * pass all post data from UI.
     * Get the return of CreatePost and justify if get False, return "meaningless post".
     * else, return "successfully post"
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public String passDataCreatePost(HashMap<String, String> post){

        return "meaningless post";
    }

    /**
     * pass all post data from UI.
     * Get the return of CreatePost and justify if get False, return "meaningless post".
     * else, return "successfully post"
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public String passDataEditPost (HashMap<String, String> post){
        return "meaningless post";
    }
}
