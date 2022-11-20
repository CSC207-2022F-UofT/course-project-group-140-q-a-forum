package UseCases;

import entities.Report;
import UseCases.DataBaseAccess.ReportDataInterface;

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
        //TODO: complete this method
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
