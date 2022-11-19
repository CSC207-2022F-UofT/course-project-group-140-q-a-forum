package controllers;

import entities.User;
import use_cases.LoginUseCaseInteractor;
import use_cases.UserUseCaseInteractor;
import java.util.*;

public class UserController {
    private final UserUseCaseInteractor userUseCaseInteractor;
    private final LoginUseCaseInteractor loginUseCaseInteractor;


    public UserController(UserUseCaseInteractor userUseCaseInteractor, LoginUseCaseInteractor loginUseCaseInteractor) {
        this.userUseCaseInteractor = userUseCaseInteractor;
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * this function registers the User
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student, if not return the error type
     */
    public String registerUser(Map<String, String> user){
        return userUseCaseInteractor.createUser(user);
    }


    /**
     * Login the user
     * @param user  This is a Map that contains necessary information
     *      *             needed to register a user. The keys must be
     *      *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @param passwork  This is the password we input
     * @return  the string "Correct Password" or "Wrong Password"
     */
    public String loginUser(User user, String passwork){
        if (loginUseCaseInteractor.checkLogin(user, passwork)){
            return "Correct Password";
        }
        else{
            return "Wrong Password";
        }

    }
}
