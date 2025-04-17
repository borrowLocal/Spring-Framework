package repository;

import java.util.List;
import domain.Report;

public interface ReportDao {
    Report findById(int report_id);
    List<Report> findByReporterId(int reporter_id);
    List<Report> findByTargetUserId(int target_user_id);
    List<Report> findAll();
   
    void insert(Report report);
}