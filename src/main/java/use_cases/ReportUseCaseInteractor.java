package use_cases;

import entities.Report;

import entities.User;
import exceptions.*;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.DataBaseAccess.UserDataInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ReportUseCaseInteractor{
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
     */
    public void createReport(Map<String, Object> reportInfo) {

        System.out.println(reportInfo.get("User"));

        if(reportInfo.get("Content").equals("") ||
                reportInfo.get("Content").equals("")){
            throw new EmptyEntryException("report");
        }

        if (!userDataInterface.userExists(((User) reportInfo.get("User")).getUsername())) {
            throw new NotFoundException("User");
        }

        reportDataInterface.addReport(new Report((User) reportInfo.get("User"),
                (String) reportInfo.get("Type"), (String) reportInfo.get("Content"),
                (String) reportInfo.get("attachedTo")));

        try{
            reportDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }


    /**
     * Remove a Report from the current database.
     *
     * @param reportToDelete This is a report to be deleted.
     */

    public void removeReport(Report reportToDelete) {
        System.out.println(reportToDelete.getContent());
        reportDataInterface.removeReport(reportToDelete);
        
        try{
            reportDataInterface.saveToFile();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Report> getAllReport(){
        return reportDataInterface.getAllReport();
    }

}