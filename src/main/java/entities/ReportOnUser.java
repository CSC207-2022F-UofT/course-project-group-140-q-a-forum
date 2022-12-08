package entities;

public class ReportOnUser implements Report {
    private String user;
    final String reportType = "user";
    // Possible entries: user, post, course
    private String content;



    /**
     * Create a report on User.
     *
     * @param username the username of the user
     * @param content  the content of the report.
     */
    public ReportOnUser(String username, String content) {
        this.user = username;
        this.content = content;
    }

    /**
     * Get the username in the report
     *
     * @return the string that represent the user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * get the type of report
     *
     * @return the string that indicate the report type
     */
    public String getReportType() {
        return this.reportType;
    }

    /**
     * Get the content of the report
     *
     * @return An Object representing content of the report
     */
    public String getContent() {
        return content;
    }


}

