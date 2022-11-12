package use_cases.DataBaseAccess;

import entities.Post;

import java.util.ArrayList;

public interface LoginDataInterface extends DataInterface{
    ArrayList<Post> getData();
}
