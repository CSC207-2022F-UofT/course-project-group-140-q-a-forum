package use_cases;

import static org.junit.jupiter.api.Assertions.*;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseDataHandler;
import database.DatabaseGateway;
import database.RuntimeDataHandler;
import entities.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.HashMap;

public class PostUseCaseInteractorTest {
    static RuntimeDataHandler<Object> dataHandler;
    static DatabaseDataHandler databaseDataHandler;
    static DatabaseGateway gateway;

    static  UserUseCaseInteractor userInteractor;
    static CourseUseCaseInteractor courseInteractor;
    static PostUseCaseInteractor postInteractor;

    static CourseController courseController;
    static PostController postController;
    static UserController userController;

    @BeforeEach
    public void setUp() {

        System.out.println("TEST");

        dataHandler = new RuntimeDataHandler<Object>();
        databaseDataHandler = new DatabaseDataHandler();
        gateway = new DatabaseGateway(dataHandler, databaseDataHandler);

        userInteractor = new UserUseCaseInteractor(gateway, "DebugCode");
        courseInteractor = new CourseUseCaseInteractor((gateway));
        postInteractor = new PostUseCaseInteractor(gateway);

        courseController = new CourseController(courseInteractor);
        postController = new PostController(postInteractor);
        userController = new UserController(userInteractor);

        File orgFile = new File("data.ser");
        File newFile = new File("protected_data.ser");
        if (orgFile.exists()) {
            if (! orgFile.renameTo(newFile)){
                System.err.println("File not found!");
            }
        }
        HashMap<String, String> user = new HashMap<>();
        user.put("Username", "admin");
        user.put("Password", "QNAForum140");
        user.put("Re-entered Password", "QNAForum140");
        user.put("Email", "3232085039@qq.com");
        user.put("isAdmin", "True");
        user.put("Verification", "DebugCode");
        userController.registerUser(user, "DebugCode");


        HashMap<String, String> user2 = new HashMap<>();
        user2.put("Username", "admin2");
        user2.put("Password", "QNAForum140");
        user2.put("Re-entered Password", "QNAForum140");
        user2.put("Email", "loveblairsky@gmail.com");
        user2.put("Verification", "DebugCode");
        userController.registerUser(user2, "DebugCode");

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
        System.out.println(courseController.getAllCourses().get(0));
        System.out.println("seee");
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
        User user = userController.getUser("admin2");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.likePost(post, user);
        assertEquals(1,post.getPostedBy().getLikeNumber());
        assertEquals(1, post.getLikeNumber());
    }

    @Test
    void likePostDuplicate(){
        User user = userController.getUser("admin2");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.likePost(post, user);

        assertEquals(-1, postController.likePost(post, user));
        assertEquals(1, post.getPostedBy().getLikeNumber());
        assertEquals(1, post.getLikeNumber());
    }
    @Test
    void dislikePostSuccess(){
        User user = userController.getUser("admin2");
        Post post = courseController.getAllPosts("CSC207").get(0);

        postController.dislikePost(post, user);
        System.out.println(post.getLikeNumber());
        assertEquals(-1, post.getPostedBy().getLikeNumber());
        assertEquals(-1, post.getLikeNumber());
    }

    @Test
    void dislikePostDuplicate(){
        User user = userController.getUser("admin2");
        Post post = courseController.getAllPosts("CSC207").get(0);

        postController.dislikePost(post, user);
        assertEquals(-1, postController.dislikePost(post, user));
        assertEquals(-1, post.getPostedBy().getLikeNumber());
        assertEquals(-1, post.getLikeNumber());
    }

    @Test
    void dislikeToLike(){
        User user = userController.getUser("admin2");
        Post post = courseController.getAllPosts("CSC207").get(0);
        postController.dislikePost(post, user);
        postController.likePost(post, user);

        assertEquals(1, post.getPostedBy().getLikeNumber());
        assertEquals(1, post.getLikeNumber());
    }

    @Test
    void likeToDislike(){
        User user = userController.getUser("admin2");
        Post post = courseController.getAllPosts("CSC207").get(0);

        postController.likePost(post, user);
        postController.dislikePost(post, user);

        assertEquals(-1, post.getPostedBy().getLikeNumber());
        assertEquals(-1, post.getLikeNumber());
    }

    @AfterEach
    public void tearDown(){
        File orgFile = new File("protected_data.ser");
        File newFile = new File("data.ser");

        if (! newFile.delete()){
            System.err.println("File not found!");
        }

        if (orgFile.exists()) {
            if (! orgFile.renameTo(newFile)){
                System.err.println("File not found!");
            }
        }
    }
}
