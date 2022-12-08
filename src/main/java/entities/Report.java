package entities;

import java.io.Serializable;

public class Report implements Serializable {
    private User user;
    private String reportType;

    // Possible entries: user, post, course
    private String content;

    public String attachedTo;

    public Report(){

    }

    /**
     * Create a report to a post. ReportType: User, Post, Course
     * @param user User who made the report
     * @param reportType Whicih type of entity is the report made to
     * @param content Content of the report
     * @param attachedTo The reported subject
     */
    public Report(User user, String reportType, String content, String attachedTo){
        this.user = user;
        this.reportType = reportType;
        this.content = content;
        this.attachedTo = attachedTo;
    }

    /**
     * Get the username in the report
     * @return the string that represent the user
     */
    public User getUser() {
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

