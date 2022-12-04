package use_cases;

import static org.junit.jupiter.api.Assertions.*;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseGateway;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.CourseUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.util.HashMap;

public class PostUseCaseInteractorTest {
    private final DatabaseGateway gateway = new DatabaseGateway();

    private final  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    private final CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    private final PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    private final CourseController courseController = new CourseController(courseInteractor);
    private final PostController postController = new PostController(postInteractor);
    private final UserController userController = new UserController(userInteractor);

    @BeforeEach
    public void setUp() {
        HashMap<String, String> user = new HashMap<>();
        user.put("Username", "admin");
        user.put("Password", "QNAForum140");
        user.put("Re-entered Password", "QNAForum140");
        user.put("Email", "3232085039@qq.com");
        user.put("isAdmin", "True");
        userController.registerUser(user);

        HashMap<String, String> course = new HashMap<>();
        course.put("Name", "Introduction to Software Design");
        course.put("Course Code", "CSC207");
        course.put("Description", "An Introduction to Software Design");
        course.put("Semester", "Fall");
        course.put("Instructors", "Charlie");
        courseController.registerCourse(course);

        HashMap<String, Object> adminInfo = new HashMap<>();
        adminInfo.put("title", "Test");
        adminInfo.put("text", "A meaningful question");
        adminInfo.put("user", userController.getUser("admin"));
        adminInfo.put("course", courseController.getAllCourses().get(0));
        postController.createPost(adminInfo);
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
}
