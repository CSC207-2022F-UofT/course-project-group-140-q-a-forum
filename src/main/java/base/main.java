package base;

import UI.MainOfShowingContents.CoursesForm;
import UI.UserdataRelated.LoginForm;
import UI.UserdataRelated.MakeAnAccount;
import controllers.*;
import database.DatabaseGateway;
import entities.Course;
import entities.User;
import use_cases.*;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;

public class main {

//    static DatabaseGateway gateway = new DatabaseGateway();

    static ObjectInputStream in;

    static {
        try {
            in = new ObjectInputStream(new FileInputStream("f.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static DatabaseGateway gateway;

    static {
        try {
            gateway = (DatabaseGateway) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    static CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    static PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    static ReportUseCaseInteractor reportUseCaseInteractor = new ReportUseCaseInteractor(gateway, gateway);

    public static CourseController courseController = new CourseController(courseInteractor);
    public static PostController postController = new PostController(postInteractor);
    public static UserController userController = new UserController(userInteractor);

    public static ReportController reportController = new ReportController(reportUseCaseInteractor);

    public static void main(String[] args) {
        run();
        System.out.println(userController.getUser("Anonymous"));
        try{
            FileOutputStream fout = new FileOutputStream("f.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(gateway);
            out.flush();
            out.close();
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void run() {

//        HashMap<String, String> adminInfo = new HashMap<>();
//        adminInfo.put("Username", "Anonymous");
//        adminInfo.put("Password", "QNAForum140");
//        adminInfo.put("Re-entered Password", "QNAForum140");
//        adminInfo.put("Email", "3232085039@qq.com");
//        adminInfo.put("isAdmin", "True");
//        adminInfo.put("Verification", "DebugCode");
//        userController.registerUser(adminInfo, "DebugCode");
        User user = userController.getUser("Anonymous");

        // System.out.println( userController1.registerUser(adminInfo));
//        User user = new User("DebugPurpose", "DebugPurpose", "DebugPurpose");
        ArrayList<Course> courses = courseController.getAllCourses();
        CoursesForm coursesForm = new CoursesForm(user, courses);
        coursesForm.setVisible(true);

    }
//        MakeAnAccount makeAnAccount = new MakeAnAccount();
//        makeAnAccount.setVisible(true);
}


