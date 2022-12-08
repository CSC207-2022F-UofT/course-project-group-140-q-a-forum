package entities;

public class ReportOnPost implements Report {
    private String user;
    final String reportType = "post";
    // Possible entries: user, post, course
    private String content;

    /**
     * Create a report on Post.
     *
     * @param username the username of the user
     * @param content  the content of the report.
     */
    public ReportOnPost(String username, String content) {
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
     * Get the report type in the report
     *
     * @return the int that represent the report type.
     */
    @Override
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
