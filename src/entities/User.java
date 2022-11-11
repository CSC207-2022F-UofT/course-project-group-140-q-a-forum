package entities;

public class User {

    private String username;
    private int userId;
    private String password;

    public User(){

    }

    /**
     * @param username
     * @param userid
     * @param password
     */

    public User(String username, int userid, String password){
        this.username = username;
        this.userId = userid;
        this.password = password;
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