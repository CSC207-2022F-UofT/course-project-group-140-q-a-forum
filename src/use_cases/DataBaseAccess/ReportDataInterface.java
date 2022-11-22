package use_cases.DataBaseAccess;

import entities.Report;

import java.util.*;



public interface ReportDataInterface extends DataInterface{
    ArrayList<Report> getAllReport();

    ArrayList<Report> getAllReportFromType(int type);


    /**
     * add a report in DataBase
     * @param report/
     */
    void addReport(Report report);


    /**
     * delete a report in DataBase
     * @param report/
     */
    void removeReport(Report report);

}
