package use_cases;

import entities.User;
import exceptions.*;
import use_cases.DataBaseAccess.UserDataInterface;

import java.util.*;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;
    private String verificationnum;

    public UserUseCaseInteractor(UserDataInterface userDataInterface) {
        this.userDataInterface = userDataInterface;
    }

    /**
     * Register a user if it is not present in the current database.
     * Returns the situation of registration
     *
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", "Verification code", and "isAdmin".
     * @return if successfully registered this student
     */
    public void createUser(Map<String, String> user) {

        // Check if the user exists in Database.
        if (userDataInterface.userExists(user)) {
            throw new DuplicationException("user");
        }

        // Check if the username is empty or an email format.
        if (usernameCheck(user.get("Username")) == 0) {
            throw new EmptyEntryException("Username");
        } else if (usernameCheck(user.get("Username")) == 1) {
            throw new EmailFormatException("Username");
        }


        // Check if the password is valid.
        if (!passwordCheck(user.get("Password"))) {
            throw new WrongPasswordException("password");
        }

        // Check if the reentered password is the same.
        if (!duoPasswordCheck(user.get("Password"), user.get("Re-entered Password"))) {
            throw new WrongPasswordException("password");
        }

        // Check if the email is valid.
        if (user.get("Email") == null) {
            throw new EmptyEntryException("email");
        } else if (!emailCheck(user.get("Email"))) {
            throw new InvalidFormatException("email");
        }

        // Check the email verification.

        if (!verifyEmail(user.get("Verification"))) {
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
        //TODO: complete this method
        //      If the passwords entered meets the requirement, return True
        //      Otherwise, return False.

        // Check if the length of the password is greater than 8.
        if (password.length() < 8) {
            return false;
        } else {
            char c;
            int count = 1;
            for (int i = 0; i < password.length() - 1; i++) {
                c = password.charAt(i);

                // Check if password has ','
                if (c == ',') {
                    return false;

                } else if (Character.isDigit(c)) {
                    count++; //Get the number of numbers in password

                    //Check if the password has at least 2 numbers
                    if (count < 2) {
                        return false;

                        // Check if the password are all numbers.
                    } else if (count == password.length()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Check the username the user entered.
     *
     * @param username username user provided.
     * @return the username is an email address.
     */
    public int usernameCheck(String username) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        // Check if the username is null.
        if (username == null) {
            return 0;
        } else if (pat.matcher(username).matches()) {
            return 1;
        }
        return -1;
    }


    /**
     * Check the password and re-entered password
     *
     * @param password          password user provided.
     * @param reenteredpassword password user provided for the second time.
     * @return if the two password entered is equal.
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
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        return pat.matcher(email).matches();
    }

    /**
     * Take in the email, and send a random verify number to the email.
     *
     * @param email email user provided.
     */
    public void sendVerificationEmail(String email) {
        //TODO: complete this method
        //      If the verify number be verified successfully, return True
        //      Otherwise, return False

        // Send verification email.
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID needs to be mentioned
        String from = "web@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Your verification number is");

            // Generate a verification code.
            int num = (int) (Math.random() * 90000) + 100000;
            String messagetosend = Integer.toString(num);
            this.verificationnum = messagetosend;

            // Now set the actual message
            message.setText(messagetosend);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");


        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    /**
     * Take in the email, and send a random verify number to the email.
     *
     * @param verification email user provided.
     */
    public boolean verifyEmail(String verification) {
        return verification == verificationnum;
    }


    /**
     * This method reset the username of user.
     * If the new username is not in database, it resets username and returns true.
     * Otherwise, it returns false.
     *
     * @param user        information user provided.
     * @param newUsername the new username user wants to change.
     */
    public void resetUsername(Map<String, String> user, String newUsername) {
        //TODO: complete this method
        //      If the password be verified successfully, return True and
        //      reset a new password. the User's password is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False

        ArrayList<User> users = userDataInterface.getData();

        // If the given new username exists in database, return false.
        for (User people : users) {
            if (people.getUsername().equals(newUsername)) {
                throw new DuplicationException("user");
            }
        }

        // Reset the password.
        userDataInterface.resetUsername(user, newUsername);
    }


    /**
     * This method reset the password of user.
     * If the new password meets the requirement, it resets password and returns true.
     * Otherwise, it returns false.
     *
     * @param user        information user provided.
     * @param newPassword the new password user wants to change.
     */
    public void resetPassword(Map<String, String> user, String newPassword) {
        //TODO: complete this method
        //      If the password be verified successfully, return True and
        //      reset a new password. the User's password is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False

        // If the given new password does not meet the requirement, return false.
        if (!passwordCheck(newPassword)) {
            throw new WrongPasswordException("password");
        }

        // Reset the password.
        userDataInterface.resetPassword(user, newPassword);
    }

    /**
     * This method reset the email of user.
     * If the new email is correct and passes the verification reset email and return true
     * Otherwise, it returns false.
     *
     * @param user     information user provided.
     * @param newEmail the new email user wants to change.
     */
    public void resetEmail(Map<String, String> user, String newEmail) {
        //TODO: complete this method
        //      If the email be verified successfully, return True and reset a new email and verify the new email.
        //       the User's email is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False

        // If the given new email does not meet the requirement, return false.
        if (!emailCheck(newEmail)) {
            throw new InvalidFormatException("email");
        }

        // If the given new email does not pass the verification, return false.
        if (!verifyEmail(newEmail)) {
            throw new WrongPasswordException("verfication number");
        }

        userDataInterface.resetEmail(user, newEmail);

    }


    /**
     * This removes a user from the current Database.
     * It first checks if the user exists, and removes it if so;
     * otherwise, it returns false.
     *
     * @param user Relevant information of this user.
     */
    public void removeAUser(User user) {

        userDataInterface.deleteUser(user);

    }


}
