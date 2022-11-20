package base;

import controllers.CourseController;
import controllers.PostControllers;
import controllers.UserController;
import database.DatabaseGateway;
import entities.Course;
import entities.User;
import use_cases.CourseUseCaseInteractor;
import use_cases.DataBaseAccess.UserDataInterface;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

public class main {
    static DatabaseGateway gateway = new DatabaseGateway();

    static  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    static CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    static PostUseCaseInteractor postInteractor = new PostUseCaseInteractor((gateway));

    CourseController courseController = new CourseController(courseInteractor);
    PostControllers postControllers = new PostControllers(postInteractor);
    public static UserController userController = new UserController(userInteractor);
    public static void main(String[] args) {




    }
}
