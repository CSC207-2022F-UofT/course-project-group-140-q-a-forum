package base;

import controllers.CourseController;
import controllers.PostController;
import controllers.UserController;
import database.DatabaseGateway;
import use_cases.CourseUseCaseInteractor;
import use_cases.PostUseCaseInteractor;
import use_cases.UserUseCaseInteractor;

public class main {
    static DatabaseGateway gateway = new DatabaseGateway();

    static  UserUseCaseInteractor userInteractor = new UserUseCaseInteractor(gateway);
    static CourseUseCaseInteractor courseInteractor = new CourseUseCaseInteractor((gateway));
    static PostUseCaseInteractor postInteractor = new PostUseCaseInteractor(gateway);

    public static CourseController courseController = new CourseController(courseInteractor);

    public static PostController postController = new PostController(postInteractor);
    public static UserController userController = new UserController(userInteractor);

}
