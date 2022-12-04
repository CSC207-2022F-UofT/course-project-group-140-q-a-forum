package use_cases;

import entities.*;


import exceptions.*;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.DataBaseAccess.UserDataInterface;

import java.util.Map;

public class ReportUseCaseInteractor {
    final ReportDataInterface reportDataInterface;
    final UserDataInterface userDataInterface;

    public ReportUseCaseInteractor(ReportDataInterface reportDataInterface, UserDataInterface userDataInterface) {
        this.reportDataInterface = reportDataInterface;
        this.userDataInterface = userDataInterface;
    }

    /**
     * Create a report and setting UserName, Report type, Report content.
     * Throw the UserNotExistException if the user does not exist in the database.
     *
     * @param reportInfo This is a Map that contains necessary information
     *                    needed to register a user. The keys must be
     *                    "Username", "ReportType", and "Content".
     *                    The report type is identified by int,
     *                    0 for report on user,
     *                    1 for report on post,
     *                    2 for report on course.
     */
    public void createReport(Map<String, Object> reportInfo) {
        switch ((int) reportInfo.get("ReportType")) {
            case 0 -> reportDataInterface.addReport(new ReportOnUser((String) reportInfo.get("Username"),
                    reportInfo.get("Content")));

            case 1 -> reportDataInterface.addReport(new ReportOnPost((String) reportInfo.get("Username"),
                    reportInfo.get("Content")));

            case 2 -> reportDataInterface.addReport(new ReportOnCourse((String) reportInfo.get("Username"),
                    reportInfo.get("Content")));

        }

    }


    /**
     * Remove a Report from the current database.
     *
     * @param reportToDelete This is a report to be deleted.
     */

    public void removeReport(Map<String, Object> reportToDelete) {
        switch ((int) reportToDelete.get("ReportType")) {
            case 0 -> reportDataInterface.removeReport(new ReportOnUser((String) reportToDelete.get("Username"),
                    reportToDelete.get("Content")));

            case 1 -> reportDataInterface.removeReport(new ReportOnPost((String) reportToDelete.get("Username"),
                    reportToDelete.get("Content")));

            case 2 -> reportDataInterface.removeReport(new ReportOnCourse((String) reportToDelete.get("Username"),
                    reportToDelete.get("Content")));

        }

    }


}