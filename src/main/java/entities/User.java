package entities;

public class User {

    private String username;
    private String password;
    private boolean isAdmin;

    private String email;

    public User() {

    }

    /**
     * Create a user account, with username, userid, and password.
     * @param username The username of the user.
     * @param password The password of the user.
     * @param email The email of the user.
     */

    public User(String username, String password, String email) {
        this.username = username;

        this.password = password;
        this.email = email;
        this.isAdmin = false;

    }


    public User(String username, String password, String email, String isAdmin) {
        /**
         * Create a user account, with username, userid, and password.
         * userid is assigned by an usercase, and is IMMUTABLE
         */
        this.username = username;

        this.password = password;
        this.email = email;
        this.isAdmin = true;

    }


    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}