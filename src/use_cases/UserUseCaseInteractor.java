package use_cases;

import entities.User;
import exceptions.*;
import use_cases.DataBaseAccess.UserDataInterface;
import java.util.*;
import java.util.regex.Pattern;


public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;

    public UserUseCaseInteractor(UserDataInterface userDataInterface) {
        this.userDataInterface = userDataInterface;
    }

    /**
     * Register a user if it is not present in the current database.
     * Returns the situation of registration
     *
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email",
     *             "Verification" and "isAdmin".
     * @return if successfully registered this student
     */
    public void createUser(Map<String, String> user, String code) {

        // Check if the user exists in Database.
        if (!userDataInterface.userExists(user.get("Username"))) {
            throw new DuplicationException("user");
        }

        // Check if the password is valid.
        if (!passwordCheck(user.get("Password"))) {
            throw new PasswordTooWeakException();
        }

        // Check if the reentered password is the same.
        if (!duoPasswordCheck(user.get("Password"), user.get("Re-entered Password"))) {
            throw new PasswordDoesNotMatchException();
        }

        // Check if the email is valid.
        if (!emailCheck(user.get("Email"))) {
            throw new InvalidFormatException("email");
        }

        // Check the email verification.
//        if (!code.equals(user.get("Verification"))) {
        if(false){
            throw new WrongPasswordException("verfication number");
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
        // Reverse the email.
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /**
     * Take in the email, and send a random verify number to the email.
     *
     * @param email email user provided.
     * @return if the email passes the verification.
     */
    public String verifyEmail(String email) {
//        Mailer mailer = new Mailer();
//        String code = randomStringGenerator();
//        mailer.send("QNAForumGroup140@gmail.com", "TheForum140", email, "Verification Code", code);
//
//        return code;
        return "123";
    }

    private String randomStringGenerator(){
        Random random = new Random();
        return Integer.toString(random.nextInt(1000000));
    }
    /**
     * This method reset the username of user.
     * If the new username is not in database, it resets username and returns true.
     * Otherwise, it returns false.
     *
     * @param user        information user provided.
     * @param newUsername the new username user wants to change.
     * @return if successfully change the password.
     */
    public boolean resetUsername(User user, String newUsername) {
        // If the given new username exists in database, return false.
        // Reset the password.
        userDataInterface.resetUsername(user, newUsername);
        return true;
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
    public boolean resetPassword(User user, String oldPassword, String newPassword) {
        // If the given new password does not meet the requirement, return false.
        if (!passwordCheck(newPassword)) {
            return false;
        } else if (!user.getPassword().equals(oldPassword)) {
            return false;
        }

        // Reset the password.
        userDataInterface.resetPassword(user.getUsername(), newPassword);
        return true;
    }
// I don't think we support this.
//    /**
//     * This method reset the email of user.
//     * If the new email is correct and passes the verification reset email and return true
//     * Otherwise, it returns false.
//     *
//     * @param user     information user provided.
//     * @param newEmail the new email user wants to change.
//     * @return if successfully change the email.
//     */
//    public boolean resetEmail(User user, String newEmail) {
//        //TODO: complete this method
//        //      If the email be verified successfully, return True and reset a new email and verify the new email.
//        //       the User's email is changed into DataBase(need to call the userDataInterface).
//        //      Otherwise, return False
//
//        // If the given new email does not meet the requirement, return false.
//        if (!emailCheck(newEmail)) {
//            return false;
//        }
//
//        // If the given new email does not pass the verification, return false.
//        if (!verifyEmail(newEmail)) {
//            return false;
//        }
//
//        userDataInterface.resetEmail(user, newEmail);
//        return true;
//    }


    /**
     * This removes a user from the current Database.
     * It first checks if the user exists, and removes it if so;
     * otherwise, it returns false.
     *
     * @param userName Relevant information of this user.
     * @return if successfully removed this user.
     */
    public boolean removeAUser(String userName) {

        // If the given user does not exist in the database, return false.
        if (!userDataInterface.userExists(userName)) {
            return false;
        }

        userDataInterface.deleteUser(userName);
        return true;

    }

    public boolean checkLogin(String userName, String password) {
        ArrayList<User> allUsers = userDataInterface.getAllUsers();
        User user = userDataInterface.getUser(userName);
        //for debug
        ArrayList<String> names = new ArrayList<>();

        for (User user_temp : allUsers) {
            names.add(user_temp.getUsername());
            names.add(user_temp.getPassword());
        }

        System.out.println(names);

        if (user == null) {
            throw new EntryNotFoundException("user");
        }

        if (!user.getPassword().equals(password)) {
            throw new WrongPasswordException("password");
        }
    return true;

    }
}
