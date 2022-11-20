package controllers;

import java.util.*;

import entities.Report;
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
     *                          needed to register a report. The keys must be
     *                          "Username", "Type", "Content"
     * @return if successfully registered this student
     */

    public boolean createAReport(Map<String, Object> reportInformation) {
        // TODO: implement this method
        try {
            reportUseCaseInteractor.createReport(reportInformation);
        } catch (RuntimeException e) {

        } finally {
            return true;
        }
    }

    /**
     * Remove a report.
     * Returns the situation of removal.
     *
     * @param reportInformation This is a Map that contains necessary information
     *                          needed to remove a user. The keys must be
     *                          "Username", "Type", "Content"
     * @return if successfully registered this student
     */

    public boolean removeAReport(Map<String, Object> reportInformation) {
        // TODO: implement this method
        try {
            Report report = new Report((String) reportInformation.get("Username"),
                    (Integer) reportInformation.get("Type"),
                    reportInformation.get("Content"));
            reportUseCaseInteractor.removeReport(report);
        } catch (RuntimeException e) {

        } finally {
            return true;
        }
    }


}
