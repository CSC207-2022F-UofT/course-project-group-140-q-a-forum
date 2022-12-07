package use_cases.DataBaseAccess;

import entities.Report;

import java.util.*;



public interface ReportDataInterface extends DataInterface{
    void save();

    ArrayList<Report> getAllReport();

    ArrayList<Report> getAllReportFromType(int type);


    /**
     * Add a report in DataBase
     * @param report the report to be added to the database.
     */
    void addReport(Report report);


    /**
     * Delete a report in DataBase
     * @param report the report to be deleted from the database.
     */
    void removeReport(Report report);

}