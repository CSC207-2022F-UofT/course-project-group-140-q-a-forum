package base;

import UI.UserdataRelated.LoginForm;
import controllers.CourseController;
import controllers.PostController;
import controllers.ReportController;
import controllers.UserController;
import database.DatabaseDataHandler;
import database.DatabaseGateway;
import database.RuntimeDataHandler;
import entities.Course;
import entities.Report;
import entities.User;
import use_cases.CourseUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.ReportUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class main {

    static RuntimeDataHandler<Object> dataHandler = new RuntimeDataHandler<>();
    static DatabaseDataHandler databaseDataHandler = new DatabaseDataHandler();
    static DatabaseGateway gateway = new DatabaseGateway(dataHandler, databaseDataHandler);
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
        try{
            gateway.readFromFile();

        }catch (IOException | ClassNotFoundException e){
            // Create file
            try{
                gateway.saveToFile();
            }catch (IOException err){
                System.err.println(err.getMessage());
            }
            // Create admin
            HashMap<String, String> adminInfo = new HashMap<>();
            adminInfo.put("Username", "Anonymous");
            adminInfo.put("Password", "QNAForum140");
            adminInfo.put("Re-entered Password", "QNAForum140");
            adminInfo.put("Email", "3232085039@qq.com");
            adminInfo.put("isAdmin", "True");
            adminInfo.put("Verification", "DebugCode");
            userController1.registerUser(adminInfo, "DebugCode");

            HashMap<String, String> adminInfo2 = new HashMap<>();
            adminInfo2.put("Username", "Teinble");
            adminInfo2.put("Password", "qwer123456");
            adminInfo2.put("Re-entered Password", "qwer123456");
            adminInfo2.put("Email", "xinlingzhao16@gmail.com");
            adminInfo2.put("isAdmin", "True");
            adminInfo2.put("Verification", "DebugCode");
            userController1.registerUser(adminInfo2, "DebugCode");

        }
        // debug();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }

    public static void debug(){
        ArrayList<User> users = gateway.getAllUsers();
        ArrayList<Course> courses = gateway.getAllCourses();
        ArrayList<Report> reports = gateway.getAllReport();

        System.out.println("SERIALIZATION INFO");

        System.out.println("================================================");
        System.out.println("================================================");
        for (User user: users){
            System.out.println("Username: " + user.getUsername()) ;
            System.out.println("Email: " + user.getEmail()) ;
            System.out.println("Password: " + user.getPassword()) ;
            System.out.println("Admin?" + user.isAdmin());
            System.out.println("================================================");
        }

        System.out.println();

        System.out.println("================================================");
        System.out.println("================================================");

        System.out.println();
        for (Course course: courses){
            System.out.println("Course:" + course.getCode() + " " + course.getName());

            ArrayList<String> posts = course.getPostTitles();

            System.out.println();
            System.out.println("================================================");
            System.out.println();

            for (String post: posts){
                System.out.println("Post: " + post);
            }

        }

        System.out.println();
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.println();

        for (Report report: reports){
            System.out.println("Report: " + report.getContent());
        }

    }

}
