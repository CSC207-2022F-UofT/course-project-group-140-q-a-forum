package controllers;

import entities.User;
import exceptions.UserNotFoundException;
import exceptions.WrongPasswordException;
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
     * @return if successfully registered this student, then return "Good", if not return the message of the error
     */
    public String registerUser(Map<String, String> user){
        try{
            userUseCaseInteractor.createUser(user);
        }catch (RuntimeException e){
            return e.getMessage();
        }
//        finally {
//            return "GOOD!";
//        }
        return "Good";
    }


    /**
     * Login the user
     * @param username  This is a Map that contains necessary information
     *      *             needed to register a user. The keys must be
     *      *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @param password  This is the password we input
     * @return int  1 represent get the user and the user password match the userName
     *      *      -1 represent didn't find the user in the database
*      *           -2 represent the user's password do not match the user's userName
     */
      public int loginUser(String username, String password){
        try{loginUseCaseInteractor.checkLogin(username,password);}
        catch(WrongPasswordException e){
            return -2;
        }
        catch (UserNotFoundException e){
            return -1;
        }
        return 1;
    }



//    public User searchUser(String username){
//
//    }
}
