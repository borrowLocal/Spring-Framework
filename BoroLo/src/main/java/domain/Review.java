package domain;

import java.time.LocalDateTime;

public class Review {
    private Integer review_id;
    private String content;
    private Integer rating;
    private LocalDateTime created_at;
    private Integer rental_id;
    private Integer user_write_id;
    private Integer user_target_id;

    public Integer getReview_id() { return review_id; }
    public void setReview_id(Integer review_id) { this.review_id = review_id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }
    
    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }

    public Integer getRental_id() { return rental_id; }
    public void setRental_id(Integer rental_id) { this.rental_id = rental_id; }

    public Integer getUser_write_id() { return user_write_id; }
    public void setUser_write_id(Integer user_write_id) { this.user_write_id = user_write_id; }

    public Integer getUser_target_id() { return user_target_id; }
    public void setUser_target_id(Integer user_target_id) { this.user_target_id = user_target_id; }
}