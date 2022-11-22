package use_cases;
import exceptions.*;
import entities.Course;
import entities.Post;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PostUseCaseInteractor {


    public PostUseCaseInteractor() {
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
        //TODO: rememeber to pass THE ORIGINAL POST INFORMATION (i.e, orgTitle)!!!1
        String orgTitle = (String) post_info.get("orgTitle");
        Course course = (Course) post_info.get("course");
        if (checkTopicExist(course, orgTitle)){
            course.lookupPostFromTopic(orgTitle).modifyPost((String) post_info.get("title"), (String) post_info.get("text"),
                    (ArrayList<Image>) post_info.get("images"));
        }
        else {
            throw new EntryNotFoundException("Post");
        }

    }

    public void removePost(HashMap<String, Object> post_info){
        String title = post_info.get("title").toString();
        Course course = (Course) post_info.get("course");
        if (checkTopicExist(course, title)){
            course.removePost(course.lookupPostFromTopic(title));
        }
        else{
            throw new EntryNotFoundException("Post");
        }
    }





    public boolean checkPostValidity(String title, String text){
        return title != "" & text != "" ;
    }
    public boolean checkTopicExist(Course course, String title){
        return course.lookupPostFromTopic(title) != null;
    }


}
