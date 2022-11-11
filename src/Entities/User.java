package Entities;

public class User {

    private String Username;
    private int UserID;
    private String Password;

    private boolean IsAdministrator;

    public User(){

    }

    /**
     * @param username
     * @param userid
     * @param password
     */

    public User(String username, int userid, String password){
        this.Username = username;
        this.UserID = userid;
        this.Password = password;
        this.IsAdministrator = false;
    }

    /**
     * @param username
     * @param userid
     * @param password
     * @param isAdministrator
     */

    public User(String username, int userid, String password, boolean isAdministrator){
        this.Username = username;
        this.UserID = userid;
        this.Password = password;
        this.IsAdministrator = isAdministrator;
    }

    public String getUsername() {
        return Username;
    }

    public int getUserID() {
        return UserID;
    }

    public String getPassword() {
        return Password;
    }

    public boolean isAdministrator() {
        return IsAdministrator;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }
}