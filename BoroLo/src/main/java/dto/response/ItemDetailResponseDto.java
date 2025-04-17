package dto.response;

public class ItemDetailResponseDto {
    private Integer item_id;
    private String title;
    private String description;
    private Integer price_per_day;
    private Integer deposit_amount;
    private String image_url;
    private String location;
    private String item_status;
    private String category_name;
    private String owner_nick_name;
    private Float owner_rating;
    
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice_per_day() {
		return price_per_day;
	}
	public void setPrice_per_day(Integer price_per_day) {
		this.price_per_day = price_per_day;
	}
	public Integer getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(Integer deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getItem_status() {
		return item_status;
	}
	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getOwner_nick_name() {
		return owner_nick_name;
	}
	public void setOwner_nick_name(String owner_nick_name) {
		this.owner_nick_name = owner_nick_name;
	}
	public Float getOwner_rating() {
		return owner_rating;
	}
	public void setOwner_rating(Float owner_rating) {
		this.owner_rating = owner_rating;
	}
}