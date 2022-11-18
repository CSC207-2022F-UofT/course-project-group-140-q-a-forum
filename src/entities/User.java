package entities;

public class User {

    private String username;
    private int userId;
    private String password;

    private String email;

    public User(){

    }

    /**
     * @param username
     * @param password
     * @param email
     */

    public User(String username, String password, String email){
        /**
         * Create a user account, with username, userid, and password.
         * userid is assigned by an usercase, and is IMMUTABLE
         */
        this.username = username;
//        this.userId = userid;
        this.password = password;
        this.email = email;

    }

    public String getUsername() {
        return this.username;
    }

    public int getUserID() {
        return this.userId;
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
}