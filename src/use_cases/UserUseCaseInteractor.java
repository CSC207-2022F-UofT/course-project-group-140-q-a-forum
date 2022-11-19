package use_cases;

import entities.User;
import use_cases.DataBaseAccess.UserDataInterface;

import java.util.*;


public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;

    public UserUseCaseInteractor(UserDataInterface userDataInterface) {
        this.userDataInterface = userDataInterface;
    }

    /**
     * Register a user if it is not present in the current database.
     * Returns the situation of registration.
     *
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student
     */
    public String createUser(Map<String, String> user) {

        // Check if the user exists in Database.
        if (userDataInterface.userExists(user)) {
            return "UsernameError";
        }

        // Check if the password is valid.
        if (!passwordCheck(user.get("password"))) {
            return "PasswordValidError";
        }

        // Check if the reentered password is the same.
        if (!duoPasswordCheck(user.get("Password"), user.get("Re-entered Password"))) {
            return "ReEnterError";
        }

        // Check if the email is valid.
        if (!emailCheck(user.get("Email"))) {
            return "EmailError";
        }

        // Check the email verification.
        if (!verifyEmail(user.get("email"))) {
            return "VerificationError";
        }

        // Register a new user.
        if (user.get("isAdmin") != null) {
            User newUser = new User(user.get("Username"), user.get("Password"),
                    user.get("Email"), "");
            userDataInterface.addUser(newUser);
        } else {
            // Register a new user.
            User newUser = new User(user.get("Username"), user.get("Password"),
                    user.get("Email"));
            userDataInterface.addUser(newUser);

        }


        return "RegisterSuccess";
    }


    /**
     * This method check the password user entered.
     * If the password meets the requirement, return true.
     * Otherwise, returns false.
     *
     * @param password information user provided.
     * @return if the password includes numbers, letters, and at least one upper letter.
     */
    public boolean passwordCheck(String password) {
        //TODO: complete this method
        //      If the passwords entered meets the requirement, return True
        //      Otherwise, return False.

        // Check if the length of the password is greater than 8.
        return password.length() > 8;
    }


    /**
     * Check the password and re-entered password
     *
     * @param password          password user provided.
     * @param reenteredpassword password user provided for the second time.
     * @return boo
     */
    public boolean duoPasswordCheck(String password, String reenteredpassword) {
        //TODO: complete this method
        //      If the two passwords entered is not the same, return False
        //      Otherwise, return True
        return password.equals(reenteredpassword);

    }

    /**
     * This checks the email the user entered.Returns true if the email is from University of Toronto.
     * Otherwise, it returns false
     *
     * @param email email user provided.
     * @return if the email entered is valid.
     */

    private boolean emailCheck(String email) {
        StringBuilder email2 = new StringBuilder(email);

        // Reverse the email.
        email2.reverse();

        return email2.substring(0, 17).equals("ac.otnorotu.liam@");
    }

    /**
     * Take in the email, and send a random verify number to the email.
     *
     * @param email email user provided.
     * @return if the email passes the verification.
     */
    public boolean verifyEmail(String email) {
        //TODO: complete this method
        //      If the verify number be verified successfully, return True
        //      Otherwise, return False

        return false;
    }


    /**
     * This method reset the password of user.
     * If the new password meets the requirement, it resets password and returns true.
     * Otherwise, it returns false.
     *
     * @param user        information user provided.
     * @param newPassword the new password user wants to change.
     * @return if successfully change the password.
     */
    public boolean resetPassword(Map<String, String> user, String newPassword) {
        //TODO: complete this method
        //      If the password be verified successfully, return True and
        //      reset a new password. the User's password is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False

        // If the given new password does not meet the requirement, return false.
        if (!passwordCheck(newPassword)) {
            return false;
        }

        // Reset the password.
        userDataInterface.resetPassword(user, newPassword);
        return true;
    }

    /**
     * This method reset the email of user.
     * If the new email is correct and passes the verification reset email and return true
     * Otherwise, it returns false.
     *
     * @param user     information user provided.
     * @param newEmail the new email user wants to change.
     * @return if successfully change the email.
     */
    public boolean resetEmail(Map<String, String> user, String newEmail) {
        //TODO: complete this method
        //      If the email be verified successfully, return True and reset a new email and verify the new email.
        //       the User's email is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False

        // If the given new email does not meet the requirement, return false.
        if (!emailCheck(newEmail)) {
            return false;
        }

        // If the given new email does not pass the verification, return false.
        if (!verifyEmail(newEmail)) {
            return false;
        }

        userDataInterface.resetEmail(user, newEmail);
        return true;
    }


    /**
     * This removes a user from the current Database.
     * It first checks if the user exists, and removes it if so;
     * otherwise, it returns false.
     *
     * @param user Relevant information of this user.
     * @return if successfully removed this user.
     */
    public boolean removeAUser(Map<String, String> user) {

        // If the given user does not exist in the database, return false.
        if (!userDataInterface.userExists(user)) {
            return false;
        }

        userDataInterface.deleteUser(user.get("Username"));
        return true;
    }
}
