package dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RentalRequestDto {
    private Integer item_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private String meeting_location;
    private LocalDateTime meeting_time;
    private Integer user_id;
    
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public String getMeeting_location() {
		return meeting_location;
	}
	public void setMeeting_location(String meeting_location) {
		this.meeting_location = meeting_location;
	}
	public LocalDateTime getMeeting_time() {
		return meeting_time;
	}
	public void setMeeting_time(LocalDateTime meeting_time) {
		this.meeting_time = meeting_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
}