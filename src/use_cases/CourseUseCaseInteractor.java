package src.use_cases;
import src.entities.Course;
import src.use_cases.DataBaseAccess.CourseDataInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseUseCaseInteractor {
    final CourseDataInterface courseDataInterface;

    public CourseUseCaseInteractor(CourseDataInterface courseDataInterface) {
        this.courseDataInterface = courseDataInterface;
    }

    void registerACourse(String courseCode, String semester){
        ArrayList<Course> allCourses = courseDataInterface.getData();
        boolean found = false;
    }

    void removeACourse(String courseCode, String semester){
        courseDataInterface.deleteCourse(courseCode);
    }
}

