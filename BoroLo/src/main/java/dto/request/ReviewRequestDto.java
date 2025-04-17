package dto.request;

public class ReviewRequestDto {
    private Integer rental_id;
    private Integer user_target_id;
    private String content;
    private Integer rating;
    
	public Integer getRental_id() {
		return rental_id;
	}
	public void setRental_id(Integer rental_id) {
		this.rental_id = rental_id;
	}
	public Integer getUser_target_id() {
		return user_target_id;
	}
	public void setUser_target_id(Integer user_target_id) {
		this.user_target_id = user_target_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}