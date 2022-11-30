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
     *
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student return 0,
     * if EmptyEntryException return -1,
     * if InvalidFormatException return -2 or -3,
     * if WrongInforException return -4 or -5.
     */
    public int registerUser(Map<String, String> user) {

        try {
            userUseCaseInteractor.createUser(user);

        } catch (DuplicationException e) {
            //A bunch of possible exceptions here, later I will add details.

            return -1;
        } catch (InvalidFormatException e) {
            String msg = e.getMessage();
            if (msg.equals("password")){return -2;}
            return -3;


        } catch (WrongInforException e) {
            String msg = e.getMessage();
            if (msg.equals("re-entered password")){return -4;}
            return -5;
        }


        return 1;
    }



    /**
     * Login the user
     *
     * @param userName it is a string that stores the username
     *                 password  used to check whether the password match with username in the database
     * @param password This is the password we input
     * @return the string "Correct Password" or "Wrong Password"
     */

    public int loginUser(String userName, String password) {
        try {
            userUseCaseInteractor.checkLogin(userName, password);
        } catch (NotFoundException e) {
            return -1;
        } catch (WrongInforException e) {
            return -2;
        }
        return 1;

    }

    /**
     * Find the user with UserName
     *
     * @param userName it is a string that stores the username
     * @return if there is a user with the input username in the database, then
     * return the user. Otherwise, return null.
     */
    public User getUser(String userName) {
        return userUseCaseInteractor.getUser(userName);
    }


}