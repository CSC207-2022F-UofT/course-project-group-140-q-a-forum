package controllers;

import entities.User;
import exceptions.*;
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
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student return 0,
     *  if EmptyEntryException return -1,
     *  if InvalidFormatException return -2,
     *  if WrongPasswordException return -3.
     */
    public int registerUser(Map<String, String> user){
        try{
            userUseCaseInteractor.createUser(user);

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
        catch (WrongPasswordException e){
            return -2;
        }
        return 1;

    }

    /**
     * Find the user with UserName
     * @param userName  it is a string that stores the username
     * @return  if there is an user with the input username in the database, then
     *          return the user. Otherwise, return null.
     */
    public User getUser(String userName){
     return userUseCaseInteractor.getUser(userName);
    }




}
