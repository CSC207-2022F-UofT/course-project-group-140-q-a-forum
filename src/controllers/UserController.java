package controllers;

import Presenter.RegisterPresenter;
import entities.User;
import exceptions.*;
import use_cases.LoginUseCaseInteractor;
import use_cases.UserUseCaseInteractor;
import java.util.*;

public class UserController {
    private final UserUseCaseInteractor userUseCaseInteractor;

    public UserController(UserUseCaseInteractor userUseCaseInteractor) {
        this.userUseCaseInteractor = userUseCaseInteractor;
    }

    /**
     * this function registers the User
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and  "isAdmin".
     * @return if successfully registered this student, if not return the error type
     */
    public int registerUser(Map<String, String> user, String code){


        try{
            userUseCaseInteractor.createUser(user, code);
        }catch (DuplicationException e){
            //A bunch of possible exceptions here, later I will add details.
            return -1;
        }catch (PasswordTooWeakException e){

            return -2;
        }catch (PasswordDoesNotMatchException e){

            return -3;
        }catch (InvalidFormatException e){

            return -4;
        }catch (WrongPasswordException e){

            return -5;
        }


        return 1;
    }

    public String passEmail(String email){
        return userUseCaseInteractor.verifyEmail(email);
    }

    /**
     * Login the user
     * @param userName  it is a string that stores the username
     *        password  used to check whether the password match with username in the database
     * @param password  This is the password we input
     * @return  the string "Correct Password" or "Wrong Password"
     */

    public int loginUser(String userName, String password){
        try{userUseCaseInteractor.checkLogin(userName, password);}
        catch(EntryNotFoundException e){
            return -1;}

        return 1;
    }


}
