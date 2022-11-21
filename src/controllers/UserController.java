package controllers;

import entities.User;
import exceptions.*;
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
     * @return if successfully registered this student return 0,
     *  if EmptyEntryException return -1,
     *  if InvalidFormatException return -2,
     *  if WrongPasswordException return -3.
     */
    public int registerUser(Map<String, String> user){
        try{
            userUseCaseInteractor.createUser(user);
        }catch (EmptyEntryException e){
            return -1;
        }catch (InvalidFormatException e) {
            return -2;
        }catch (DifferentPasswordException e){
            return -3;
        }
        return 0;

    }





    /**
     * this function registers the User
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student return 0,
     *  if EmptyEntryException return -1,
     *  if EmailVerifyException return -2,
     *  if WrongPasswordException return -3.
     */
    public int loginUser(User user, String password){
        try {
            loginUseCaseInteractor.checkLogin(user, password);
        }catch (WrongPasswordException e){
            return  -3;
            //Email verification exception
        }catch (EmailVerifyException e){
            return -2;
        }catch (EmptyEntryException e){
            return -1;
        }
        return  0;
    }
}