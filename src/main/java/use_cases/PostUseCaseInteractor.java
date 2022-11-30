package use_cases;
import entities.Comment;
import exceptions.*;
import entities.Course;
import entities.Post;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PostUseCaseInteractor {

    private final CourseDataInterface courseDataInterface;
    public PostUseCaseInteractor(CourseDataInterface courseDataInterface) {
        this.courseDataInterface = courseDataInterface;
    }

    /**
     * Post a post using the given information.
     * If the post can be succesfully posted, create such entity and return Ture
     * If the process cannot be completed, return False
     * @param post_info A hash map that contains the information of the post. The keys must be "title",
     *                  "text", "user" and "course".
     */
    public void createPost(HashMap<String, Object> post_info){
        String title = post_info.get("title").toString();
        String text = post_info.get("text").toString();
        User postedBy = (User) post_info.get("user");
        Course course = (Course) post_info.get("course");
        boolean empty = checkPostValidity(title, text);
        boolean duplicate = courseDataInterface.postExists(course.getCode(), title);
        if (empty && !duplicate){
            Post new_post = new Post(title, text, postedBy, course);
            course.addPost(new_post);
        }
        else if(!empty) {
            throw new EmptyEntryException("title");
        }else{
            throw new DuplicationException("post");
        }
    }

    /**
     * Edit the given post using the post information.
     * Return true is the post can be edited, and false otherwise.
     * @param post_info
     * @return boo
     */
    public void editPost(HashMap<String, Object> post_info){
        String orgTitle = (String) post_info.get("orgTitle");
        Course course = (Course) post_info.get("course");
        if (checkTopicExist(course, orgTitle)){
            course.lookupPostFromTopic(orgTitle).modifyPost((String) post_info.get("title"), (String) post_info.get("text"));
        }
        else {
            throw new NotFoundException("Post");
        }

    }

    public void removePost(HashMap<String, Object> post_info){
        String title = post_info.get("title").toString();
        Course course = (Course) post_info.get("course");
        if (checkTopicExist(course, title)){
            course.removePost(course.lookupPostFromTopic(title));
        }
        else{
            throw new NotFoundException("Post");
        }
    }

    public boolean checkPostValidity(String title, String text){
        return title != "" & text != "" ;
    }
    public boolean checkTopicExist(Course course, String title){
        return course.lookupPostFromTopic(title) != null;
    }

    public ArrayList<Comment> getAllCommentFromPost(String courseCode, String postTopic){
        Post post = courseDataInterface.getPost(courseCode, postTopic);
        return post.getComments();
    }

    public ArrayList<Comment> getAllCommentFromComment(Comment comment){
        return comment.getComments();
    }

    public void makeCommentFromPost(Post post, User user, String content){
        Comment newComment = new Comment(content, user);
        if(content.equals("")){
            throw new EmptyEntryException("content");
        }
        post.addComment(newComment);
    }

}
