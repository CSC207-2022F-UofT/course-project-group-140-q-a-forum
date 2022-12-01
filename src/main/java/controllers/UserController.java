package controllers;

import entities.User;
import exceptions.*;
import use_cases.UserUseCaseInteractor;

import javax.mail.MessagingException;
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
     * if InvalidFormatException thrown by invalid password format return -2,
     * if InvalidFormatException thrown by invalid email format return -3,
     * if WrongInforException thrown by reentered password does not match return -4,
     * if WrongInforException thrown by wrong verification number return -5.
     */
    public int registerUser(Map<String, String> user) {

        try {
            userUseCaseInteractor.createUser(user);

        } catch (DuplicationException e) {
            //A bunch of possible exceptions here, later I will add details.

            return -1;
        } catch (InvalidFormatException e) {
            String msg = e.getMessage();// Get the error message.
            if (msg.equals("The password is not formatted correctly.")) {
                return -2;
            }
            return -3;// Another situation catches InvalidFormatException is the error email format.


        } catch (WrongInforException e) {
            String msg = e.getMessage();// get the error message.
            if (msg.equals("Wrong re-entered password !")) {
                return -4;
            }
            return -5;// Another situation catches WrongInforException is the wrong verification number.
        }


        return 1;// Register succeed.
    }

    /**
     * Send a verification email the register user.
     *
     * @param email the email address the user provided.
     * @return if successfully send the email return 0;
     * if the email format is wrong, return -1;
     * if message send failed, return -2;
     */
    public int sendEmail(String email) {
        try {
            userUseCaseInteractor.sendEmail(email);
        } catch (InvalidFormatException e) {
            return -1;// Email format is not valid.


        } catch (Exception e) {
            return -2;// Fail to send the message.

        }
        return 0;

    }


    /**
     * Login the user
     *
     * @param userName it is a string that stores the username
     *                 password  used to check whether the password match with username in the database
     * @param password This is the password we input
     * @return if the user do not exist, return -1;
     * if the username and password do not match, return -2;
     * if successfully login the user, return 1.
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