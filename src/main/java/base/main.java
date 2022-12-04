package base;

import UI.MainOfShowingContents.CoursesForm;
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

public class main {
    static DatabaseGateway gateway = new DatabaseGateway();
    static  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    static CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    static PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    static ReportUseCaseInteractor reportUseCaseInteractor = new ReportUseCaseInteractor(gateway, gateway);

    public static CourseController courseController = new CourseController(courseInteractor);
    public static PostController postController = new PostController(postInteractor);
    public static UserController userController = new UserController(userInteractor);

    public static ReportController reportController = new ReportController(reportUseCaseInteractor);

    public static void main(String[] args) {
        User user = new User("DebugPurpose", "DebugPurpose", "DebugPurpose", " ");
        ArrayList<Course> courses = courseController.getAllCourses();
        CoursesForm coursesForm =new CoursesForm(user, courses);
        coursesForm.setVisible(true);
    }

}
