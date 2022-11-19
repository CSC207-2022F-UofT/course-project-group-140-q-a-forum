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


        return reportUseCaseInteractor.createReport(
                (String)reportInformation.get("Username"),
                (Integer)reportInformation.get("Username"),
                reportInformation.get("Username"));}



    public boolean searchReport(){return false;}
}
