package use_cases;

import entities.Report;
import entities.ReportOnCourse;
import entities.ReportOnPost;
import entities.ReportOnUser;

import java.util.Map;

public class ReportFactory {
    /**
     * Generate a Report
     *
     * @param reportInfo This is a Map that contains necessary information
     *                   needed to register a report. The keys must be
     *                   "Username", "ReportType", and "Content".
     *                   The report type is identified by the value of "ReportType",
     *                   0 for report on user,
     *                   1 for report on post,
     *                   2 for report on course.
     * @return the Report generated.
     */
    public Report getReport(Map<String, String> reportInfo) {
        switch (reportInfo.get("ReportType")) {
            case "user" -> {
                return new ReportOnUser(reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }

            case "post" -> {
                return new ReportOnPost( reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }

            case "course" -> {
                return new ReportOnCourse(reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }
        }
        return null;
    }
}
