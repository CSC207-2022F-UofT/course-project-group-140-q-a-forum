package entities;

import javax.lang.model.type.UnionType;

public class Report {
    private String User;
    private int ReportType;
    //ReportType: 0 report on User, 1 report on Post, 2 report on Course.
    private String Content;

    public Report(){

    }

    /**
     * @param username
     * @param ReportType
     * @param Content
     */

    public Report(String username, int ReportType, String Content){
        /**
         * Constructor of the Report class. ReportType, 0 report on User, 1 report on Post, 2, report on Course.
         */
        this.User = username;
        this.ReportType = ReportType;
        this.Content = Content;
    }

    /**
     * @return
     */
    public String getUser() {
        return this.User;
    }

    public int getReportType() {
        return this.ReportType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public void setReportType(int reportType) {
        this.ReportType = reportType;
    }

    public void setUser(String user) {
        this.User = user;
    }
}

