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
     *             "Username", "Password", "Re-entered Password", "Email",
     *             "Verification" and "isAdmin".
     * @return if successfully registered this student return 0,
     * if EmptyEntryException return -1,
     * if InvalidFormatException thrown by invalid password format return -2,
     * if InvalidFormatException thrown by invalid email format return -3,
     * if WrongInfoException thrown by reentered password does not match return -4,
     * if WrongInfoException thrown by wrong verification number return -5.
     */
    public int registerUser(Map<String, String> user, String correctVerification) {
        try {
            userUseCaseInteractor.createUser(user, correctVerification);
        } catch (DuplicationException e) {
            //A bunch of possible exceptions here, later I will add details.
            return -1;
        } catch (InvalidFormatException e) {
            String msg = e.getMessage();// Get the error message.
            if (msg.equals("The password is not formatted correctly.")) {
                return -2;
            }
            return -3;// Another situation catches InvalidFormatException is the error email format.
        } catch (WrongInfoException e) {
            String msg = e.getMessage();// get the error message.
            if (msg.equals("Wrong re-entered password !")) {
                return -4;
            }
            return -5;// Another situation catches WrongInfoException is the wrong verification number.
        }


        return 1;// Register succeed.
    }

    /**
     * Send a verification email the register user.
     *
     * @param email the email address the user provided.
     * @return if successfully send the email return verification code;
     * if the email format is wrong, return -1;
     * if message send failed, return -2;
     */
    public int sendEmail(String email) {
        try {
           return userUseCaseInteractor.sendEmail(email);
        } catch (InvalidFormatException e) {
            return -1;// Email format is not valid.
        } catch (Exception e) {
            return -2;// Fail to send the message.
        }


    }

    /**
     * Login the user
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
        } catch (WrongInfoException e) {
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
        try{return userUseCaseInteractor.getUser(userName);}
        catch (NotFoundException e){
            return null;
        }
    }

    /**
     * Change the Password of the User if the user knows their oldPassword and want to change it
     * @param user          User wait to be changed the password
     * @param oldPassword   String, the old password
     * @param newPassword   String, new Password
     * @param reenteredPassword String, make sure user doesn't type the wrong pass
     * @return  int
     *          1: change password successfully
     *          -1: Some entries left as empty
     *          -2: The new password is Invalid
     *          -3: Old password doesn't match the original pass
     *          -4: re-enter Password doesn't match new Password
     *
     *
     */
    public int changePassword(User user, String oldPassword, String newPassword, String reenteredPassword){
        try{ userUseCaseInteractor.resetPassword(user, oldPassword, newPassword, reenteredPassword);}
        catch(EmptyEntryException e){
            return -1;
        }
        catch (InvalidFormatException e){
            return -2;
        }
        catch (WrongInfoException e){
            String msg = e.getMessage();// get the error message.
            if (msg.equals("Wrong password !")) {
                return -3;
            }
            return -4;

        }
        return 1;
    }

    /**
     * Reset User's username through Profile Page
     * @param user          User The user who want to change the password
     * @param newUsername   String the userName which want to change
     * @return  int -1 Username already exists
     *              -2 Some entries are empty
     *              1 reset Username successfully
     */
    public int resetUsername(User user, String newUsername){
        try {
            userUseCaseInteractor.resetUsername(user, newUsername);
        }catch (DuplicationException e){
            return -1;
        }catch (EmptyEntryException e){
            return -2;
        }
            return 1;
        }

    }


