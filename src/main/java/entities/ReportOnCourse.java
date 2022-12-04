package entities;

public class ReportOnCourse implements Report {

    private String user;
    final int reportType = 2;
    //ReportType: 0 report on User, 1 report on Post, 2 report on Course.
    private Object content;

    /**
     * Create a report on Course.
     *
     * @param username the username of the user
     * @param content  the content of the report.
     */
    public ReportOnCourse(String username, Object content) {
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
    public int getReportType() {
        return this.reportType;
    }

    /**
     * Get the content of the report
     *
     * @return An Object representing content of the report
     */
    public Object getContent() {
        return content;
    }
}
