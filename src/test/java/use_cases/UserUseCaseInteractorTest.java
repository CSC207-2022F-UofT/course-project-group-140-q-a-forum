package use_cases;

import database.DatabaseDataHandler;
import database.RuntimeDataHandler;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

class UserUseCaseInteractorTest {

    static RuntimeDataHandler<Object> dataHandler = new RuntimeDataHandler<Object>();
    static DatabaseDataHandler databaseDataHandler = new DatabaseDataHandler();
    static DatabaseGateway gateway = new DatabaseGateway(dataHandler, databaseDataHandler);
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
        HashMap<String, String> adminInfo = new HashMap<>();
        adminInfo.put("Username", "admin");
        adminInfo.put("Password", "QNAForum140");
        adminInfo.put("Re-entered Password", "QNAForum140");
        adminInfo.put("Email", "3232085039@qq.com");
        adminInfo.put("isAdmin", "True");
        adminInfo.put("Verification", "DebugCode");
        userController.registerUser(adminInfo, "DebugCode");
    }

    @Test
    void createUserSuccess() {
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        userInfo.put("Verification", "DebugCode");
        assertEquals(1, userController.registerUser(userInfo, "DebugCode"));
    }

    @Test
    void createUserDuplicateUsername(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "admin");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        userInfo.put("Verification", "DebugCode");
        assertEquals(-1, userController.registerUser(userInfo, "DebugCode"));
    }

    @Test
    void createUserWeakPassword(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "1");
        userInfo.put("Re-entered Password", "1");
        userInfo.put("Email", "123456s@gmail.com");
        userInfo.put("isAdmin", null);
        userInfo.put("Verification", "DebugCode");
        assertEquals(-2, userController.registerUser(userInfo, "DebugCode"));
    }

    @Test
    void createUserPasswordNotSame(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan321");
        userInfo.put("Email", "123456@gmail.com");
        userInfo.put("isAdmin", null);
        userInfo.put("Verification", "DebugCode");
        assertEquals(-4, userController.registerUser(userInfo, "DebugCode"));
    }

    @Test
    void createUserInvalidEmail(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "ThisIsNotAnEmail@email.e");
        userInfo.put("isAdmin", null);
        userInfo.put("Verification", "DebugCode");
        assertEquals(-3, userController.registerUser(userInfo, "DebugCode"));
    }

    @Test
    void createUserWrongVerification(){
        HashMap<String, String> userInfo = new HashMap<>();
        userInfo.put("Username", "Jordan");
        userInfo.put("Password", "Jordan123");
        userInfo.put("Re-entered Password", "Jordan123");
        userInfo.put("Email", "ThisIsNotAnEmail@email.com");
        userInfo.put("isAdmin", null);
        userInfo.put("Verification", "NotDebugCode");
        assertEquals(-5, userController.registerUser(userInfo, "DebugCode"));
    }

    @Test
    void loginUserSuccessfully(){
        assertEquals(1, userController.loginUser("admin", "QNAForum140"));
    }

    @Test
    //Try login with a user that is not in the database
    void loginNoUser(){
        assertEquals(-1, userController.loginUser("admin2", "QNAForum140"));
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

    @Test
    void loginSuccess(){
        assertEquals(1, userController.loginUser("admin", "QNAForum140"));
    }

    @Test
    void loginWrongPassword(){
        assertEquals(-2, userController.loginUser("admin", "Wrongpassword"));
    }

    @Test
    void loginNoAccount(){
        assertEquals(-1, userController.loginUser("adminNoAccount", "Wrongpassword"));
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