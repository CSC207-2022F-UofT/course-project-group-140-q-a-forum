package use_cases.DataBaseAccess;

import entities.User;

import java.util.ArrayList;

public interface UserDataInterface extends DataInterface{

    ArrayList<User> getData();

    /**
     * add a user in DataBase
     * @param user/
     */
    void addUser(User user);


    /**
     * add a user in DataBase
     * @param user/
     */
    void deleteUser(User user);

}
