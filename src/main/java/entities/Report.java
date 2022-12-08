package entities;

import javax.lang.model.type.UnionType;
import java.io.Serializable;

public class Report implements Serializable {
    private String user;
    private String reportType;

    // Possible entries: user, post, course
    private String content;

    public String attachedTo;

    public Report(){

    }

    /**
     * Create a report to a post. ReportType: User, Post, Course
     * @param username
     * @param reportType
     * @param content
     */
    public Report(String username, String reportType, String content, String attachedTo){
        this.user = username;
        this.reportType = reportType;
        this.content = content;
        this.attachedTo = attachedTo;
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
    public String getReportType() {
        return this.reportType;
    }

    /**
     * Get the content of the report
      * @return An Object representing content of the report
     */
    public String getContent() {
        return content;
    }

    public String getAttachedTo() {
        return attachedTo;
    }
}

