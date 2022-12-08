package entities;

public interface Report {
    /**
     * Extract the type of the report.
     *
     * @return the int that represent the report type.
     */
    String getReportType();

    String getContent();
}
