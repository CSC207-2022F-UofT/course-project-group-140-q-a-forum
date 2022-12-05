package base;

import UI.MainOfShowingContents.CoursesForm;
import UI.UserdataRelated.LoginForm;
import UI.UserdataRelated.MakeAnAccount;
import controllers.CourseController;
import controllers.PostController;
import controllers.ReportController;
import controllers.UserController;
import database.DatabaseGateway;
import entities.Course;
import entities.User;
import use_cases.CourseUseCaseInteractor;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.PostUseCaseInteractor;
import use_cases.ReportUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.util.ArrayList;
import java.util.HashMap;

public class main {
    static DatabaseGateway gateway = new DatabaseGateway();
    static  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    static  UserUseCaseInteractor userInteractor1 = new UserUseCaseInteractor(gateway,"DebugCode");
    static CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    static PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    static ReportUseCaseInteractor reportUseCaseInteractor = new ReportUseCaseInteractor(gateway, gateway);

    public static CourseController courseController = new CourseController(courseInteractor);
    public static PostController postController = new PostController(postInteractor);
    public static UserController userController = new UserController(userInteractor);

    public static UserController userController1 = new UserController(userInteractor1);
    public static ReportController reportController = new ReportController(reportUseCaseInteractor);

    public static void main(String[] args) {
        HashMap<String, String> adminInfo = new HashMap<>();
        adminInfo.put("Username", "Anonymous");
        adminInfo.put("Password", "QNAForum140");
        adminInfo.put("Re-entered Password", "QNAForum140");
        adminInfo.put("Email", "3232085039@qq.com");
        adminInfo.put("isAdmin", "True");
        adminInfo.put("Verification", "DebugCode");
        //userController1.registerUser(adminInfo);
       // System.out.println( userController1.registerUser(adminInfo));
        User user = new User("DebugPurpose", "DebugPurpose", "DebugPurpose");
        ArrayList<Course> courses = courseController.getAllCourses();
       CoursesForm coursesForm =new CoursesForm(user, courses);
       coursesForm.setVisible(true);
//        MakeAnAccount makeAnAccount = new MakeAnAccount();
//        makeAnAccount.setVisible(true);
    }

}
