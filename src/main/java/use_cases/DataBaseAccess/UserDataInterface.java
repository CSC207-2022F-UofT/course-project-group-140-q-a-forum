package use_cases.DataBaseAccess;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserDataInterface extends DataInterface{

    void save();

    ArrayList<User> getAllUsers();

    User getUser(String userName);
    /**
     * add a user in DataBase
     * @param user/
     */
    void addUser(User user);

    /**
     * checks if a user exists in the current database.
     * @param userName relevant information of the user to check existence.
     * @return if this user exists in the current database.
     */
    boolean userExists(String userName);


    /**
     * delete a user in DataBase
     * @param userName the name of user to be deleted.
     */
    void deleteUser(String userName);

    /**
     * Change username of a user in DataBase
     * @param user     information user provided.
     * @param newUsername the new username user wants to change.
     */
    void resetUsername(User user, String newUsername);

    /**
     * Change password of a user in DataBase
     * @param userName the password of which to be changed.
     * @param newPassword the new password to be changed.
     */
    void resetPassword(String userName, String newPassword);
    
}
