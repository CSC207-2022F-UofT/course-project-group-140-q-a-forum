package controllers;
import java.util.*;
import use_cases.ReportUseCaseInteractor;

public class ReportController {
    private final ReportUseCaseInteractor reportUseCaseInteractor;


    public ReportController(ReportUseCaseInteractor reportUseCaseInteractor) {
        this.reportUseCaseInteractor = reportUseCaseInteractor;
    }

    /**
     * Register a report.
     * Returns the situation of registration.
     *
     * @param reportInformation This is a Map that contains necessary information
     *                          needed to register a user. The keys must be
     *                          "Username", "Type", "Content"
     * @return if successfully registered this student
     */

    public boolean createAReport(Map<String,Object> reportInformation){
        // TODO: implement this method
        try{
            reportUseCaseInteractor.createReport(
                    (String)reportInformation.get("username"),
                    (Integer)reportInformation.get("username"),
                    reportInformation.get("username"));
        }catch (RuntimeException e){

        }finally {
            return true;
        }
    }


    public boolean searchReport(){return false;}
}