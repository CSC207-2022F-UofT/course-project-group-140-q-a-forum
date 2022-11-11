package src.use_cases;
import src.entities.Course;
import src.use_cases.DataBaseAccess.CourseDataInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseUseCaseInteractor {

    // Try
    final CourseDataInterface courseDataInterface;

    public CourseUseCaseInteractor(CourseDataInterface courseDataInterface) {
        this.courseDataInterface = courseDataInterface;
    }

    /**
     * register a course
     * @param courseCode
     * @return
     */
    public boolean registerACourse(String courseCode){
        //TODO: complete this method
    }

    /**
     *
     * @param courseInformation
     */
    public void removeACourse(String courseCode, String semester){

    }
}

