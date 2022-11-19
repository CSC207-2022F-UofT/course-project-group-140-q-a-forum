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
     * @param username
     * @param reportType
     * @param content
     */

    public Report(String username, int reportType, Object content){
        /**
         * Create a report to a post. ReportType, 0 report on User,
         * 1 report on Post, 2, report on Course.
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

    public Object getContent() {
        return content;
    }


}

