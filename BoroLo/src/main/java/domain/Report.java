package domain;

import java.time.LocalDateTime;

public class Report {
    private Integer report_id;
    private Integer reporter_id;
    private Integer target_user_id;
    private Integer rental_id;
    private String reason;
    private LocalDateTime created_at;

    public Integer getReport_id() { return report_id; }
    public void setReport_id(Integer report_id) { this.report_id = report_id; }
    
    public Integer getReporter_id() { return reporter_id; }
    public void setReporter_id(Integer reporter_id) { this.reporter_id = reporter_id; }

    public Integer getTarget_user_id() { return target_user_id; }
    public void setTarget_user_id(Integer target_user_id) { this.target_user_id = target_user_id; }

    public Integer getRental_id() { return rental_id; }
    public void setRental_id(Integer rental_id) { this.rental_id = rental_id; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }
}