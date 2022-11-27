package use_cases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseGateway;
import entities.*;
import use_cases.CourseUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.util.HashMap;

class UserUseCaseInteractorTest {

    private final DatabaseGateway gateway = new DatabaseGateway();

    private final  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    private final CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    private final PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    private final CourseController courseController = new CourseController(courseInteractor);

    private final PostController postController = new PostController(postInteractor);
    private final UserController userController = new UserController(userInteractor);


    @BeforeEach
    public void setUp() {
        HashMap<String, String> adminInfo = new HashMap<>();
        adminInfo.put("Username", "admin");
        adminInfo.put("Password", "QNAForum140");
        adminInfo.put("Re-entered Password", "QNAForum140");
        adminInfo.put("Email", "3232085039@qq.com");
        adminInfo.put("isAdmin", "True");
        userController.registerUser(adminInfo);
    }

    @Test
    void createUserSuccess() {
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        assertEquals(1, userController.registerUser(userInfo));
    }

    @Test
    void createUserDuplicateUsername(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "admin");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        assertEquals(-1, userController.registerUser(userInfo));
    }

    @Test
    void createUserWeakPassword(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "1");
        userInfo.put("Re-entered Password", "1");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        assertEquals(-2, userController.registerUser(userInfo));
    }

    @Test
    void createUserPasswordNotSame(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan321");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        assertEquals(-3, userController.registerUser(userInfo));
    }

    @Test
    void createUserInvalidEmail(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "ThisIsNotAnEmail@email.e");
        userInfo.put("isAdmin", null);
        assertEquals(-4, userController.registerUser(userInfo));
    }

    @Test
    void getUserSuccess(){
        User user = userController.getUser("admin");
        assertEquals(user.getUsername(), "admin");
        assertEquals(user.getPassword(), "QNAForum140");
    }

    @Test
    void getUserFailure(){
        User user = userController.getUser("This is not a user");
        assertNull(user);
    }
}