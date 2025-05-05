package domain;

import java.time.LocalDateTime;

public class Item {
    private Integer item_id;
    private String title;
    private String description;
    private Integer quantity;
    private Integer price_per_day;
    private Integer deposit_amount;
    private String image_url;
    private String location;
    private String item_status;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private Integer user_id;
    private Integer category_id;

    public Integer getItem_id() { return item_id; }
    public void setItem_id(Integer item_id) { this.item_id = item_id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public Integer getPrice_per_day() { return price_per_day; }
    public void setPrice_per_day(Integer price_per_day) { this.price_per_day = price_per_day; }

    public Integer getDeposit_amount() { return deposit_amount; }
    public void setDeposit_amount(Integer deposit_amount) { this.deposit_amount = deposit_amount; }

    public String getImage_url() { return image_url; }
    public void setImage_url(String image_url) { this.image_url = image_url; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getItem_status() { return item_status; }
    public void setItem_status(String item_status) { this.item_status = item_status; }

    public LocalDateTime getCreate_time() { return create_time; }
    public void setCreate_time(LocalDateTime create_time) { this.create_time = create_time; }

    public LocalDateTime getUpdate_time() { return update_time; }
    public void setUpdate_time(LocalDateTime update_time) { this.update_time = update_time; }

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public Integer getCategory_id() { return category_id; }
    public void setCategory_id(Integer category_id) { this.category_id = category_id; }
}