package dto.request;

public class ReportRequestDto {
    private Integer rental_id;
    private Integer target_user_id;
    private String reason;
    
	public Integer getRental_id() {
		return rental_id;
	}
	public void setRental_id(Integer rental_id) {
		this.rental_id = rental_id;
	}
	public Integer getTarget_user_id() {
		return target_user_id;
	}
	public void setTarget_user_id(Integer target_user_id) {
		this.target_user_id = target_user_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
} 