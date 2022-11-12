package use_cases.DataBaseAccess;

import entities.Comment;
import entities.Post;
import entities.PostInfo;
import entities.Report;

import java.util.ArrayList;

public interface ReportDataInterface extends DataInterface{
    ArrayList<Post> getData();

    void addReport(Report report);

    void removeReport(Report report);

}
