package controllers;

import java.util.*;

import entities.*;
import exceptions.*;
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
     * @return An integer indicating if successfully registered.
     * 1: Successfully registered.
     * 0: The user report does not exist.
     */

    public int createAReport(Map<String, Object> reportInformation) {
        try {
            reportUseCaseInteractor.createReport(reportInformation);
        } catch (NotFoundException e) {
            return 0;
        }
        return 1;

    }

    /**
     * Remove a report.
     * Returns the situation of removal.
     *
     * @param reportInformation This is a Map that contains necessary information
     *                          needed to remove a user. The keys must be
     *                          "Username", "Type", "Content"
     * @return An integer indicating if successfully registered.
     * 0: Successfully removed the report.
     */

    public int removeAReport(Map<String, Object> reportInformation) {
        try {

            reportUseCaseInteractor.removeReport(reportInformation);
        } catch (RuntimeException e) {

        } return 0;

    }


}