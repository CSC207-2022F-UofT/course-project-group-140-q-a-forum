package controllers;

import Presenter.RegisterPresenter;
import entities.User;
import use_cases.LoginUseCaseInteractor;
import use_cases.UserUseCaseInteractor;
import java.util.*;

public class UserController {
    private final UserUseCaseInteractor userUseCaseInteractor;
//    private final LoginUseCaseInteractor loginUseCaseInteractor;


//    public UserController(UserUseCaseInteractor userUseCaseInteractor, LoginUseCaseInteractor loginUseCaseInteractor) {
//        this.userUseCaseInteractor = userUseCaseInteractor;
//        this.loginUseCaseInteractor = loginUseCaseInteractor;
//    }

    public UserController(UserUseCaseInteractor userUseCaseInteractor) {
        this.userUseCaseInteractor = userUseCaseInteractor;
//        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * this function registers the User
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student, if not return the error type
     */
    public String registerUser(Map<String, String> user){
        try{
            userUseCaseInteractor.createUser(user);

        }catch (RuntimeException e){
            //A bunch of possible exceptions here, later I will add details.
            RegisterPresenter.showNonValidEmailError();
            System.out.println(e.getMessage());
        }
        return "GOOD";
    }


    /**
     * Login the user
     * @param user  This is a Map that contains necessary information
     *      *             needed to register a user. The keys must be
     *      *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @param password  This is the password we input
     * @return  the string "Correct Password" or "Wrong Password"
     */

    public String loginUser(String userName, String password){

        if (userUseCaseInteractor.checkLogin(userName, password)){
            return "Correct Password";
        }
        else{
            return "Wrong Password";
        }

    }
}
