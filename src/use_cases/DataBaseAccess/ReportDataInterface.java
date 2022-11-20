package use_cases.DataBaseAccess;

import entities.Report;

import java.util.*;



public interface ReportDataInterface extends DataInterface{
    ArrayList<Report> getData();


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
