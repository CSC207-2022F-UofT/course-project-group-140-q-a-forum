package use_cases.DataBaseAccess;

import entities.User;

import java.util.ArrayList;

public interface LoginDataInterface extends DataInterface{
    ArrayList<User> getData();
}
