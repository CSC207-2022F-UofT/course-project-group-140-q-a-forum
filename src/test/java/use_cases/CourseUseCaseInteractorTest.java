package use_cases;

import static org.junit.jupiter.api.Assertions.*;

import database.DatabaseDataHandler;
import database.RuntimeDataHandler;
import entities.Course;
import entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseGateway;

import java.io.File;
import java.util.HashMap;

public class CourseUseCaseInteractorTest  {
    static RuntimeDataHandler<Object> dataHandler;
    static DatabaseDataHandler databaseDataHandler;
    static DatabaseGateway gateway;

    static   UserUseCaseInteractor userInteractor;
    static CourseUseCaseInteractor courseInteractor;
    static PostUseCaseInteractor postInteractor;

    static CourseController courseController;
    static PostController postController;
    static UserController userController;

    @BeforeEach
    public void setup(){
        dataHandler = new RuntimeDataHandler<>();
        databaseDataHandler = new DatabaseDataHandler();
        gateway = new DatabaseGateway(dataHandler, databaseDataHandler);


         userInteractor = new UserUseCaseInteractor(gateway);
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
        user2.put("Username", "non-admin2");
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

    }

    @Test
    public void createCourseSuccess(){
        HashMap<String, String> course = new HashMap<>();
        course.put("Name", "Algorithm Design and Analysis");
        course.put("Course Code", "CSC373");
        course.put("Description", "Algorithm Design");
        course.put("Semester", "Winter");
        course.put("Instructors", "Charlie");
        assertEquals(1, courseController.registerCourse(course));
    }
    @Test
    public void DuplicatedCourse(){
        HashMap<String, String> course = new HashMap<>();
        course.put("Name", "Introduction to Software Design");
        course.put("Course Code", "CSC207");
        course.put("Description", "An Introduction to Software Design");
        course.put("Semester", "Fall");
        course.put("Instructors", "Charlie");
        assertEquals(-1,courseController.registerCourse(course));
    }
    @Test
    public void emptyCourse(){
        HashMap<String, String> course = new HashMap<>();
        course.put("Name", "");
        course.put("Course Code", "");
        course.put("Description", "An Introduction to Software Design");
        course.put("Semester", "Fall");
        course.put("Instructors", "Charlie");
        assertEquals(-2,courseController.registerCourse(course));
    }
    @Test
    public  void UnsuccessfulRemove(){
        User user = userController.getUser("non-admin2");
        assertEquals(0, courseController.removeCourse(user, courseController.getAllCourses().get(0)));
    }
    @Test
    public void SuccessfulRemove(){
        User user = userController.getUser("admin");
        assertEquals(1,courseController.removeCourse(user,courseController.getAllCourses().get(0)));
    }

    @Test
    public void UnsuccessfulModify(){
        HashMap<String, String> info = new HashMap<>();
        info.put("where", "name");
        info.put("what", "CSC373");
        Course course = courseController.getAllCourses().get(0);

        User user = userController.getUser("non-admin2");

        assertEquals(0,courseController.modifyCourse(user,course,info));
    }

    @Test
    public void SuccessfulModify(){
        HashMap<String, String> info = new HashMap<>();
        info.put("where", "name");
        info.put("what", "CSC373");
        Course course = courseController.getAllCourses().get(0);

        User user = userController.getUser("admin");

        assertEquals(1,courseController.modifyCourse(user,course, info));
    }


    @Test
    public void WrongInfoModify(){
        HashMap<String, String> info = new HashMap<>();
        info.put("where", "email");
        info.put("what", "CSC373");
        Course course = courseController.getAllCourses().get(0);

        User user = userController.getUser("admin");

        assertEquals(-2,courseController.modifyCourse(user,course,info));
    }

    @Test
    public void SuccessfulInstructor(){
        Course course = courseController.getAllCourses().get(0);
        assertEquals(1, courseController.addInstructor(course,"Ray Huong"));
    }

    @Test
    public void DuplicatedInstructor(){
        Course course = courseController.getAllCourses().get(0);
        assertEquals(-1, courseController.addInstructor(course,"Charlie"));
    }

    @Test
    public void UnsuccessfulRemoveInstructor(){

        User user = userController.getUser("non-admin2");

        assertEquals(0,courseController.removeInstructor(user,courseController.getAllCourses().get(0),"Ray Huong"));
    }

    @Test
    public void NotfoundInstructor(){
        System.err.println(courseController.getAllCourses().get(0).getInstructor());

        User user = userController.getUser("admin");

        assertEquals(-1,courseController.removeInstructor(user,courseController.getAllCourses().get(0),"Ray"));
    }

    @Test
    public void SuccessfulRemoveInstructor(){

        System.err.println(courseController.getAllCourses().get(0).getInstructor());

        User user = userController.getUser("admin");

        assertEquals(1,courseController.removeInstructor(user,courseController.getAllCourses().get(0),"Charlie"));
    }

    @AfterEach
    public void tearDown() {
        File orgFile = new File("protected_data.ser");
        File newFile = new File("data.ser");

        if (!newFile.delete()) {
            System.err.println("File not found!");
        }

        if (orgFile.exists()) {
            if (!orgFile.renameTo(newFile)) {
                System.err.println("File not found!");
            }
        }
    }
}
