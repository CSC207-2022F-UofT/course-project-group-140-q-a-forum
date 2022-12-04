package use_cases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseGateway;

import java.util.HashMap;

public class CourseUseCaseInteractorTest  {

    private final DatabaseGateway gateway = new DatabaseGateway();

    private final  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    private final CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    private final PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    private final CourseController courseController = new CourseController(courseInteractor);
    private final PostController postController = new PostController(postInteractor);
    private final UserController userController = new UserController(userInteractor);

    @BeforeEach
    public void setup(){
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
    public void NotfoundModify(){
        assertEquals(-1,courseController.modifyCourse(true,"CSC207","Semester", ""));
    }

    @Test
    public void WrongInfoModify(){
        assertEquals(-2,courseController.modifyCourse(true,"CSC148","name", "CSC373"));
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
        assertEquals(-1,courseController.removeInstructor(true,"CSC207","Charlie"));
    }
}
