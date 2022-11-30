package use_cases;

import entities.User;
import exceptions.*;
import use_cases.DataBaseAccess.UserDataInterface;

import java.util.*;
import java.util.regex.Pattern;
import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;
    private String verifyNum;


    public UserUseCaseInteractor(UserDataInterface userDataInterface) {
        this.userDataInterface = userDataInterface;
    }

    /**
     * Register a user if it is not present in the current database.
     * Returns the situation of registration
     *
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email", and "isAdmin".
     * @return if successfully registered this student
     */
    public void createUser(Map<String, String> user) throws RuntimeException {

        // Check if the user exists in Database.
        if (!userDataInterface.userExists(user.get("Username"))) {
            throw new DuplicationException("user");
        }

        // Check if the password is valid.
        if (!passwordCheck(user.get("Password"))) {
            throw new InvalidFormatException("password");
        }

        // Check if the reentered password is the same.
        if (!duoPasswordCheck(user.get("Password"), user.get("Re-entered Password"))) {
            throw new WrongInforException("re-entered password");
        }

        // Check if the email is valid.
        if (!emailCheck(user.get("Email"))) {
            throw new InvalidFormatException("email");
        }

        // Check the email verification.
        if (!verifyEmail(user.get("Verfication"))) {
            throw new WrongInforException("verfication number");
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
     * Send an email with "subject" and "content" to receiveMailAccount
     *
     * @param email the email address to sent email.
     * @throws Exception
     */
    public void sendEmail(String email) throws Exception {
        // Check the email format.
        if (!emailCheck(email)) {
            throw new RuntimeException("");
        }

        // 1. Create parameter configuration
        Properties props = new Properties();                    // parameter configuration
        props.setProperty("mail.transport.protocol", "smtp");   // The protocol to use (required by the JavaMail)
        props.setProperty("mail.smtp.host", "smtp.qq.com");   // The SMTP server address of the sender's mailbox
        props.setProperty("mail.smtp.auth", "true");            //request authentication


        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);


        // 2. Create a session object according to the configuration for interacting with the mail server
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // Set to debug mode, view detailed sending log

        //Generate a verification code.
        int num = (int) (Math.random() * 90000) + 100000;
        String messagetosend = Integer.toString(num);
        this.verifyNum = messagetosend;


        // 3. Create a email.
        MimeMessage message = createMimeMessage(session, "3232085039@qq.com", email, "Verify", messagetosend);

        // 4. Get transport  object from Session
        Transport transport = session.getTransport();

        // 5. Connect email.
        transport.connect("3232085039@qq.com", "cwuwfmohzmvddbfa");

        // 6. Send email
        transport.sendMessage(message, message.getAllRecipients());

        // 7. Close connect
        transport.close();
    }

    /**
     * Create a simple email containing only text
     *
     * @param session     session with the server
     * @param sendMail    sender email
     * @param receiveMail recipient email
     * @param subject     "Verifying" or "Forget password"
     * @param content     The random 6-digit int value
     * @return message to send.
     * @throws Exception
     */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String subject,
                                                String content) throws Exception {
        // 1.Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // 2. Set From: header field of the header.
        message.setFrom(new InternetAddress(sendMail, "QAForum", "UTF-8"));

        // 3. Set To: header field of the header.
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Set Subject to send.
        message.setSubject(subject, "UTF-8");

        // 5. Set Content to send.
        message.setContent(content, "text/html;charset=UTF-8");

        // 6. Set send time.
        message.setSentDate(new Date());

        // 7. Save changes.
        message.saveChanges();

        return message;
    }

    /**
     * Take in the email, and send a random verify number to the email.
     *
     * @param verifyNumber verify number user provided.
     * @return if the verify number is the same as verifyNum generated.
     */
    public boolean verifyEmail(String verifyNumber) {
        return verifyNumber.equals(verifyNum);
    }


    /**
     * Find the user with UserName
     *
     * @param userName it is a string that stores the username
     * @return if there is an user with the input username in the database, then
     * return the user. Otherwise, throw NotFoundException.
     */
    public User getUser(String userName) {
        if (!userDataInterface.userExists(userName)) {
            return userDataInterface.getUser(userName);
        }
        return null;
    }


    /**
     * This method reset the username of user.
     * If the new username is not in database, it resets username and returns true.
     * Otherwise, it returns false.
     *
     * @param user        the user to change username.
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
     * @param user              the user request password change.
     * @param oldPassword       the old password user wants to change.
     * @param newPassword       the new password user wants to change to.
     * @param reenteredPassword reentered new password.
     * @return if successfully change the password.
     */
    public void resetPassword(User user, String oldPassword, String newPassword, String reenteredPassword) throws
            RuntimeException{
        if (oldPassword.equals("")||newPassword.equals("")||reenteredPassword.equals("")){
            throw new EmptyEntryException("password");
        }
        // If the given new password does not meet the requirement, return false.
        if (!passwordCheck(newPassword)) {
            throw new InvalidFormatException("password");
            // Check if the two new password matches
        } else if (!duoPasswordCheck(newPassword,reenteredPassword)) {
            throw new WrongInforException("re-entered password");
            // Check if the old password matches the password in database.
        } else if (!user.getPassword().equals(oldPassword)) {
            throw new WrongInforException("password");
        }

        // Reset the password.
        userDataInterface.resetPassword(user.getUsername(), newPassword);

    }

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
    /**
     * This checks the login status of a user.
     * It first checks if the user exists, and removes it if so;
     * otherwise, it returns false.
     *
     * @param userName username the user provide.
     * @param password password the user provide.
     * @return if successfully login this user.
     */
    public boolean checkLogin(String userName, String password) throws RuntimeException{
        User user = userDataInterface.getUser(userName);
        if (user == null) {
            throw new NotFoundException("User");
        }

        if (!user.getPassword().equals(password)) {
            throw new WrongInforException("password");
        }
        return true;

    }


}
