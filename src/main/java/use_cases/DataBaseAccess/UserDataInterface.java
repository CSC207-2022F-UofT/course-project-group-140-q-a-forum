package use_cases.DataBaseAccess;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserDataInterface extends DataInterface{

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

    boolean emailExists(String email);


    /**
     * delete a user in DataBase
     * @param user the user to be deleted.
     */
    void deleteUser(User user);

    /**
     * Change username of a user in DataBase
     * @param user     information user provided.
     * @param newUsername the new username user wants to change.
     */
    void resetUsername(User user, String newUsername);

    /**
     * Change password of a user in DataBase
     * @param user The user to changepassword
     * @param newPassword the new password to be changed.
     */
    void resetPassword(User user, String newPassword);
    
}
