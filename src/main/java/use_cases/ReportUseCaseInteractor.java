package use_cases;

import entities.*;


import exceptions.*;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.DataBaseAccess.UserDataInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ReportUseCaseInteractor {
    final ReportDataInterface reportDataInterface;
    final UserDataInterface userDataInterface;
    final ReportFactory factory;

    public ReportUseCaseInteractor(ReportDataInterface reportDataInterface, UserDataInterface userDataInterface, ReportFactory factory) {
        this.reportDataInterface = reportDataInterface;
        this.userDataInterface = userDataInterface;
        this.factory = factory;
    }

    /**
     * Create a report and setting UserName, Report type, Report content.
     *
     * @param reportInfo This is a Map that contains necessary information
     *                    needed to register a report. The keys must be
     *                    "Username", "ReportType", and "Content".
     *                    The report type is identified by the value of "ReportType",
     *                    0 for report on user,
     *                    1 for report on post,
     *                    2 for report on course.
     */
    public void createReport(Map<String, Object> reportInfo) {
        if (!userDataInterface.getUser((String) reportInfo.get("Username")).isAdmin()) {
            throw new NotFoundException("Username");
        }

        Report report;
        report = factory.getReport(reportInfo);
        if (report!=null) {
            reportDataInterface.addReport(report);
        }

        try{
            reportDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    /**
     * Remove a Report from the current database.
     *
     * @param reportToDelete This is a Map that contains necessary information
     *                       needed to delete a report. The keys must be
     *                       "Username", "ReportType", and "Content".
     *                       The report type is identified by the value of "ReportType",
     *                       0 for report on user,
     *                       1 for report on post,
     *                       2 for report on course.
     */

    public void removeReport(Map<String, Object> reportToDelete) {
        Report report;
        report = factory.getReport(reportToDelete);
        if (report!=null) {
            reportDataInterface.removeReport(report);
        }
    }

}