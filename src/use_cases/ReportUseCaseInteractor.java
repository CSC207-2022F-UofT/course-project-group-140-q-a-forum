package use_cases;

import entities.Report;
import entities.User;
import exceptions.UserNotExistException;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.DataBaseAccess.UserDataInterface;

import java.util.ArrayList;
import java.util.Map;

public class ReportUseCaseInteractor {
    final ReportDataInterface reportDataInterface;
    final UserDataInterface userDataInterface;

    public ReportUseCaseInteractor(ReportDataInterface reportDataInterface, UserDataInterface userDataInterface){
        this.reportDataInterface = reportDataInterface;
        this.userDataInterface = userDataInterface;
    }

    /**
     * Create a report and setting UserName, Report type, Report content.
     * If the report create successfully, return True and
     the Report can be created into DataBase(need to call the userDataInterface).
     * Otherwise, return False
     * @param reportInfor This is a Map that contains necessary information
     *                    needed to register a user. The keys must be
     *                    "Username", "ReportType", and "Content".
     */
    public void createReport(Map<String,Object> reportInfor){
        //TODO: complete this method

        ArrayList<User> userData = userDataInterface.getData();
        for (User user:userData){
            if (user.getUsername()==reportInfor.get("Username")){
                throw new UserNotExistException((String) reportInfor.get("Username"));
            }
        }

        reportDataInterface.addReport(new Report((String) reportInfor.get("Username"),
                (Integer) reportInfor.get("Type"),
                reportInfor.get("Content")));

    }


    /**
     * Remove a Report.
     * @param reportToDelete This is report to be deleted.
     */

    public void removeReport(Report reportToDelete) {
        //TODO: complete this method
        reportDataInterface.removeReport(reportToDelete);
    }


}
