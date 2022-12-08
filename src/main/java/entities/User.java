package entities;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private boolean isAdmin;

    private String email;

    private int likeNumber;
    private String reputation;

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
        this.likeNumber = 0;
        this.reputation = "Average";

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
        if (isAdmin != null){
            this.isAdmin = true;
        }
        this.reputation = "mod";

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

    public String getReputation(){
        return reputation;
    }

    public int getLikeNumber(){
        return likeNumber;
    }

    public void like(){
        this.likeNumber += 1;
        this.updateReputation();
    }

    public void dislike(){
        this.likeNumber -= 1;
        this.updateReputation();
    }

    public void updateReputation(){
        if (!isAdmin){
            if (likeNumber > 10){
                this.reputation = "Popular";
            }else if(likeNumber < -10){
                this.reputation = "Notorious";
            }else{
                this.reputation = "Average";
            }
        }
    }
}