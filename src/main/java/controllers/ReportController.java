package controllers;


import entities.Course;
import entities.Post;
import entities.Report;
import entities.User;
import exceptions.EmptyEntryException;
import exceptions.NotFoundException;
import use_cases.ReportUseCaseInteractor;

import java.util.ArrayList;
import java.util.Map;

public class ReportController {
    private final ReportUseCaseInteractor reportUseCaseInteractor;


    public ReportController(ReportUseCaseInteractor reportUseCaseInteractor) {
        this.reportUseCaseInteractor = reportUseCaseInteractor;
    }

    /**
     * Register a report.
     * Returns the situation of register  on.
     *
     * @param reportInformation This is a Map that contains necessary information
     *                          needed to register a report. The keys must be
     *                          "Username", "Type", "Content"
     * @return An integer indicating if successfully registered.
     * 1: Successfully registered.
     * 0: The user report does not exist.
     */

    public int createReportForUser(Map<String, Object> reportInformation, User user) {
        reportInformation.put("attachedTo", user.getUsername());
        try {
            reportUseCaseInteractor.createReport(reportInformation);
        } catch (NotFoundException e) {
            return 0;
        }
        return 1;

    }

    public int createReportForPost(Map<String, Object> reportInformation, Post post) {
        reportInformation.put("attachedTo", post.getTopic());
        try {
            reportUseCaseInteractor.createReport(reportInformation);
        } catch (NotFoundException e) {
            return 0;
        }catch ( EmptyEntryException e){
            return -1;
        }

        return 1;

    }

    public int createReportForCourse(Map<String, Object> reportInformation, Course course) {
        reportInformation.put("attachedTo", course.getCode());
        try {
            reportUseCaseInteractor.createReport(reportInformation);
        } catch (NotFoundException e) {
            return 0;
        }catch (EmptyEntryException e){
            return -1;
        }
       return 1;

    }

    /**
     * Remove a report.
     * Returns the situation of removal.
     *
     * @param report The report to be deleted.
     */

    public void removeAReport(Report report) {
        try {
            reportUseCaseInteractor.removeReport(report);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

    }

    public ArrayList<Report> getAllReport(){
        return reportUseCaseInteractor.getAllReport();
    }


}