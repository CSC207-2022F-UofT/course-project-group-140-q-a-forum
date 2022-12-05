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
    public Report getReport(Map<String, Object> reportInfo) {
        switch ((int) reportInfo.get("ReportType")) {
            case 0 -> {
                return new ReportOnUser((String) reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }

            case 1 -> {
                return new ReportOnPost((String) reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }

            case 2 -> {
                return new ReportOnCourse((String) reportInfo.get("Username"),
                        reportInfo.get("Content"));
            }
        }
        return null;
    }
}
