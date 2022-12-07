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
    static ObjectInputStream in;
    static DatabaseGateway gateway;


    public static CourseController courseController;
    public static PostController postController;
    public static UserController userController;

    public static ReportController reportController;

    public static void main(String[] args) throws IOException {
        try {
            in = new ObjectInputStream(new FileInputStream("data.ser"));
            gateway = (DatabaseGateway) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            FileOutputStream fout = new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            DatabaseGateway gateway = new DatabaseGateway();
            out.writeObject(gateway);
            out.flush();
            out.close();
            System.out.println("success");
        }

        UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
        CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
        PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);
        ReportUseCaseInteractor reportUseCaseInteractor = new ReportUseCaseInteractor(gateway, gateway);

        courseController = new CourseController(courseInteractor);
        postController = new PostController(postInteractor);
        userController = new UserController(userInteractor);

        reportController = new ReportController(reportUseCaseInteractor);

//        HashMap<String, String> adminInfo = new HashMap<>();
//        adminInfo.put("Username", "Anonymous");
//        adminInfo.put("Password", "QNAForum140");
//        adminInfo.put("Re-entered Password", "QNAForum140");
//        adminInfo.put("Email", "3232085039@qq.com");
//        adminInfo.put("isAdmin", "True");
//        adminInfo.put("Verification", "DebugCode");
//        userController.registerUser(adminInfo, "DebugCode");
        User user = userController.getUser("Anonymous");
        ArrayList<Course> courses = courseController.getAllCourses();
        CoursesForm coursesForm = new CoursesForm(user, courses);
        coursesForm.setVisible(true);
        System.out.println(userController.getUser("giaogiao") == null);
    }

}


