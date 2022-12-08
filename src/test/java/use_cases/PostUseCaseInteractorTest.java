package use_cases;

import static org.junit.jupiter.api.Assertions.*;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseGateway;
import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.CourseUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.io.File;
import java.util.HashMap;

public class PostUseCaseInteractorTest {
    private final DatabaseGateway gateway = new DatabaseGateway();

    private final  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway, "DebugCode");
    private final CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    private final PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    private final CourseController courseController = new CourseController(courseInteractor);
    private final PostController postController = new PostController(postInteractor);
    private final UserController userController = new UserController(userInteractor);

    @BeforeEach
    public void setUp() {
        File orgFile = new File("data.ser");
        File newFile = new File("protected_data.ser");
        if (orgFile.exists()) {
            orgFile.renameTo(newFile);
        }
        HashMap<String, String> user = new HashMap<>();
        user.put("Username", "admin");
        user.put("Password", "QNAForum140");
        user.put("Re-entered Password", "QNAForum140");
        user.put("Email", "3232085039@qq.com");
        user.put("isAdmin", "True");
        user.put("Verification", "DebugCode");
        userController.registerUser(user, "DebugCode");

        HashMap<String, String> course = new HashMap<>();
        course.put("Name", "Introduction to Software Design");
        course.put("Course Code", "CSC207");
        course.put("Description", "An Introduction to Software Design");
        course.put("Semester", "Fall");
        course.put("Instructors", "Charlie");
        courseController.registerCourse(course);

        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("title", "Test");
        postInfo.put("text", "A meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        postController.createPost(postInfo);
    }

    @Test
    void createPostNoTitle(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("title", "");
        postInfo.put("text", "A meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(-1, postController.createPost(postInfo));
    }

    @Test
    void createDuplicatePost(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("title", "Test");
        postInfo.put("text", "A meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(-2, postController.createPost(postInfo));
    }

    @Test
    void createSucessPost(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("title", "Test2");
        postInfo.put("text", "Second meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(1, postController.createPost(postInfo));
    }

    @Test
    // try to edit a post that is not in the database
    void editPostNotIn(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("orgTitle", "Test2");
        postInfo.put("title", "NewTest");
        postInfo.put("text", "Second meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(-1, postController.editPost(postInfo));
        assertEquals("Test", courseController.getAllPosts("CSC207").get(0).getTopic());
        assertEquals("A meaningful question", courseController.getAllPosts("CSC207").get(0).getTexts());

    }

    @Test
    // try to edit a post successfully
    void editPostSuccessfully(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("orgTitle", "Test");
        postInfo.put("title", "Test2");
        postInfo.put("text", "Second meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(0, postController.editPost(postInfo));
        assertEquals("Test2", courseController.getAllPosts("CSC207").get(0).getTopic());
        assertEquals("Second meaningful question", courseController.getAllPosts("CSC207").get(0).getTexts());

    }

    @Test
    // try to remove a post that is not in the database
    void removePostNotIn(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("title", "Test2");
        postInfo.put("text", "A meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(1, postController.createPost(postInfo));
    }

    @Test
    //Try to remove a post successfully
    void removePostSuccessfully(){
        HashMap<String, Object> postInfo = new HashMap<>();
        postInfo.put("title", "Test");
        postInfo.put("text", "A meaningful question");
        postInfo.put("user", userController.getUser("admin"));
        postInfo.put("course", courseController.getAllCourses().get(0));
        assertEquals(-2, postController.createPost(postInfo));
    }

    @Test
    void likePostSuccess(){
        User user = userController.getUser("admin");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.likePost(post, user);
        assertEquals(1,user.getLikeNumber());
        assertEquals(1, post.getLikeNumber());
    }

    @Test
    void likePostDuplicate(){
        User user = userController.getUser("admin");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.likePost(post, user);

        assertEquals(-1, postController.likePost(post, user));
        assertEquals(1, user.getLikeNumber());
        assertEquals(1, post.getLikeNumber());
    }
    @Test
    void dislikePostSuccess(){
        User user = userController.getUser("admin");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.dislikePost(post, user);
        assertEquals(-1, user.getLikeNumber());
        assertEquals(-1, post.getLikeNumber());
    }

    @Test
    void dislikePostDuplicate(){
        User user = userController.getUser("admin");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.dislikePost(post, user);

        assertEquals(-1, postController.dislikePost(post, user));
        assertEquals(-1, user.getLikeNumber());
        assertEquals(-1, post.getLikeNumber());
    }

    @Test
    void dislikeToLike(){
        User user = userController.getUser("admin");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.dislikePost(post, user);
        postController.likePost(post, user);

        assertEquals(1, user.getLikeNumber());
        assertEquals(1, post.getLikeNumber());
    }

    @Test
    void likeToDislike(){
        User user = userController.getUser("admin");
        Post post = courseController.getAllPosts("CSC207").get(0);

        postController.likePost(post, user);
        postController.dislikePost(post, user);

        assertEquals(-1, user.getLikeNumber());
        assertEquals(-1, post.getLikeNumber());
    }

    @AfterEach
    public void tearDown(){
        File orgFile = new File("protected_data.ser");
        File newFile = new File("data.ser");

        newFile.delete();

        if (orgFile.exists()) {
            orgFile.renameTo(newFile);
        }
    }
}
