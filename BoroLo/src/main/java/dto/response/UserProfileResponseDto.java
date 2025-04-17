package dto.response;

public class UserProfileResponseDto {
    private String real_name;
    private String nick_name;
    private Float rating;
    private Integer favorite_count;
    private Integer item_count;
    private Integer rental_count;
    
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Integer getFavorite_count() {
		return favorite_count;
	}
	public void setFavorite_count(Integer favorite_count) {
		this.favorite_count = favorite_count;
	}
	public Integer getItem_count() {
		return item_count;
	}
	public void setItem_count(Integer item_count) {
		this.item_count = item_count;
	}
	public Integer getRental_count() {
		return rental_count;
	}
	public void setRental_count(Integer rental_count) {
		this.rental_count = rental_count;
	}
}