package use_cases;
import entities.Comment;
import exceptions.*;
import entities.Course;
import entities.Post;
import entities.User;
import use_cases.DataBaseAccess.CourseDataInterface;


import java.io.IOException;
import java.util.List;
import java.util.HashMap;

public class PostUseCaseInteractor {

    private final CourseDataInterface courseDataInterface;

    public PostUseCaseInteractor(CourseDataInterface courseDataInterface) {
        this.courseDataInterface = courseDataInterface;
    }

    /**
     * Post a post using the given information.
     * If the post can be successfully posted, create such entity and return Ture
     * If the process cannot be completed, return False
     * @param post_info A hash map that contains the information of the post. The keys must be "title",
     *                  "text", "user" and "course".
     */
    public void createPost(HashMap<String, Object> post_info){
        String title = post_info.get("title").toString();
        String text = post_info.get("text").toString();
        User postedBy = (User) post_info.get("user");
        Course course = (Course) post_info.get("course");
        boolean notEmpty = checkPostValidity(title, text);
        boolean duplicate = courseDataInterface.postExists(course.getCode(), title);
        if (notEmpty && !duplicate){
            Post new_post = new Post(title, text, postedBy, course);
            course.addPost(new_post);
        }
        else if(!notEmpty) {
            throw new EmptyEntryException("title or content");
        }else{
            throw new DuplicationException("post");
        }

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Edit the given post using the post information.
     * Throws a NotFoundException if the original post cannot be found
     * @param post_info Information related to the post that we want to edit,
     *                  including new info
     */
    public void editPost(HashMap<String, Object> post_info){
        String orgTitle = (String) post_info.get("orgTitle");
        Course course = (Course) post_info.get("course");
        if (checkTopicExist(course, orgTitle)){
            System.out.println(course.lookupPostFromTopic(orgTitle).getTopic());
            System.out.println("here!");
            course.lookupPostFromTopic(orgTitle).modifyPost((String) post_info.get("title"),
                    (String) post_info.get("text"));
        }
        else {
            throw new NotFoundException("Post");
        }

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Remove the given post using the post information.
     * Throws a NotFoundException if the original post cannot be found
     * @param post_info Information related to the post that we want to edit,
     *                  including new info
     */
    public void removePost(HashMap<String, Object> post_info){
        String title = post_info.get("title").toString();
        Course course = (Course) post_info.get("course");
        if (checkTopicExist(course, title)){
            course.removePost(course.lookupPostFromTopic(title));
        }
        else{
            throw new NotFoundException("Post");
        }

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Check the post title and content are not all empty.
     * @param title The title of the post.
     * @param text The content of the post.
     * @return True if both of them are non-empty, false otherwise.
     */
    public boolean checkPostValidity(String title, String text){
        return !title.strip().equals("")  && !text.strip().equals("");
    }

    /**
     * Check the post with given title exists under the given course.
     * @param course The course under which the post should exist.
     * @param title The title of the post.
     * @return True if the post exists under the given course, false otherwise.
     */
    public boolean checkTopicExist(Course course, String title){
        return course.lookupPostFromTopic(title) != null;
    }

    /**
     * Get all comments from a post with given topic under given course.
     * @param courseCode The course code of the course under which the post exists.
     * @param postTopic The title of the post.
     * @return A list containing all comments from the post.
     */
    public List<Comment> getAllCommentFromPost(String courseCode, String postTopic){
        Post post = courseDataInterface.getPost(courseCode, postTopic);
        return post.getComments();
    }

    /**
     * Get all comments from a comment.
     * @param comment The comment whose comments are queried.
     * @return A list of comments from this comment.
     */
    public List<Comment> getAllCommentFromComment(Comment comment){
        return comment.getComments();
    }

    /**
     * Add a comment under a post.
     * @param post The post that the comment belongs to.
     * @param user The user who posted this post.
     * @param content The content of the post.
     */
    public void makeCommentFromPost(Post post, User user, String content){
        Comment newComment = new Comment(content, user);
        if(content.equals("")){
            throw new EmptyEntryException("content");
        }
        post.addComment(newComment);

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }

    }

    /**
     * Like a post.
     * @param post The post to be liked.
     * @param user The user that likes this post.
     */
    public void likePost(Post post, User user){
        if (post.getPostedBy() == user){
            return;
        }

        String email = user.getEmail();

        if (post.getLikeUser().contains(email)){
            throw new DuplicationException("like");
        }

        User author = post.getPostedBy();
        boolean found = post.getDislikeUser().contains(email);
        if (found){
            author.like();
        }


        author.like();
        post.like(email);

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    /**
     * Dislike a post.
     * @param post The post to be disliked.
     * @param user The user that dislikes this post.
     */
    public void dislikePost(Post post, User user) {
        if (post.getPostedBy() == user){
            return;
        }

        String email = user.getEmail();

        if (post.getDislikeUser().contains(email)) {
            throw new DuplicationException("dislike");
        }

        User author = post.getPostedBy();

        boolean found = post.getLikeUser().contains(email);
        if (found){
            author.dislike();
        }

        author.dislike();
        post.dislike(email);

        try{
            courseDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
