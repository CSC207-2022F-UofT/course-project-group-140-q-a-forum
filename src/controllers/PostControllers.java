package controllers;
import use_cases.LoginUseCaseInteractor;
import use_cases.PostUseCaseInteractor;

import java.util.HashMap;

public class PostControllers {
//    final LoginUseCaseInteractor loginUseCaseInteractor;
    final PostUseCaseInteractor postUseCaseInteractor;

//    public PostControllers(LoginUseCaseInteractor loginUseCaseInteractor, PostUseCaseInteractor postUseCaseInteractor){
//        this.loginUseCaseInteractor = loginUseCaseInteractor;
//        this.postUseCaseInteractor = postUseCaseInteractor;
//    }
    public PostControllers(PostUseCaseInteractor postUseCaseInteractor){
        this.postUseCaseInteractor = postUseCaseInteractor;
    }

    /**
     * pass all post data from UI.
     * Get the return of CreatePost and justify if get False, return "meaningless post".
     * else, return "successfully post".
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public String passDataCreatePost(HashMap<String,Object> post){
        try{
            postUseCaseInteractor.createPost(post);
        }
        catch (RuntimeException e){

        }
        return "Ok.";
    }

    /**
     * pass all post data from UI.
     * Get the return of EditPost and justify if get False, return "meaningless post".
     * else, return "successfully post"
     * @param post information will be stored at the HashMap
     * @return  String for each state.
     */
    public String passDataEditPost(HashMap<String, Object> post) {
        try{
            postUseCaseInteractor.editPost(post);
        }
        catch(RuntimeException e){
            //TODO: Do sth.
        }
        return "Ok.";
    }
}
