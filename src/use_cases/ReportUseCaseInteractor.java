package use_cases;

import entities.Report;
import use_cases.DataBaseAccess.ReportDataInterface;
import use_cases.DataBaseAccess.UserDataInterface;

public class ReportUseCaseInteractor {
    final ReportDataInterface reportDataInterface;

    public ReportUseCaseInteractor(ReportDataInterface reportDataInterface){
        this.reportDataInterface = reportDataInterface;
    }
    /**
     * Create a report and setting UserName, Report type, Report content.
     * If the report create successfully, return True and
     the Report can be created into DataBase(need to call the userDataInterface).
     * Otherwise, return False
     * @param username, type, content
     * @return boo
     */
    public void createReport(String username, int type, Object content){

    }


    /**
     * Remove Report.
     * Check if the report exist, if yes, remove it and return True
     * Otherwise, return False
     * @param report/
     * @return boo
     */

    public void removeReport(Report report) {
        //TODO: complete this method
    }


}
