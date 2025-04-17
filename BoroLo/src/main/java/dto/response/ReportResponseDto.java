package dto.response;

import java.time.LocalDateTime;

public class ReportResponseDto {
    private Integer report_id;
	private String target_user_nick_name;
    private String reason;
    private LocalDateTime created_at;

    public Integer getReport_id() {
		return report_id;
	}
	public void setReport_id(Integer report_id) {
		this.report_id = report_id;
	}
	public String getTarget_user_nick_name() {
		return target_user_nick_name;
	}
	public void setTarget_user_nick_name(String target_user_nick_name) {
		this.target_user_nick_name = target_user_nick_name;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}