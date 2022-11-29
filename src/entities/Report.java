package entities;

import javax.lang.model.type.UnionType;

public class Report {
    private String user;
    private int reportType;
    //ReportType: 0 report on User, 1 report on Post, 2 report on Course.
    private Object content;

    public Report(){

    }

    /**
     * Create a report to a post. ReportType, 0 report on User,
     * 1 report on Post, 2, report on Course.
     * @param username
     * @param reportType
     * @param content
     */
    public Report(String username, int reportType, Object content){

        this.user = username;
        this.reportType = reportType;
        this.content = content;
    }

    /**
     * Get the username in the report
     * @return the string that represent the user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * get the type of report
     * @return the string that indicate the report type
     */
    public int getReportType() {
        return this.reportType;
    }

    /**
     * Get the content of the report
      * @return An Object representing content of the report
     */
    public Object getContent() {
        return content;
    }


}

