package use_cases;

import entities.User;
import exceptions.*;
import use_cases.DataBaseAccess.UserDataInterface;

import java.io.IOException;
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

    //This constructor should only be used as for testing purposes.
    public UserUseCaseInteractor(UserDataInterface userDataInterface, String verificationCode) {
        this.userDataInterface = userDataInterface;
        this.verifyNum = verificationCode;
    }
    /**
     * Register a user if it is not present in the current database.
     * Returns the situation of registration
     *
     * @param user This is a Map that contains necessary information
     *             needed to register a user. The keys must be
     *             "Username", "Password", "Re-entered Password", "Email",
     *             "Verification" and "isAdmin".
     * @param correctVerification verification send to the user
     */
    public void createUser(Map<String, String> user, String correctVerification) throws RuntimeException {

        // Check if the user exists in Database.
        if (userDataInterface.userExists(user.get("Username"))) {
            throw new DuplicationException("user");
        }

        if (userDataInterface.emailExists(user.get("Email"))) {
            throw new DuplicationException("email");
        }

        // Check if the password is valid.
        if (passwordInvalid(user.get("Password"))) {
            throw new InvalidFormatException("password");
        }

        // Check if the reentered password is the same.
        if (duoPasswordInvalid(user.get("Password"), user.get("Re-entered Password"))) {
            throw new WrongInfoException("re-entered password");
        }

        // Check if the email is valid.
        if (emailInvalid(user.get("Email"))) {
            throw new InvalidFormatException("email");
        }

        // Check the email verification.
        if (!user.get("Verification").equals(correctVerification)) {
            throw new WrongInfoException("Verification number");
        }

        // Register a new user.
        if (user.get("isAdmin") != null) {
            User newUser = new User(user.get("Username"), user.get("Password"), user.get("Email"), "");
            userDataInterface.addUser(newUser);
        } else {
            // Register a new user.
            User newUser = new User(user.get("Username"), user.get("Password"), user.get("Email"));
            userDataInterface.addUser(newUser);
        }

        try{
            userDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    /**
     * This method check the password user entered.
     * If the password has at least 9 characters, all from numbers and letters and does not contain a comma, return true.
     * Otherwise, returns false.
     * @param password password user provided.
     * @return true if this password is invalid.
     */
    public boolean passwordInvalid(String password) {
        boolean containLetter = false;
        boolean containDigit = false;
        int length = password.length();

        for (int i = 0; i < length; i++) {
            char c = password.charAt(i);

            if (c == ','){
                return true;
            }

            if (!containDigit && Character.isDigit(c)){
                containDigit = true;
            }

            if (!containLetter && Character.isLetter(c)){
                containLetter = true;
            }
        }


        try{
            userDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

        return length <= 8 || !containLetter || !containDigit;
    }


    /**
     * Check the password and re-entered password
     * @param password          password user provided.
     * @param reenteredPassword password user provided for the second time.
     * @return true if these two passwords are not the same.
     */
    public boolean duoPasswordInvalid(String password, String reenteredPassword) {
        return !password.equals(reenteredPassword);
    }

    /**
     * This checks the email the user entered.Returns true if the email is from University of Toronto.
     * Otherwise, it returns false
     *
     * @param email email user provided.
     * @return true if the email entered is invalid.
     */
    private boolean emailInvalid(String email) {
        // Reverse the email.
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) return true;
        return !pat.matcher(email).matches();
    }

    /**
     * Send an email with "subject" and "content" to receiveMailAccount
     * @param email the email address to sent email.
     * @return verification Code
     *
     */
    public int sendEmail(String email) throws Exception {
        // Check the email format.
        if (emailInvalid(email)) {
            throw new InvalidFormatException("email");
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

        //Generate a random integer between 100000 and 999999 inclusive.
        Random rand = new Random();
        int code = rand.nextInt(900000) + 100000;
        String messagetosend = Integer.toString(code);
        // this.verifyNum = messagetosend; FOR DEBUG
        this.verifyNum = "100000";


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
        return code;
    }

    /**
     * Create a simple email containing only text
     * @param session     session with the server
     * @param sendMail    sender email
     * @param receiveMail recipient email
     * @param subject     "Verifying" or "Forget password"
     * @param content     The random 6-digit int value
     * @return message to send.
     * @throws Exception if fail to send a message.
     */
    public MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String subject, String content) throws Exception {
        // 1.Create a default MimeMessage object.
        MimeMessage message = new MimeMessage(session);

        // 2. Set From: header field of the header.
        message.setFrom(new InternetAddress(sendMail, "QAForum", "UTF-8"));

        // 3. Set To: header field of the header.
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX User", "UTF-8"));

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
     * Find the user with UserName
     *
     * @param userName it is a string that stores the username
     * @return if there is a user with the input username in the database, then
     * return the user. Otherwise, throw NotFoundException.
     */
    public User getUser(String userName) {
        if (userDataInterface.userExists(userName)) {
            return userDataInterface.getUser(userName);
        }
       throw new NotFoundException("user");
    }


    /**
     * This method reset the username of user.
     * If the new username is not in database, it resets username and returns true.
     * Otherwise, it returns false.
     * @param user        the user to change username.
     * @param newUsername the new username user wants to change.
     */
    public void resetUsername(User user, String newUsername) {
        boolean userExists = userDataInterface.userExists(newUsername);
        if (userExists){
            throw new DuplicationException("username");
        } else if (newUsername.strip().equals("")) {
            throw new EmptyEntryException("username");
        } else{
           userDataInterface.resetUsername(user, newUsername);
        }


        try{
            userDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }

    /**
     * This method reset the password of user.
     * If the new password meets the requirement, it resets password and returns true.
     * Otherwise, it returns false.
     *
     * @param user              the user request password change.
     * @param passwordInfo      the information regarding the updating of password. It is a hashmap containing the keys:
     *                          "oldPassword", "newPassword", and "reenteredPassword"
     */
    public void resetPassword(User user, HashMap<String, String> passwordInfo) throws RuntimeException {
        String oldPassword = passwordInfo.get("oldPassword");
        String newPassword = passwordInfo.get("newPassword");
        String reenteredPassword =  passwordInfo.get("reenteredPassword");
        if (oldPassword.equals("") || newPassword.equals("") || reenteredPassword.equals("")) {
            throw new EmptyEntryException("password");
        }
        // If the given new password does not meet the requirement, return false.
        if (passwordInvalid(newPassword)) {
            throw new InvalidFormatException("password");
            // Check if the two new password matches
        } else if (duoPasswordInvalid(newPassword, reenteredPassword)) {
            throw new WrongInfoException("re-entered password");
            // Check if the old password matches the password in database.
        } else if (!user.getPassword().equals(oldPassword)) {
            throw new WrongInfoException("password");
        }
        // Reset the password.
        userDataInterface.resetPassword(user, newPassword);


        try{
            userDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }

    /**
     * This removes a user from the current Database.
     * It first checks if the user exists, and removes it if so;
     * otherwise, it returns false.
     *
     * @param user user to be removed.
     */
    public void removeAUser(User user) {
        /*
        For future administrator use
         */

        // If the given user does not exist in the database, return false.
        if (!userDataInterface.userExists(user.getUsername())) {
            throw new NotFoundException("user");
        }

        userDataInterface.deleteUser(user);


        try{
            userDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * This checks the login status of a user.
     * It first checks if the user exists, and removes it if so;
     * otherwise, it returns false.
     *
     * @param userName username provided by the login user.
     * @param password password provided by the login user.
     */
    public void checkLogin(String userName, String password) throws RuntimeException {
        User user = userDataInterface.getUser(userName);
        if (user == null) {
            throw new NotFoundException("User");
        }
        if (!user.getPassword().equals(password)) {
            throw new WrongInfoException("password");
        }
    }


}
