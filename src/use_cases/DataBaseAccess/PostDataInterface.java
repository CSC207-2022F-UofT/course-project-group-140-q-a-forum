package use_cases.DataBaseAccess;

import entities.Comment;
import entities.Post;
import entities.PostInfo;

import java.util.ArrayList;

public interface PostDataInterface extends DataInterface{
    ArrayList<Post> getData();

    void addPost(PostInfo info);

    void editPost(Post post, PostInfo info);

    void removePost(Post post);

    void addComment(Post post, Comment comment);

    void removeComment(Post post, Comment comment);

}