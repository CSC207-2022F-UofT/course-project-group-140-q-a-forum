package use_cases;
import exceptions.*;
import entities.Course;
import entities.Post;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;
import use_cases.DataBaseAccess.PostDataInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PostUseCaseInteractor {

    final CourseDataInterface courseDataInterface;

    public PostUseCaseInteractor(CourseDataInterface courseDataInterface) {
        this.courseDataInterface = courseDataInterface;
    }

    /**
     * Post a post using the given information.
     * If the post can be succesfully posted, create such entity and return Ture
     * If the process cannot be completed, return False
     * @param post_info
     * @return 0 if successfully created, 1 if not
     */

    public void createPost(HashMap<String, Object> post_info){
        String title = post_info.get("title").toString();
        String text = post_info.get("text").toString();
        ArrayList<Image> images = (ArrayList<Image>) post_info.get("images");
        User postedBy = (User) post_info.get("user");
        Course course = (Course) post_info.get("course");
        boolean valid = checkPostValidity(title, text);
        if (valid){
            Post new_post = new Post(title, text, images, postedBy, course);
            course.addPost(new_post);
        }
        else {
            throw new EmptyEntryException("title");
        }
    }

    /**
     * Edit the given post using the post information.
     * Return true is the post can be edited, and false otherwise.
     * @param post_info
     * @return boo
     */

    public void editPost(HashMap<String, Object> post_info){
        //TODO
        return;
    }

    public boolean checkPostValidity(String title, String text){
        return title != "" & text != "" ;
    }

}
