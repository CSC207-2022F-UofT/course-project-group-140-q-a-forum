package use_cases.DataBaseAccess;

import entities.Post;

import java.util.ArrayList;

public interface LoginInterface extends DataInterface{
    ArrayList<Post> getData();
}
