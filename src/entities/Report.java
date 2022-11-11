package entities;

import javax.lang.model.type.UnionType;

public class Report {
    private String user;
    private int reportType;
    //ReportType: 0 report on User, 1 report on Post, 2 report on Course.
    private String content;

    public Report(){

    }

    /**
     * @param username
     * @param reportType
     * @param content
     */

    public Report(String username, int reportType, String content){
        /**
         * Constructor of the Report class. ReportType, 0 report on User, 1 report on Post, 2, report on Course.
         */
        this.user = username;
        this.reportType = reportType;
        this.content = content;
    }

    /**
     * @return
     */
    public String getUser() {
        return this.user;
    }

    public int getReportType() {
        return this.reportType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public void setUser(String user) {
        this.user = user;
    }
}

