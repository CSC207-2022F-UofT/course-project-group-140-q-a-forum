package entities;

public class User {

    private String username;
    private String password;
    private boolean isAdmin;

    private String email;

    public User() {

    }

    /**
     * Create a normal user account, with username, password, and the email.
     * userid is assigned by an usercase, and is IMMUTABLE
     * @param username the name of the user created
     * @param password the password that set up by user
     * @param email the email address input by user
     */

    public User(String username, String password, String email) {
        this.username = username;

        this.password = password;
        this.email = email;
        this.isAdmin = false;

    }

    /**
     * Create an admin user account, with username, password, and the email,
     * and isAdmin
     * userid is assigned by an usercase, and is IMMUTABLE
     * @param username the name of the user created
     * @param password the password that set up by user
     * @param email the email address input by user
     * @param isAdmin the status of admin of the user
     */
    public User(String username, String password, String email, String isAdmin) {

        this.username = username;

        this.password = password;
        this.email = email;
        this.isAdmin = true;

    }

    /**
     * Extract the name of the user
     * @return the string that represents the name of the user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Extract the email that set up by the user
     * @return the string email under the user information
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Get the user password
     * @return A string that indicate the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set up the username
     * @param username the name wants to be called in the system
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set up the password
     * @param password password that created by the user to protect their account
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Check whether the account's status is admin
     * @return A boolean value representing whether the user is admin
     */
    public boolean isAdmin() {
        return isAdmin;
    }
}