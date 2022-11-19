package use_cases;
import entities.Course;
import use_cases.DataBaseAccess.CourseDataInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseUseCaseInteractor {
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

        return true;
    }

    /**
     *
     * @param courseInformation
     */
    public void removeACourse(Object courseInformation){

    }
}

