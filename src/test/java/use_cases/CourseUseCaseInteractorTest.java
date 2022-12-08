package use_cases;

import static org.junit.jupiter.api.Assertions.*;

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

    static DatabaseGateway gateway;

    static   UserUseCaseInteractor userInteractor;
    static CourseUseCaseInteractor courseInteractor;
    static PostUseCaseInteractor postInteractor;

    static CourseController courseController;
    static PostController postController;
    static UserController userController;

    @BeforeEach
    public void setup(){
         gateway = new DatabaseGateway();

         userInteractor = new UserUseCaseInteractor(gateway);
         courseInteractor = new CourseUseCaseInteractor((gateway));
         postInteractor = new PostUseCaseInteractor(gateway);

         courseController = new CourseController(courseInteractor);
         postController = new PostController(postInteractor);
         userController = new UserController(userInteractor);

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
        assertEquals(0, courseController.removeCourse(false, "CSC207"));
    }
    @Test
    public void SuccessfulRemove(){
        assertEquals(1,courseController.removeCourse(true,"CSC207"));
    }

    @Test
    public void UnsuccessfulModify(){
        assertEquals(0,courseController.modifyCourse(false,"CSC207","name", "CSC373"));
    }

    @Test
    public void SuccessfulModify(){
        assertEquals(1,courseController.modifyCourse(true,"CSC207","name", "CSC373"));
    }


    @Test
    public void WrongInfoModify(){
        assertEquals(-2,courseController.modifyCourse(true,"CSC207","email", "CSC373"));
    }

    @Test
    public void SuccessfulInstructor(){
        assertEquals(1, courseController.addInstructor("CSC207","Ray Huong"));
    }

    @Test
    public void DuplicatedInstructor(){
        assertEquals(-1, courseController.addInstructor("CSC207","Charlie"));
    }

    @Test
    public void UnsuccessfulRemoveInstructor(){
        assertEquals(0,courseController.removeInstructor(false,"CSC207","Ray Huong"));
    }

    @Test
    public void NotfoundInstructor(){
        assertEquals(-1,courseController.removeInstructor(true,"CSC207","Ray Huong"));
    }

    @Test
    public void SuccessfulRemoveInstructor(){
        assertEquals(1,courseController.removeInstructor(true,"CSC207","Charlie"));
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
